package com.example.hibernatetests.data.bears.logic;


import com.example.hibernatetests.data.bears.to.PapaBearTO;

import java.util.List;

public interface BearService {

    public void saveTheBears(List<PapaBearTO> papaBearTOs, Long bearContextId);
}
