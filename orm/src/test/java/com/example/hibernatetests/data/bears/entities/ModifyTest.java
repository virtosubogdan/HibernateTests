package com.example.hibernatetests.data.bears.entities;

import com.example.hibernatetests.data.bears.logic.BearGrylls;
import com.example.hibernatetests.data.bears.logic.BearService;
import com.example.hibernatetests.data.bears.to.BabyBearTO;
import com.example.hibernatetests.data.bears.to.MamaBearTO;
import com.example.hibernatetests.data.bears.to.PapaBearTO;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:bearBasicSetup.xml")
//@Sql({"src/test/resources/bearsDDL.sql"})
public class ModifyTest {

    @Autowired
    private BearService bearService;

    @Autowired
    private BearGrylls bearGrylls;

    @Test
    @Transactional
    public void changePapaBearName() {
        assertEquals(bearGrylls.findPapaBear(1L, 2L).getName(), "Scar");

        changePapaBearNameTransaction();

        assertEquals(bearGrylls.findPapaBear(1L, 2L).getName(), "NotScar");
    }

    @Transactional
    private void changePapaBearNameTransaction() {
        PapaBearTO papaBearTO = new PapaBearTO(1L, 1L, "LionKing");
        PapaBearTO papaBearTO2 = new PapaBearTO(1L, 2L, "NotScar");

        List<PapaBearTO> papaBearTOs = new LinkedList<>();
        papaBearTOs.add(papaBearTO);
        papaBearTOs.add(papaBearTO2);
        bearService.saveTheBears(papaBearTOs, 1L);
    }

    @Test
    @Transactional
    public void changeMamaBearName() {
        assertEquals(bearGrylls.findMamaBear(1L, 1L, 2L).getName(), "Not used");

        PapaBearTO papaBearTO = new PapaBearTO(1L, 1L, "LionKing");
        MamaBearTO mamaBearTO = new MamaBearTO(1L, 1L, 2L, "Test used");
        papaBearTO.getMamaBearTOs().add(mamaBearTO);

        List<PapaBearTO> papaBearTOs = new LinkedList<>();
        papaBearTOs.add(papaBearTO);
        bearService.saveTheBears(papaBearTOs, 1L);


        assertEquals(bearGrylls.findMamaBear(1L, 1L, 2L).getName(), "Test used");
    }

    @Test
    @Transactional
    public void changeBabyBearName() {
        assertEquals(bearGrylls.findBabyBear(1L, 1L, 1L, 1L).getName(), "B1");

        PapaBearTO papaBearTO = new PapaBearTO(1L, 1L, "LionKing");
        MamaBearTO mamaBearTO = new MamaBearTO(1L, 1L, 1L, "Test used");
        BabyBearTO babyBearTO = new BabyBearTO(1L, 1L, 1L, 1L, "Modified");
        mamaBearTO.getBabyBearTOs().add(babyBearTO);
        papaBearTO.getMamaBearTOs().add(mamaBearTO);

        List<PapaBearTO> papaBearTOs = new LinkedList<>();
        papaBearTOs.add(papaBearTO);
        bearService.saveTheBears(papaBearTOs, 1L);

        assertEquals(bearGrylls.findBabyBear(1L, 1L, 1L, 1L).getName(), "Modified");
    }
}
