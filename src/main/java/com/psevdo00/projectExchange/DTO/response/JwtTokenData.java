package com.psevdo00.projectExchange.DTO.response;

import java.util.List;
import java.util.Map;

public class JwtTokenData {

    private Long exp;
    private Long iat;
    private Long auth_time;
    private String jti;
    private String iss;
    private String aud;
    private String sub;
    private String typ;
    private String azp;
    private String nonce;
    private String session_state;
    private String acr;

    private Map<String, List<String>> realm_access;
    private Map<String, Map<String, List<String>>> resource_access;

    private String scope;
    private Boolean email_verified;
    private String mapping_id;
    private String name;
    private List<String> cohort;
    private String preferred_username;
    private String given_name;
    private String middle_name;
    private String family_name;
    private String first_name;
    private String email;
    private String syncable_cohorts;

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public Long getAuth_time() {
        return auth_time;
    }

    public void setAuth_time(Long auth_time) {
        this.auth_time = auth_time;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public Map<String, List<String>> getRealm_access() {
        return realm_access;
    }

    public void setRealm_access(Map<String, List<String>> realm_access) {
        this.realm_access = realm_access;
    }

    public Map<String, Map<String, List<String>>> getResource_access() {
        return resource_access;
    }

    public void setResource_access(Map<String, Map<String, List<String>>> resource_access) {
        this.resource_access = resource_access;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Boolean getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(Boolean email_verified) {
        this.email_verified = email_verified;
    }

    public String getMapping_id() {
        return mapping_id;
    }

    public void setMapping_id(String mapping_id) {
        this.mapping_id = mapping_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCohort() {
        return cohort;
    }

    public void setCohort(List<String> cohort) {
        this.cohort = cohort;
    }

    public String getPreferred_username() {
        return preferred_username;
    }

    public void setPreferred_username(String preferred_username) {
        this.preferred_username = preferred_username;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSyncable_cohorts() {
        return syncable_cohorts;
    }

    public void setSyncable_cohorts(String syncable_cohorts) {
        this.syncable_cohorts = syncable_cohorts;
    }
}
