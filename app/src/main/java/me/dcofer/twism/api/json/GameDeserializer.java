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

import me.dcofer.twism.model.game.TwitchGame;

/**
 * Created by derek on 4/19/15.
 */
public class GameDeserializer implements JsonDeserializer<List<TwitchGame>>
{
    @Override
    public List<TwitchGame> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("top");

        List<TwitchGame> gameRoots = new Gson().fromJson(jsonArray, typeOfT);
        return gameRoots;
    }
}
