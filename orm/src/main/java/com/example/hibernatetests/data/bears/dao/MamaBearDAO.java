package com.example.hibernatetests.data.bears.dao;

import com.example.hibernatetests.data.bears.entities.MamaBear;
import com.example.hibernatetests.data.bears.entities.MamaBearPK;
import org.springframework.data.repository.CrudRepository;

public interface MamaBearDAO extends CrudRepository<MamaBear, MamaBearPK> {
}
