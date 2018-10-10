package com.springboot.data.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ApiRequest.
 */
@Entity
@Table(name = "API_REQUEST")
public class ApiRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2333755749180782663L;

	/** The id. */
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/** The request time. */
	@Column(name = "REQUEST_TIME")
	private Date requestTime;

	/**
	 * Instantiates a new api request.
	 */
	public ApiRequest() {
	}

	/**
	 * Instantiates a new api request.
	 *
	 * @param requestTime
	 *            the request time
	 */
	public ApiRequest(Long id, Date requestTime) {
		this.id = id;
		this.requestTime = requestTime;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the request time.
	 *
	 * @return the request time
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * Sets the request time.
	 *
	 * @param requestTime
	 *            the new request time
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ApiRequest [id=%s, requestTime=%s]", id, requestTime);
	}

}
