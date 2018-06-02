////////////////////////////////////////////////////////////////////////
//
//	@Id: CardShuffleStrategy.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the CardShuffleStrategy class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.strategy;

import com.mdx.microservice.data.domain.Deck;

public interface CardShuffleStrategy {
	
    public Deck shuffleDeck(Deck deck);
    
}


