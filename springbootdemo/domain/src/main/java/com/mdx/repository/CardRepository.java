////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: CardRepository.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.repository;

import com.mdx.domain.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//import com.mdx.model.Reward;

//import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, String> {

    //CompletableFuture<Page<User>> findAllBy(final Pageable pageable);

    Optional<CardEntity> findOneById(final String id);

    //CardEntity findByTokenReferenceIdAndTokenRequestorId(String tokenReferenceId, String tokenRequestorId);
}
