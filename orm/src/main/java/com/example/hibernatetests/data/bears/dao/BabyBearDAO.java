package com.example.hibernatetests.data.bears.dao;

import com.example.hibernatetests.data.bears.entities.BabyBear;
import com.example.hibernatetests.data.bears.entities.BabyBearPK;
import org.springframework.data.repository.CrudRepository;

public interface BabyBearDAO extends CrudRepository<BabyBear, BabyBearPK> {
}
