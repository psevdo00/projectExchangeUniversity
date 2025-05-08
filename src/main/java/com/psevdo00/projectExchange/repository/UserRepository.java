package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    Optional<UserEntity> findById(Long id);

    @Query("select user from UserEntity user where user.role = 'STUDENT'")
    List<UserEntity> findAllStudent();

    @Query("select user from UserEntity user where user.role = 'PROFESSOR'")
    List<UserEntity> findAllProfessor();

}
