package me.dcofer.twism.api;

import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import me.dcofer.twism.TwismAppData;
import me.dcofer.twism.api.json.GameDeserializer;
import me.dcofer.twism.api.json.StreamDeserializer;
import me.dcofer.twism.model.game.TwitchGame;
import me.dcofer.twism.model.stream.TwitchStream;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by derek on 5/5/15.
 * Singleton class
 */
public class TwitchService
{
    private static final String TAG = "TwitchService";

    private static  TwitchService instance = null;

    private TwitchAPI api;

    private TwitchService()
    {
        RequestInterceptor interceptor = new RequestInterceptor()
        {
            @Override
            public void intercept(RequestFacade request)
            {
                request.addHeader("Accept", "application/vnd.twitchtv.v3+json");
                request.addHeader("Client-ID", TwismAppData.CLIENT_ID);
            }
        };

        //TwitchGame type
        Type twitchGameType = new TypeToken<List<TwitchGame>>(){}.getType();
        //TwitchStream type
        Type twitchStreamType = new TypeToken<List<TwitchStream>>(){}.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(twitchGameType, new GameDeserializer());
        gsonBuilder.registerTypeAdapter(twitchStreamType, new StreamDeserializer());
        Gson gson = gsonBuilder.create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TwitchAPI.END_POINT)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(interceptor)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setLog(new AndroidLog(TAG))
                .build();
        api = restAdapter.create(TwitchAPI.class);
    }

    public static TwitchService getInstance()
    {
        if(instance == null)
            instance = new TwitchService();

        return instance;
    }

    public void addGamesData(final Adapter adapter)
    {
        int limit = TwismAppData.DEFAULT_LIMIT;
        int offset = TwismAppData.getGameOffset();
        api.getGames(limit, offset, new Callback<List<TwitchGame>>() {
            @Override
            public void success(List<TwitchGame> games, Response response)
            {
                TwismAppData.GAMES.addAll(games);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Log.e(TAG, error.getMessage(), error.getCause());
                error.printStackTrace();
            }
        });
    }

    public void addStreamData(final Adapter adapter, String game)
    {
        int limit = TwismAppData.DEFAULT_LIMIT;
        int offset = TwismAppData.getStreamOffset();
        api.getStreams(game, limit, offset, new Callback<List<TwitchStream>>() {
            @Override
            public void success(List<TwitchStream> twitchStreams, Response response) {
                TwismAppData.STREAMS.addAll(twitchStreams);
                Log.d(TAG, twitchStreams.size() + " Number of streams returned");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Log.e(TAG, error.getMessage(), error.getCause());
                error.printStackTrace();
            }
        });
    }
}
