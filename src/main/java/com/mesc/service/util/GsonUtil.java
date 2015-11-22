package com.mesc.service.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	private static final Gson gson = new GsonBuilder().create();
	
	public static String objToJson(Object obj, Type objType) {
		return gson.toJson(obj, objType);
	}
}
