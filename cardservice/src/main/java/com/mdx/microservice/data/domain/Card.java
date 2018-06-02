////////////////////////////////////////////////////////////////////////
//
//	@Id: Card.java
//  @Author:  Shekhar Cambam
//
//	Purpose:
//	Contains the Card class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "CARDS")
public class Card implements Serializable {

	private static final long serialVersionUID = -2749336945708685279L;
	
	// [ data-members..!]
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID", unique = true, nullable = false)
    private Integer cardId;

    @Column(name = "CARD_VALUE", nullable = false)
	private String value;
    
    @Column(name = "CARD_SUIT", nullable = false)
	private String suit;

    // default-constructor
	public Card(){
		// do-nothing
	}

	// constructor-1
	public Card(String value, String suit){
		this.value = value;
		this.suit  = suit;
	}

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.cardId == null);
    }

	public String  getValue(){
		return this.value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String  getSuit(){
		return this.suit;
	}
	
	public void setSuit(String suit){
		this.suit = suit;
	}

	@Override
	public String toString() 
	{
		return  ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE,true,true);
	}	
	
}  
