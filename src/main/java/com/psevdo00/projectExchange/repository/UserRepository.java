package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.DTO.response.ProfessorDTO;
import com.psevdo00.projectExchange.DTO.response.StudentDTO;
import com.psevdo00.projectExchange.entity.StudentEntity;
import com.psevdo00.projectExchange.entity.UserEntity;
import com.psevdo00.projectExchange.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    @Query("select u.role from UserEntity u where u.id = :id")
    UserRoleEnum findRoleById(@Param("id") Long id);

    @Query("SELECT new com.psevdo00.projectExchange.DTO.response.StudentDTO(u.id, u.username, u.firstName, u.familyName, u.middleName, u.email, s.command.id, u.role) FROM UserEntity u JOIN StudentEntity s ON u.id = s.user.id WHERE u.id = :id")
    Optional<StudentDTO> findStudentDtoById(@Param("id") Long id);

    @Query("SELECT new com.psevdo00.projectExchange.DTO.response.ProfessorDTO(u.id, u.username, u.firstName, u.familyName, u.middleName, u.email, null, u.role) FROM UserEntity u JOIN ProfessorEntity p ON u.id = p.userId WHERE u.id = :id")
    Optional<ProfessorDTO> findProfessorDtoById(@Param("id") Long id);

    @Query("SELECT s FROM StudentEntity s WHERE s.user.id = :id")
    Optional<StudentEntity> findStudentById(@Param("id") Long id);

    @Query("select user from UserEntity user where user.role = com.psevdo00.projectExchange.enums.UserRoleEnum.STUDENT")
    List<UserEntity> findAllStudent();

    @Query("select user from UserEntity user where user.role = com.psevdo00.projectExchange.enums.UserRoleEnum.PROFESSOR")
    List<UserEntity> findAllProfessor();

}
