package com.example.hibernatetests.data.bears.dao;

import com.example.hibernatetests.data.bears.entities.BearContext;
import org.springframework.data.repository.CrudRepository;

public interface BearContextDAO extends CrudRepository<BearContext, Long> {
}
