package com.example.hibernatetests.data.bears.logic;


import com.example.hibernatetests.data.bears.dao.BabyBearDAO;
import com.example.hibernatetests.data.bears.dao.BearContextDAO;
import com.example.hibernatetests.data.bears.dao.MamaBearDAO;
import com.example.hibernatetests.data.bears.dao.PapaBearDAO;
import com.example.hibernatetests.data.bears.entities.*;
import com.example.hibernatetests.data.bears.to.BabyBearTO;
import com.example.hibernatetests.data.bears.to.BearToyTO;
import com.example.hibernatetests.data.bears.to.MamaBearTO;
import com.example.hibernatetests.data.bears.to.PapaBearTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BearGrylls {

    @Autowired
    private BearContextDAO bearContextDAO;

    @Autowired
    private PapaBearDAO papaBearDAO;

    @Autowired
    private MamaBearDAO mamaBearDAO;

    @Autowired
    private BabyBearDAO babyBearDAO;

    private BearContext tryFindContext(Long bearContextId) {
        return bearContextDAO.findOne(bearContextId);
    }

    public BearContext findContext(Long bearContextId) {
        BearContext bearContext = tryFindContext(bearContextId);
        Assert.notNull(bearContext);
        return bearContext;
    }

    public PapaBear tryFindPapaBear(Long contextId, Long papaBearId) {
        PapaBearPK papaBearPK = new PapaBearPK();
        papaBearPK.setBearContext(findContext(contextId));
        papaBearPK.setPapaBearId(papaBearId);
        return papaBearDAO.findOne(papaBearPK);
    }

    public PapaBear findPapaBear(Long contextId, Long papaBearId) {
        PapaBear papaBear = tryFindPapaBear(contextId, papaBearId);
        Assert.notNull(papaBear);
        return papaBear;
    }

    public PapaBear createPapaBear(Long bearContextId, PapaBearTO papaBearTO) {
        PapaBearPK papaBearPK = new PapaBearPK();
        papaBearPK.setPapaBearId(papaBearTO.getPapaBearId());
        papaBearPK.setBearContext(findContext(bearContextId));
        PapaBear papaBear = new PapaBear();
        papaBear.setEmbeddedId(papaBearPK);
        return papaBear;
    }

    public MamaBear createMamaBear(PapaBear papaBear, MamaBearTO mamaBearTO) {
        MamaBearPK mamaBearPK = new MamaBearPK();
        mamaBearPK.setMamaBearId(mamaBearTO.getMamaBearId());
        mamaBearPK.setPapaBear(papaBear);
        MamaBear mamaBear = new MamaBear();
        mamaBear.setEmbeddedId(mamaBearPK);
        return mamaBear;
    }

    public BabyBear createBabyBear(MamaBear mamaBear, BabyBearTO babyBearTO) {
        BabyBearPK babyBearPK = new BabyBearPK();
        babyBearPK.setBabyBearId(babyBearTO.getBabyBearId());
        babyBearPK.setMamaBear(mamaBear);
        BabyBear babyBear = new BabyBear();
        babyBear.setEmbeddedId(babyBearPK);
        return babyBear;
    }

    public BearToy createBearToy(BabyBear babyBear, BearToyTO bearToyTO) {
        BearToyPK bearToyPK = new BearToyPK();
        bearToyPK.setBabyBear(babyBear);
        bearToyPK.setBearToyId(bearToyTO.getBearToyId());
        BearToy bearToy = new BearToy();
        bearToy.setEmbeddedId(bearToyPK);
        return bearToy;
    }

    public MamaBear findMamaBear(Long contextId, Long papaBearId, Long mamaBearId) {
        MamaBear mamaBear = tryFindMamaBear(contextId, papaBearId, mamaBearId);
        Assert.notNull(mamaBear);
        return mamaBear;
    }

    public MamaBear tryFindMamaBear(Long contextId, Long papaBearId, Long mamaBearId) {
        MamaBearPK mamaBearPK = new MamaBearPK();
        mamaBearPK.setPapaBear(findPapaBear(contextId, papaBearId));
        mamaBearPK.setMamaBearId(mamaBearId);
        return mamaBearDAO.findOne(mamaBearPK);
    }

    public BabyBear findBabyBear(Long contextId, Long papaBearId, Long mamaBearId, Long babyBearId) {
        BabyBear babyBear = tryFindBabyBear(contextId, papaBearId, mamaBearId, babyBearId);
        Assert.notNull(babyBear);
        return babyBear;
    }

    private BabyBear tryFindBabyBear(Long contextId, Long papaBearId, Long mamaBearId, Long babyBearId) {
        BabyBearPK babyBearPK = new BabyBearPK();
        babyBearPK.setMamaBear(findMamaBear(contextId, papaBearId, mamaBearId));
        babyBearPK.setBabyBearId(babyBearId);
        return babyBearDAO.findOne(babyBearPK);
    }
}
