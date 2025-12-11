package org.tennisApp.mapper;

import com.google.gson.Gson;

public class JsonMapper {

    private static final Gson jsonMapper = new Gson();

    public static String toJson(Object object) {
        return jsonMapper.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> objOfT) {
        return jsonMapper.fromJson(json, objOfT);
    }

}
