package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.entity.TagTechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagTechnologyRepository extends JpaRepository<TagTechnologyEntity, Long> {

    List<TagTechnologyEntity> findAll();

}
