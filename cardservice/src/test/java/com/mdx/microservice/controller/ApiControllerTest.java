////////////////////////////////////////////////////////////////////////
//
//	@Id: ApiControllerTest.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the ApiControllerTest class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdx.microservice.data.domain.Deck;
import com.mdx.microservice.service.DealerService;
import com.mdx.microservice.strategy.CardShuffleStrategy;


@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest
{
	// [ data-members..!]
	@Mock
	private static DealerService dealerService;

	@Mock
	private static CardShuffleStrategy cardShuffleStrategy;

	@InjectMocks
	private static ApiController controller  = new ApiController(dealerService, cardShuffleStrategy);

	private static Deck deck;
	
	private static MockMvc mockMvc;

	// singleton instance of the Logger object..!
	private static final Logger logger = Logger.getLogger(ApiControllerTest.class.getName());

	@Before
	public void setUp() 
	{
		logger.info("============================");
		logger.info("setting up the testcase..");
		logger.info("============================");
		MockitoAnnotations.initMocks(this);
		//ReflectionTestUtils.setField(instance, "socialContext", socialContext);		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).addFilters(new CorsFilter()).build();
		//We have to reset our mock between tests because the mock objects
		//are managed by the Spring container. If we would not reset them,
		//stubbing and verified behavior would "leak" from one test to another.
//		Mockito.reset(cardShuffleStrategy);		
//		Mockito.reset(dealerService);
		// setting up the mock-conditions
		deck = new Deck("deck1");
		when(dealerService.getDeck(any(String.class))).thenReturn(deck);
		when(dealerService.createDeck(any(Deck.class))).thenReturn(deck);
	}

	@After
	public void tearDown() 
	{
		logger.info("============================");
		logger.info("tearing up the testcase..");
		logger.info("============================");

		//We have to reset our mock between tests because the mock objects
		//are managed by the Spring container. If we would not reset them,
		//stubbing and verified behavior would "leak" from one test to another.
		Mockito.reset(cardShuffleStrategy);		
		Mockito.reset(dealerService);
	}
	
	@Test
	public void testGetDeck() throws Exception {
		final String METHOD_NAME = "testGetDeck";
		logger.info(METHOD_NAME);		// setting up the mock-conditions
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					get("/cardservice/api/decks/deck1")
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		verify(dealerService, times(1)).getDeck(deck.getName());
		verifyNoMoreInteractions(dealerService);
	}

	@Test
	public void testGetDeckWhichDoesNotExist() throws Exception {
		final String METHOD_NAME = "testGetDeckWhichDoesNotExist";
		logger.info(METHOD_NAME);		// setting up the mock-conditions
		// setting up the mock-conditions
		when(dealerService.getDeck(any(String.class))).thenReturn(null);
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					get("/cardservice/api/decks/deckINVALID").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound());
		verify(dealerService, times(1)).getDeck("deckINVALID");
		verifyNoMoreInteractions(dealerService);
	}

	@Test
	public void testGetAllDecks() throws Exception {
		final String METHOD_NAME = "testGetAllDecks";
		logger.info(METHOD_NAME);
		List<Deck> decks = Arrays.asList(new Deck("deck1"), new Deck("Deck2"));
		// setting up the mock-conditions
		when(dealerService.getAllDecks()).thenReturn(decks);
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					get("/cardservice/api/decks")
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		verify(dealerService, times(1)).getAllDecks();
		verifyNoMoreInteractions(dealerService);
	}

	@Test
	public void testShuffleDeck() throws Exception {
		final String METHOD_NAME = "testShuffleDeck()";
		logger.info(METHOD_NAME);
		// setting up the mock-conditions
		when(cardShuffleStrategy.shuffleDeck(any(Deck.class))).thenReturn(deck);
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					post("/cardservice/api/decks/deck1")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(deck)))
					.andExpect(status().isCreated());
	}

	@Test
	public void testShuffleDeckWhichDoesNotExist() throws Exception {
		final String METHOD_NAME = "testShuffleDeckWhichDoesNotExist()";
		logger.info(METHOD_NAME);
		// setting up the mock-conditions
		when(dealerService.getDeck(any(String.class))).thenReturn(null);
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					post("/cardservice/api/decks/deckINVALID")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(deck)))
					.andExpect(status().isNotFound());
	}

	@Test
	public void testCreateDeck() throws Exception {
		final String METHOD_NAME = "testCreateDeck";
		logger.info(METHOD_NAME);
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					put("/cardservice/api/decks")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(deck)))
					.andExpect(status().isOk());
	}

	@Test
	public void testRemoveDeck() throws Exception {
		final String METHOD_NAME = "testRemoveDeck";
		logger.info(METHOD_NAME);
		// setting up the mock-conditions
		doNothing().when(dealerService).removeDeck(any(String.class));
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					delete("/cardservice/api/decks/deck4")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(deck)))
					.andExpect(status().isOk());
	}

	@Test
	public void testRemoveDeckWhichDoesNotExist() throws Exception {
		final String METHOD_NAME = "testRemoveDeckWhichDoesNotExist";
		logger.info(METHOD_NAME);
		// setting up the mock-conditions
		when(dealerService.getDeck(any(String.class))).thenReturn(null);
		doNothing().when(dealerService).removeDeck(any(String.class));
		// invoking the method to be tested on the subject under test
		mockMvc.perform(
					delete("/cardservice/api/decks/deckINVALID")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(deck)))
					.andExpect(status().isNotFound());
	}

	/*
	 * converts a Java object into JSON representation
	 */
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}