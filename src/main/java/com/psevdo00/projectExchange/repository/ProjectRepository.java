package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.enums.TypeProjectEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    Optional<ProjectEntity> findById(Long id);

    List<ProjectEntity> findByUniversity(String university);

    @Query("select p from ProjectEntity p where p.title like concat('%', :title ,'%')")
    List<ProjectEntity> findByTitle(@Param("title") String title);

    List<ProjectEntity> findAll();

    @Query("select distinct p from ProjectEntity p join p.tags t where t.technology in (:tags)")
    List<ProjectEntity> findByTagsIn(@Param("tags") List<String> tags);

    @Query("select p from ProjectEntity p where p.flag_completed = :flag")
    List<ProjectEntity> findByFlag_completed(@Param("flag") boolean flag);

    List<ProjectEntity> findBySubjectArea(String subjectArea);

    List<ProjectEntity> findByProjectYear(Year projectYear);

    List<ProjectEntity> findByType(TypeProjectEnum type);

}
