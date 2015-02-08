package com.example.hibernatetests.data.bears.logic;


import com.example.hibernatetests.data.bears.to.PapaBearTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstService implements BearService {

    @Override
    public void saveTheBears(List<PapaBearTO> papaBearTOs, Long bearContextId) {
        throw new RuntimeException("Not implemented");
    }
}
