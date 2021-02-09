package com.sample.demo.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.demo.model.Visitor;
import com.sample.demo.repo.VisitorRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/visitors")
@CrossOrigin
public class VisitorController {
    
    private VisitorRepository visitorRepository;

    @GetMapping
    @ResponseBody
    public List<Visitor> visitors() {
        return StreamSupport.stream(visitorRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody String visitorAsString)
            throws JsonMappingException, JsonProcessingException {
        Visitor visitor = new ObjectMapper().readValue(visitorAsString, Visitor.class);
        visitorRepository.save(visitor);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }

}
