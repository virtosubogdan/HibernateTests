package com.example.hibernatetests.data.bears.dao;

import com.example.hibernatetests.data.bears.entities.PapaBear;
import com.example.hibernatetests.data.bears.entities.PapaBearPK;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bogdan.virtosu on 04.02.2015.
 */
public interface PapaBearDAO extends CrudRepository<PapaBear, PapaBearPK> {
}
