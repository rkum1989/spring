////////////////////////////////////////////////////////////////////////
//
//	@Id: ApiController.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the DeckController class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

import com.mdx.microservice.data.domain.Deck;
import com.mdx.microservice.service.DealerService;
import com.mdx.microservice.strategy.CardShuffleStrategy;
import com.mdx.microservice.utils.DeckUtils;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/cardservice/api")
public class ApiController
{
	// [ data-members. ]
	private DealerService dealerService;

	// [ data-members..!]
	private CardShuffleStrategy cardShuffleStrategy;

	// singleton instance of the Logger object..!
	private static final Logger logger = Logger.getLogger(ApiController.class.getName());

	@Autowired
	public ApiController(DealerService dealerService, CardShuffleStrategy cardShuffleStrategy) {
		super();
		this.dealerService = dealerService;
		this.cardShuffleStrategy = cardShuffleStrategy;
	}

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
	@RequestMapping(value="/decks/{deckName}", method = RequestMethod.GET)
	public ResponseEntity<String> getDeck(@PathVariable("deckName") String deckName){
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = dealerService.getDeck(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s}", deckName);
			return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(DeckUtils.toJson(deck), HttpStatus.OK);
	}

	@RequestMapping(value="/decks", method = RequestMethod.GET)
	public ResponseEntity<String> getAllDecks(){
		logger.info("getting all the persisted decks");
		List<Deck> decks = dealerService.getAllDecks();
		if(decks == null) {
			String errorMsg = "No decks available currently";
			return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(DeckUtils.toJson(decks), HttpStatus.OK);
	}

	@RequestMapping(value="/decks", method = RequestMethod.PUT)
	public ResponseEntity<String> createDeck(@RequestBody @Valid final Deck deck) {
		logger.info("persisting the supplied deck");
		Deck deck1 = dealerService.createDeck(deck);
		if(deck1 == null) {
			String errorMsg = "Couldn't create the resource for the supplied deck";
			return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(DeckUtils.toJson(deck1), HttpStatus.OK);
	}

	@RequestMapping(value="/decks/{deckName}", method = RequestMethod.POST)
	public ResponseEntity<String> shuffleDeck(@PathVariable("deckName") String deckName) {
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = dealerService.getDeck(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s}", deckName);
			return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
		}
		Deck shuffledDeck = cardShuffleStrategy.shuffleDeck(deck);
		return new ResponseEntity<>(DeckUtils.toJson(shuffledDeck), HttpStatus.CREATED);
	}

	@RequestMapping(value="/decks/{deckName}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeDeck(@PathVariable("deckName") String deckName) {
		logger.info(String.format("passed in deckName = %s", deckName));
		Deck deck = dealerService.getDeck(deckName);
		if(deck == null) {
			String errorMsg = String.format("Couldn't find the specified deck { %s}", deckName);
			return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
		}
		dealerService.removeDeck(deckName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

