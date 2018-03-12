////////////////////////////////////////////////////////////////////////
//
//	@Id: DeckTest.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the CardTest class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.data.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.mdx.microservice.Application;
import com.mdx.microservice.strategy.CardShuffleStrategy;
import com.mdx.microservice.strategy.CardShuffleStrategyFactory;
import com.mdx.microservice.strategy.CardShuffleStrategyType;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("default")
public class DeckTest {

	final static Logger logger = Logger.getLogger(DeckTest.class);

	@Autowired
	private CardShuffleStrategyFactory cardShuffleStrategyFactory;

	@Test
	public void testDeckSetup() {
		Deck deck = new Deck("deck1");
		assertEquals(deck.getCards().size(),52);
	}

	@Test
	public void testDeckDefaultShuffle() throws Exception {
		logger.info("Testing Deck Default Shuffle");
		Deck deck = new Deck("deck1");
		CardShuffleStrategy strategy = cardShuffleStrategyFactory.build(CardShuffleStrategyType.fromType("random"));
		Deck deck1 = strategy.shuffleDeck(deck);
		assertThat(deck1, notNullValue());
		assertThat(deck1.getName(), notNullValue());
		assertEquals(deck.getCards().size(),52);
	}

	@Test
	public void testDeckHandShuffle() throws Exception {
		logger.info("Testing Hand Deck Shuffle");
		Deck deck = new Deck("deck1");
		CardShuffleStrategy strategy = cardShuffleStrategyFactory.build(CardShuffleStrategyType.fromType("hand"));
		Deck deck1 = strategy.shuffleDeck(deck);
		assertThat(deck1, notNullValue());
		assertThat(deck1.getName(), notNullValue());
		assertEquals(deck.getCards().size(),52);
	}


}
