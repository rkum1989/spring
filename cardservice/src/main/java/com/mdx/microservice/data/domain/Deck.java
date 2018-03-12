////////////////////////////////////////////////////////////////////////
//
//	@Id: Deck.java
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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "DECKS")
public class Deck implements Serializable {
	
	private static final long serialVersionUID = -2749336945708685279L;
	
	// [data-members..!]
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DECK_ID", unique = true, nullable = false)
    protected Integer deckId;

    @Column(name = "DECK_NAME", unique = true, nullable = false)
	private String name;
    
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
    		name="DECK_CARD", 
    		joinColumns={@JoinColumn(name="DECK_ID", referencedColumnName="DECK_ID")}, 
    		inverseJoinColumns={@JoinColumn(name="CARD_ID", referencedColumnName="CARD_ID")})    
    private Set<Card> cards;

	private static String[] faceCards = {"J","Q","K","A"};
	
	private static String[] suits = {"spades","clubs","diamonds","hearts"};

    
	//default-constructors
	public Deck(){
		this.name = UUID.randomUUID().toString();
		init();
	}

	// constructor-1
	public Deck(String name){
		this.name = name;
		init();
	}

	/**
	 * This method initializes the deck once at the deck creation time.
	 */
	private void init() {
		this.cards = new LinkedHashSet<Card>();
        // initialize deck
		for(int i=2; i<=10; i++){
			for(int j=1; j<=4; j++){
				cards.add(new Card(Integer.toString(i), suits[j-1]));
			}
		}
		for(int k=1; k<=4; k++){
			for(int l=1; l<=4; l++){
				cards.add(new Card(faceCards[k-1],suits[l-1]));
			}
		}
	}

    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.deckId == null);
    }

	//Accessors/mutators
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public Set<Card> getCards(){
		return this.cards;
	}

	public void setCards(Set<Card> cards){
		this.cards = cards;
	}

	@Override
	public String toString() 
	{
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE,true,true);
	}	

}

