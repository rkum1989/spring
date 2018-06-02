//
//	@Id: CardShuffleStrategyType.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the CardShuffleStrategy class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.strategy;

import java.util.Locale;

public enum CardShuffleStrategyType {
	
	RANDOM("random"), 
	HAND("hand");
	
    private String type;

    CardShuffleStrategyType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
    
    public static CardShuffleStrategyType fromType(String type) {
        return CardShuffleStrategyType.valueOf(type.toUpperCase(Locale.ENGLISH));

    }
}

