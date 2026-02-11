package com.DummyJSON.API.JsonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFilePathUtil{
	public static String readJson(String filepath) throws IOException{
		return Files.readString(Paths.get(filepath));
	}
}