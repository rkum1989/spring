////////////////////////////////////////////////////////////////////////
//
//	@Id: DeckUtils.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the DeckUtils class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DeckUtils {
 
	// [ data-members.]
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/**
	 * This method converts the supplied object to json string.
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
	    String json = gson.toJson(object);
	    return json;
	}
	

}