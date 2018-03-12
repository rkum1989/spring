////////////////////////////////////////////////////////////////////////
//
//	@Id: DealerServiceTest.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the DealerServiceTest class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.mdx.microservice.controller.ApiController;
import com.mdx.microservice.data.domain.Deck;
import com.mdx.microservice.data.repository.DeckRepository;
import com.mdx.microservice.exceptions.ObjectNotFoundException;
//import com.mdx.microservice.exceptions.ObjectNotFoundException;
import com.mdx.microservice.strategy.CardShuffleStrategy;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class DealerServiceTest {

	// [ data-members..!]
	@Mock
	private DeckRepository deckRepository;

	@Mock
	private CardShuffleStrategy cardShuffleStrategy;
	
	@InjectMocks
	private DealerService dealerService = new DealerService();
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	// singleton instance of the Logger object..!
	private static final Logger logger = Logger.getLogger(ApiController.class.getName());

	@Before
	public void setUp() {
		// setting the data-members of the subject under test.
		ReflectionTestUtils.setField(dealerService, "deckRepository", deckRepository, DeckRepository.class);		
		ReflectionTestUtils.setField(dealerService, "cardShuffleStrategy", cardShuffleStrategy, CardShuffleStrategy.class);		
	}
	
	@Test
	public void testCreateDeck() {
		Deck deck = new Deck("deck4");
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		when(deckRepository.saveAndFlush(any(Deck.class))).thenReturn(deck);
		Deck deck1 = dealerService.createDeck(deck);
		assertThat(deck1, notNullValue());
		assertThat(deck1.getName(), notNullValue());
		assertThat(deck1.getCards(), notNullValue());
		assertThat(deck1.getCards().size(), is(equalTo(52)));
	}

	@Test
	public void testGetDeck() {
		String deckName = "deck1";
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = new Deck(deckName);
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		when(deckRepository.findByName(any(String.class))).thenReturn(deck);
		deck = dealerService.getDeck(deckName);
		assertThat(deck, notNullValue());
	}

	@Test  
	public void testGetDeckWhichDoesNotExist() {
		String deckName = "deckNotFound";
		Deck deck = new Deck(deckName);
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		doThrow(ObjectNotFoundException.class).when(deckRepository).findByName(any(String.class));
		logger.info("Configure the expected execption to be ObjectNotFoundException");
        thrown.expect(ObjectNotFoundException.class);
		dealerService.getDeck(deckName);
		logger.info("Shouldn't reach here as ObjectNotFoundException is thrown");
	}
	
	@Test
	public void testGetAllDecks(){
		logger.info("getting all the persisted decks");
		List<Deck> decks = Arrays.asList(new Deck("deck1"), new Deck("Deck2"));
		// setting up the mock-conditions
		when(deckRepository.findAll()).thenReturn(decks);
		decks = dealerService.getAllDecks();
		assertThat(decks, notNullValue());
	}

	@Test
	public void testShuffleDeckWithRandomStrategy() throws Exception {
		String deckName = "deck1";
		Deck deck = new Deck(deckName);
		when(deckRepository.findByName(any(String.class))).thenReturn(deck);
		when(cardShuffleStrategy.shuffleDeck(any(Deck.class))).thenReturn(deck);
		when(deckRepository.saveAndFlush(deck)).thenReturn(deck);
		logger.info(String.format("passed in deckName = %s", deckName));
		deck = dealerService.shuffleDeck(deckName);
		assertThat(deck, notNullValue());
		assertThat(deck.getCards(), notNullValue());
		assertThat(deck.getCards().size(), is(equalTo(52)));
	}

	@Test  
	public void testShuffleDeckWhichDoesNotExist() {
		String deckName = "deckNotFound";
		Deck deck = new Deck(deckName);
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		doThrow(ObjectNotFoundException.class).when(deckRepository).findByName(any(String.class));
		logger.info("Configure the expected execption to be ObjectNotFoundException");
        thrown.expect(ObjectNotFoundException.class);
		dealerService.getDeck(deckName);
		logger.info("Shouldn't reach here as ObjectNotFoundException is thrown");
	}
	@Test
	public void testRemoveDeck() {
		String deckName = "deck4";
		Deck deck = new Deck(deckName);
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		when(deckRepository.findByName(any(String.class))).thenReturn(deck);
		doNothing().when(deckRepository).delete(any(Deck.class));
		doNothing().when(deckRepository).flush();
		dealerService.removeDeck(deckName);
	}

	@Test  
	public void testRemoveDeckWhichDoesNotExist() {
		String deckName = "deckNotFound";
		Deck deck = new Deck(deckName);
		logger.info(String.format("passed in deckName = %s", deck.getName()));
		when(deckRepository.findByName(any(String.class))).thenReturn(deck);
		doThrow(ObjectNotFoundException.class).when(deckRepository).delete(any(Deck.class));
		logger.info("Configure the expected execption to be ObjectNotFoundException");
        thrown.expect(ObjectNotFoundException.class);
		dealerService.removeDeck(deckName);
		logger.info("Shouldn't reach here as ObjectNotFoundException is thrown");
	}
}
