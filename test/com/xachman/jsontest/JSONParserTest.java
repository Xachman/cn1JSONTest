/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xachman.jsontest;

import ca.weblite.codename1.json.JSONException;
import com.codename1.testing.AbstractTest;
import ca.weblite.codename1.json.JSONObject;

/**
 *
 * @author ziron
 */
public class JSONParserTest  extends AbstractTest {

	@Override
	public boolean runTest() throws Exception {
		testBadJSON();
		return true;
	}

 	private void testBadJSON() {

		assertException(new RuntimeException(), new Runnable() {
			@Override
			public void run() {
				String badJSON = "{\"key\": \"val\" \"key2\":\"val2\"}";
				
				try {
					new JSONObject(badJSON);
				} catch(JSONException e) {
					System.out.println(e.getMessage());	
					throw new RuntimeException();
				}
			}
		});
	}
}
