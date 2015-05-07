package me.dcofer.twism.api.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;

import me.dcofer.twism.model.stream.TwitchStream;

/**
 * Created by derek on 5/6/15.
 */
public class StreamDeserializer implements JsonDeserializer<List<TwitchStream>>
{
    @Override
    public List<TwitchStream> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("streams");

        List<TwitchStream> list = new Gson().fromJson(jsonArray, typeOfT);
        return list;
    }
}
