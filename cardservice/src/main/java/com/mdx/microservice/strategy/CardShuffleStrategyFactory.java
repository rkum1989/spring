////////////////////////////////////////////////////////////////////////
//
//	@Id: CardShuffleStrategyFactory.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the CardShuffleStrategy class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mdx.microservice.data.domain.Card;
import com.mdx.microservice.data.domain.Deck;
import com.mdx.microservice.exceptions.BadRequestException;

@Component
public class CardShuffleStrategyFactory {

	// singleton instance of the Logger object..!
	private static final Logger logger = Logger.getLogger(CardShuffleStrategyFactory.class.getName());

	
	/**
	 * This is the factory method which builds the strategy object, based on the supplied type..!
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	public CardShuffleStrategy build(CardShuffleStrategyType shuffleStrategyType) throws Exception {
		CardShuffleStrategy car = null;
		switch(shuffleStrategyType) {
		case RANDOM:
			car = new RandomShuffleStrategy();
			break;

		case HAND:
			car = new HandShuffleStrategy();
			break;

		default:
			throw new Exception("Invalid shuffleStrategyCardype passed..!");
		}
		return car;
	}

	//	Algorithm:
	//	Random index is generated and used for the swap.
	public static class RandomShuffleStrategy implements CardShuffleStrategy {

		@Override
		public Deck shuffleDeck(Deck deck) {
			logger.debug("RandomShuffleStrategy::shuffling using RANDOM-shuffling strategy");
			// deck object validation
			if((deck == null) || (deck.getCards().isEmpty())) {
				String errorMsg = "supplied deck is null or has no member cards";
				throw new BadRequestException(errorMsg);
			}
			List<Card> shuffledCards = new ArrayList<>(deck.getCards());
			// shuffle
			for (int i = 0; i < shuffledCards.size(); i++) {
				int randIndex = i + (int) (Math.random() * (shuffledCards.size()-i));
				Card temp = shuffledCards.get(randIndex);
				shuffledCards.set(randIndex, shuffledCards.get(i));
				shuffledCards.set(i, temp);
			}
			deck.setCards(new HashSet<>(shuffledCards));
			return deck;
		}
	}


	//	Algorithm:
	//	Split deck into two halves and then interleave two halves.
	public static class HandShuffleStrategy implements CardShuffleStrategy {

		@Override
		public Deck shuffleDeck(Deck deck) {
			logger.debug("HandShuffleStrategy::shuffling using HAND-shuffling strategy");
			// deck object validation
			if((deck == null) || (deck.getCards().isEmpty())) {
				String errorMsg = "supplied deck is null or has no member cards";
				throw new BadRequestException(errorMsg);
			}
			List<Card> halfDeck_1   = new LinkedList<Card>();
			List<Card> halfDeck_2   = new LinkedList<Card>();
			List<Card> shuffledDeck = new LinkedList<Card>();
			// processing the strategy..!
			List<Card> cards = new ArrayList<>(deck.getCards());
			// looping through the cards
			for(int i=0; i < cards.size(); i++) {
				if(i < (cards.size()/2)) {
					halfDeck_1.add(cards.get(i));
				}
				else{
					halfDeck_2.add(cards.get(i));
				}
			}
			//assuming there are two equal halves
			if(halfDeck_1.size()==halfDeck_2.size()) {
				// looping through the two half decks..!
				for(int j=0; j < halfDeck_1.size(); j++){
					shuffledDeck.add(halfDeck_1.get(j));
					shuffledDeck.add(halfDeck_2.get(j));
				}
			}
			deck.setCards(new HashSet<>(shuffledDeck));
			return deck;
		}
	}

}

