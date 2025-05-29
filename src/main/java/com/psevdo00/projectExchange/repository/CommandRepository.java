package com.psevdo00.projectExchange.repository;

import com.psevdo00.projectExchange.entity.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandRepository extends JpaRepository<CommandEntity, Long> {

    Optional<CommandEntity> findById(Long id);

    List<CommandEntity> findAll();

}
