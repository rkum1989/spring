////////////////////////////////////////////////////////////////////////
//
//	@Id: DealerService.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the DealerService class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.service;

import java.util.List;

import com.mdx.microservice.data.domain.Deck;
import com.mdx.microservice.data.repository.DeckRepository;
import com.mdx.microservice.exceptions.ObjectNotFoundException;
import com.mdx.microservice.strategy.CardShuffleStrategy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DealerService {
	
	// [ data-members..!]
	@Autowired
	private DeckRepository deckRepository;

	@Autowired
	private CardShuffleStrategy cardShuffleStrategy;
	
	// singleton instance of the Logger object..!
	private static final Logger logger = Logger.getLogger(DealerService.class.getName());

	
	/**
	 * This method saves the supplied Deck object instance in the in-memory persistent store.
	 * @param deck
	 * @return
	 */
	public Deck getDeck(String deckName){
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = deckRepository.findByName(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s }", deckName);
			logger.error(errorMsg);
			throw new ObjectNotFoundException(errorMsg);
		}
		return deck;
	}
	
	/**
	 * This method saves the supplied Deck object instance in the in-memory persistent store.
	 * @param deck
	 * @return
	 */
	public List<Deck> getAllDecks() {
		logger.info("getting all the persisted decks");
		List<Deck> decks = deckRepository.findAll();
		return decks;
	}

	/**
	 * This method checks whether the supplied deck object already exists in the database.
	 * @param deck
	 * @return
	 */
	public boolean exists(Deck deck) {
		logger.info("checking whether the supplied deck already exists..");
		return deckRepository.exists(deck.getName());
	}

	/**
	 * This method saves the supplied Deck object instance in the in-memory persistent store.
	 * @param deck
	 * @return
	 */
	@Transactional
	public Deck createDeck(Deck deck) {
		logger.info(String.format("persisting the supplied deck with the name = %s", deck.getName()));
		Deck deck1 = deckRepository.saveAndFlush(deck);
		return deck1;
	}

	/**
	 * This method saves the supplied Deck object instance in the in-memory persistent store.
	 * @param deck
	 * @return
	 */
	@Transactional
	public Deck shuffleDeck(String deckName) {
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = deckRepository.findByName(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s}", deckName);
			logger.error(errorMsg);
			throw new ObjectNotFoundException(errorMsg);
		}
		deck = deckRepository.saveAndFlush(cardShuffleStrategy.shuffleDeck(deck));
		return deck;
	}

	/**
	 * This method removes the specified Deck object instance from the in-memory repository.
	 * @param deckName
	 */
	@Transactional
	public void removeDeck(String deckName) {
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = deckRepository.findByName(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s }", deckName);
			logger.error(errorMsg);
			throw new ObjectNotFoundException(errorMsg);
		}
		deckRepository.delete(deck);
		deckRepository.flush();
	}

}
