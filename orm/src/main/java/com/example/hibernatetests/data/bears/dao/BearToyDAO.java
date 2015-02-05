package com.example.hibernatetests.data.bears.dao;

import com.example.hibernatetests.data.bears.entities.BearToy;
import com.example.hibernatetests.data.bears.entities.BearToyPK;
import org.springframework.data.repository.CrudRepository;

public interface BearToyDAO extends CrudRepository<BearToy, BearToyPK> {
}
