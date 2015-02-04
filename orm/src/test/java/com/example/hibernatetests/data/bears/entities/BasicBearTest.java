package com.example.hibernatetests.data.bears.entities;

import com.example.hibernatetests.data.bears.dao.PapaBearDAO;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:bearBasicSetup.xml")
public class BasicBearTest {

    private static Logger logger = LoggerFactory.getLogger(BasicBearTest.class);

    @Autowired
    private PapaBearDAO papaBearDAO;

    @Test
    public void seeEmptyContext() {
        logger.warn("Running basic test");
        for (PapaBear papaBear : papaBearDAO.findAll()) {
            Assert.assertTrue(false);
        }
    }
}
