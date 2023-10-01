package com.practicepackage;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonTest {

	public static void main(String[] args) throws Throwable {
		JSONParser p = new JSONParser();
		
		Object obj = p.parse(new FileReader("./src/test/resources/CommanDataJson.json"));
		
		JSONObject map = (JSONObject)obj;
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("Browser"));
		System.out.println(map.get("url"));

	}

}
