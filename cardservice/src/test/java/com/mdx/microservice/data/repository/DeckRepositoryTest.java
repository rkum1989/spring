//////////////////////////////////////////////////////////////////////////
////
////	@Id: DeckRepositoryTest.java
////  @Author: Shekhar Cambam
////
////	Purpose:
////	Contains the DeckRepositoryTest class definition.
////
////	All rights reserved.
////
//////////////////////////////////////////////////////////////////////////
//package com.mdx.microservice.data.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.assertThat;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import com.mdx.microservice.Application;
//import com.mdx.microservice.data.domain.Deck;
//import com.mdx.microservice.data.repository.DeckRepository;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("default")
//public class DeckRepositoryTest
//{
//    @Autowired
//    private DeckRepository repository;
//
//	// singleton instance of the Logger object..!
//	private static final Logger logger = Logger.getLogger(DeckRepositoryTest.class.getName());
//	
//    @Before
//    public void setUp() 
//    {
//        //PropertiesConfigurator is used to configure logger from properties file
//        logger.info("============================");
//        logger.debug("setting up the testcase..");
//        logger.info("============================");
//    	repository.save(new Deck("deck-random1"));
//    	repository.save(new Deck("deck-random2"));
//    	repository.save(new Deck("deck-hand1"));
//    	repository.save(new Deck("deck-hand2"));
//    	repository.save(new Deck("deck-hand3"));
//    }
//
//    @After
//    public void tearDown() 
//    {
//        logger.info("============================");
//        logger.debug("tearing down the testcase..");
//        logger.info("============================");
//        Page<Deck> decks = repository.findAll(new PageRequest(0, 10));
//        assertThat(decks, notNullValue());
//        List<Deck> deckslist = decks.getContent();
//        for(Deck deck : deckslist) {
//        	repository.delete(deck);
//        }
//    }
//
//    @Test
//    public void testFindAll() 
//    {
//        logger.info("============================");
//        logger.info("testFindAll..");
//        logger.info("============================");
//        Page<Deck> decks = repository.findAll(new PageRequest(0, 10));
//        assertThat(decks, notNullValue());
//        assertThat(decks.getTotalElements(), is(equalTo(5L)));
//    }
//
//    @Test
//    public void testFindByName() 
//    {
//        logger.info("============================");
//        logger.info("testFindByName..");
//        logger.info("============================");
//        Deck deck = repository.findByName("deck-hand1");
//        assertThat(deck, notNullValue());
//        assertThat(deck.getCards(), notNullValue());
//        assertThat(deck.getCards().size(),  is(equalTo(52)));
//    }
//    
//}