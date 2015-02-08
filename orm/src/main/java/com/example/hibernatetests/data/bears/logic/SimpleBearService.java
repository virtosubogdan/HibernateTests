package com.example.hibernatetests.data.bears.logic;


import com.example.hibernatetests.data.bears.dao.PapaBearDAO;
import com.example.hibernatetests.data.bears.entities.BabyBear;
import com.example.hibernatetests.data.bears.entities.BearToy;
import com.example.hibernatetests.data.bears.entities.MamaBear;
import com.example.hibernatetests.data.bears.entities.PapaBear;
import com.example.hibernatetests.data.bears.to.BabyBearTO;
import com.example.hibernatetests.data.bears.to.BearToyTO;
import com.example.hibernatetests.data.bears.to.MamaBearTO;
import com.example.hibernatetests.data.bears.to.PapaBearTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Primary
public class SimpleBearService implements BearService {

    @Autowired
    private BearGrylls bearGrylls;

    @Autowired
    private PapaBearDAO papaBearDAO;

    @Override
    public void saveTheBears(List<PapaBearTO> papaBearTOs, Long bearContextId) {
        for (PapaBearTO papaBearTO : papaBearTOs) {
            PapaBear papaBear = bearGrylls.findPapaBear(papaBearTO.getBearContextId(), papaBearTO.getPapaBearId());
            if (papaBear != null) {
                papaBear.getMamaBears().clear();
            } else {
                papaBear = bearGrylls.createPapaBear(bearContextId, papaBearTO);
                papaBear.setMamaBears(new HashSet<MamaBear>());
            }
            addMamaBears(papaBear, papaBear.getMamaBears(), papaBearTO.getMamaBearTOs());
            papaBear.setName(papaBearTO.getName());
            papaBearDAO.save(papaBear);
        }
    }

    private void addMamaBears(PapaBear papaBear, Set<MamaBear> mamaBears, Set<MamaBearTO> mamaBearTOs) {
        for (MamaBearTO mamaBearTO : mamaBearTOs) {
            MamaBear mamaBear = bearGrylls.createMamaBear(papaBear, mamaBearTO);
            mamaBear.setName(mamaBearTO.getName());
            mamaBear.setBabyBears(createBabyBears(mamaBear, mamaBearTO.getBabyBearTOs()));
            mamaBears.add(mamaBear);
        }
    }

    private Set<BabyBear> createBabyBears(MamaBear mamaBear, Set<BabyBearTO> babyBearTOs) {
        Set<BabyBear> babyBears = new HashSet<>();
        for (BabyBearTO babyBearTO : babyBearTOs) {
            BabyBear babyBear = bearGrylls.createBabyBear(mamaBear, babyBearTO);
            babyBear.setName(babyBearTO.getName());
            babyBears.add(babyBear);
            babyBear.setBearToys(createBearToys(babyBear, babyBearTO.getBearToyTOs()));
        }
        return babyBears;
    }

    private Set<BearToy> createBearToys(BabyBear babyBear, Set<BearToyTO> bearToyTOs) {
        Set<BearToy> bearToys = new HashSet<>();
        for (BearToyTO bearToyTO : bearToyTOs) {
            BearToy bearToy = bearGrylls.createBearToy(babyBear, bearToyTO);
            bearToy.setName(bearToyTO.getName());
            bearToys.add(bearToy);
        }
        return bearToys;
    }
}
