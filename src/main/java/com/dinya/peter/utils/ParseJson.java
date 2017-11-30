package com.dinya.peter.utils;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParseJson {
    private static final Logger LOGGER = LogManager.getLogger(ParseJson.class);
    private static ParseJson instance = new ParseJson();
    private Gson gson;
    public static ParseJson getInstance(){
        synchronized (ParseJson.class){
            if (instance == null){
                instance = new ParseJson();
            }
        }
        return instance;
    }

    public <T> T get(String json, Class<T> classOfT) throws JsonSyntaxException{
            return instance.gson.fromJson(json, classOfT);
    }

    private ParseJson(){
        gson = new GsonBuilder().create();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not supported when on a Singleton class.");
    }
}
