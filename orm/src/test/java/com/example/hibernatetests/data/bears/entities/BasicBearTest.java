package com.example.hibernatetests.data.bears.entities;

import com.example.hibernatetests.data.bears.dao.*;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
//This will prevent jdbc:initialize-database
//@DatabaseSetup("classpath:bearBasicSetup.xml")
public class BasicBearTest {

    private static Logger logger = LoggerFactory.getLogger(BasicBearTest.class);

    @Autowired
    private BearContextDAO bearContextDAO;

    @Autowired
    private PapaBearDAO papaBearDAO;

    @Autowired
    private MamaBearDAO mamaBearDAO;

    @Autowired
    private BabyBearDAO babyBearDAO;

    @Autowired
    private BearToyDAO bearToyDAO;

    @Test
    @Transactional
    public void sanityCheck() {
        BearContext bearContext = bearContextDAO.findOne(1L);
        assertNotNull(bearContext);
        assertEquals(bearContext.getPapaBears().size(), 2);

        PapaBearPK papaBearPK = new PapaBearPK();
        papaBearPK.setBearContext(bearContext);
        papaBearPK.setPapaBearId(1L);
        PapaBear papaBear = papaBearDAO.findOne(papaBearPK);
        assertNotNull(papaBear);
        assertEquals(papaBear.getMamaBears().size(), 2);

        MamaBearPK mamaBearPK = new MamaBearPK();
        mamaBearPK.setPapaBear(papaBear);
        mamaBearPK.setMamaBearId(1L);
        MamaBear mamaBear = mamaBearDAO.findOne(mamaBearPK);
        assertNotNull(mamaBear);
        assertEquals(mamaBear.getBabyBears().size(), 2);

        BabyBearPK babyBearPK = new BabyBearPK();
        babyBearPK.setMamaBear(mamaBear);
        babyBearPK.setBabyBearId(1L);
        BabyBear babyBear = babyBearDAO.findOne(babyBearPK);
        assertNotNull(babyBear);
        assertEquals(babyBear.getBearToys().size(), 2);

        BearToyPK bearToyPK = new BearToyPK();
        bearToyPK.setBabyBear(babyBear);
        bearToyPK.setBearToyId(1L);
        BearToy bearToy = bearToyDAO.findOne(bearToyPK);
        assertNotNull(bearToy);

        BearToyPK nonExistentBearToyPK = new BearToyPK();
        nonExistentBearToyPK.setBabyBear(babyBear);
        nonExistentBearToyPK.setBearToyId(3L);
        BearToy nonExistentBearToy = bearToyDAO.findOne(nonExistentBearToyPK);
        assertNull(nonExistentBearToy);
    }
}
