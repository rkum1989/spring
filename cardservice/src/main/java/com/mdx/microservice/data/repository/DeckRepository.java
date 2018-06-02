////////////////////////////////////////////////////////////////////////
//
//	@Id: DeckRepository.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the DeckRepository class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdx.microservice.data.domain.Deck;

@Transactional(readOnly=true)
public interface DeckRepository extends JpaRepository<Deck, String> {
    public Deck findByName(String name);
}
