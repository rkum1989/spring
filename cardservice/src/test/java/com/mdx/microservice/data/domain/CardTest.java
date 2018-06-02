////////////////////////////////////////////////////////////////////////
//
//	@Id: CardTest.java
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
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;

public class CardTest {
	final static Logger logger = Logger.getLogger(CardTest.class);

	@Test
	public void testNewCard(){
		Card card = new Card("2","heart");    
		logger.debug("\tCard Value:"  + card.getValue());    
		logger.debug("\tCard Suit :"  + card.getSuit());    
		assertEquals(card.getValue(),"2");
		assertEquals(card.getSuit(),"heart");
	}

}
