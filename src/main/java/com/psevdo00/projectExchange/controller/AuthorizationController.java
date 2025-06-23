package com.psevdo00.projectExchange.controller;

import jakarta.servlet.http.HttpServletRequest;
import com.psevdo00.projectExchange.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("api/authorization")
public class AuthorizationController {

    private static final String CLIENT_ID = "project-3dev";
    private static final String CLIENT_SECRET = "c13c2272-77ac-4ed6-80d4-e311f9bfd1a3";
    private static final String REDIRECT_URI = "http://localhost:8080/api/authorization/callback";
    private static final String AUTH_SERVER_URL = "https://auth.sevsu.ru/realms/portal";

    private final UserService userService;
    private final SessionController sessionController;

    public AuthorizationController(UserService userService, SessionController sessionController) {
        this.userService = userService;
        this.sessionController = sessionController;
    }

    @GetMapping("/generateUrl")
    public RedirectView generateUrlToAuthorization() {
        String state = generateRandomToken(16);
        String nonce = generateRandomToken(16);

        String authUrl = AUTH_SERVER_URL + "/protocol/openid-connect/auth" +
                "?client_id=" + CLIENT_ID +
                "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8) +
                "&state=" + state +
                "&response_mode=query" +
                "&response_type=code" +
                "&scope=openid" +
                "&nonce=" + nonce;

        return new RedirectView(authUrl);
    }

    @GetMapping("/callback")
    public RedirectView handleOAuth2Callback(@RequestParam("code") String authCode, @RequestParam("session_state") String sessionState, HttpServletRequest request) {

        HttpSession session = request.getSession();

        ResponseEntity response = getAccessToken(authCode);

        Long userId = userService.decodingAccessToken(response);
        sessionController.setSessionState(sessionState, session);

        return new RedirectView("http://192.168.0.114:3000?userId=" + userId);

    }

    @GetMapping("/check-auth")
    public ResponseEntity<?> checkAuth(HttpSession session) {
        if (session.getAttribute("access_token") != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }

    public ResponseEntity<Map> getAccessToken(String authCode) {

        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = AUTH_SERVER_URL + "/protocol/openid-connect/token";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", CLIENT_ID);
        body.add("code", authCode);
        body.add("redirect_uri", REDIRECT_URI);
        body.add("client_secret", CLIENT_SECRET);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        return restTemplate.postForEntity(tokenUrl, request, Map.class);

    }

    private String generateRandomToken(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}

