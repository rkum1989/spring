////////////////////////////////////////////////////////////////////////
//
//	@Id: AppConfig.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the AppConfig class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//import com.mdx.microservice.data.repository.DeckRepository;
import com.mdx.microservice.service.DealerService;
import com.mdx.microservice.strategy.CardShuffleStrategy;
import com.mdx.microservice.strategy.CardShuffleStrategyFactory;
import com.mdx.microservice.strategy.CardShuffleStrategyType;

@Configuration 
public class AppConfig {

    @Autowired
    private CardShuffleStrategyFactory cardShuffleStrategyFactory;
    
    
    @Value("${spring.application.shuffle.strategy.type:random}")
    private String shuffleStrategyType;

    @Bean
    public DealerService dealerService() {
        return new DealerService();
    }
    
    @Bean
    public CardShuffleStrategy cardShuffleStrategy() throws Exception {
    	return cardShuffleStrategyFactory.build(CardShuffleStrategyType.fromType(shuffleStrategyType));
	}
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
    	return new PropertySourcesPlaceholderConfigurer();
    }
    
}