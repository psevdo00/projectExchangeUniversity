package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.entity.TagTechnologyEntity;
import com.psevdo00.projectExchange.repository.TagTechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagTechnologyService {

    private final TagTechnologyRepository repository;

    public TagTechnologyService(TagTechnologyRepository repository){

        this.repository = repository;

    }

    public List<TagTechnologyEntity> findAll(){

        return repository.findAll();

    }

}
