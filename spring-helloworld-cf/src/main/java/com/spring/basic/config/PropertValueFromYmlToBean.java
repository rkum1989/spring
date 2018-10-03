package com.spring.basic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "my")
@PropertySource(value="classpath:test.properties")
public class PropertValueFromYmlToBean {

	//we can use javaX annotation here for property validation.
	private String secret;
	private int number;
	private int numberlessthanten;
	private int numberinrange;
	private long bignumber;
	private String uuid;
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumberlessthanten() {
		return numberlessthanten;
	}

	public void setNumberlessthanten(int numberlessthanten) {
		this.numberlessthanten = numberlessthanten;
	}

	public int getNumberinrange() {
		return numberinrange;
	}

	public void setNumberinrange(int numberinrange) {
		this.numberinrange = numberinrange;
	}

	public long getBignumber() {
		return bignumber;
	}

	public void setBignumber(long bignumber) {
		this.bignumber = bignumber;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
