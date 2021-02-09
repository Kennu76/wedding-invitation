package com.sample.demo.repo;

import com.sample.demo.model.Visitor;

import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {}