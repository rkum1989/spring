////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: PaymentTokenRepository.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.repository;

import com.mdx.domain.PaymentTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//import com.mdx.model.Reward;

//import java.util.List;

public interface PaymentTokenRepository extends JpaRepository<PaymentTokenEntity, String> {

    Optional<PaymentTokenEntity> findOneByTokenReferenceId(final Long id);

    Optional<PaymentTokenEntity> findByTokenReferenceIdAndTokenRequesterId(Long tokenReferenceId, String tokenRequesterId);
    /*@Modifying
    @Transactional(readOnly=false)
    @Query("update Employee e set e.name = :name and e.email = :email where e.id = :id")
    Integer updateEmployee(@Param("name") String name, @Param("email") String email, @Param("id") Long id);*/
}
