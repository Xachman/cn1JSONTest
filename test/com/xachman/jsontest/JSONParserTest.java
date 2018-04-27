/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xachman.jsontest;

import com.codename1.io.JSONParser;
import com.codename1.testing.AbstractTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

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

		String badJSON = "{\"key\": \"val\" \"key2\":\"val2\"}";

		JSONParser json = new JSONParser();
		try(Reader r = new InputStreamReader(new ByteArrayInputStream(badJSON.getBytes(StandardCharsets.UTF_8)))) {
			Map<String, Object> data = json.parseJSON(r);
			System.out.println(data);
			assertEqual(0, data.size());

			assertTrue(!data.containsKey("key"));	
			assertTrue(!data.containsKey("key2"));	
		}catch(IOException e){
			log(e.getMessage());
		}

	}
}
