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
import me.dcofer.twism.model.game.TwitchGame;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by derek on 5/5/15.
 */
public class TwitchService
{
    private static final String TAG = "TwitchService";

    private static  TwitchService instance = null;

    private RequestInterceptor interceptor;

    private TwitchAPI api;

    private TwitchService()
    {
        this.interceptor = new RequestInterceptor()
        {
            @Override
            public void intercept(RequestFacade request)
            {
                request.addHeader("Accept", "application/vnd.twitchtv.v3+json");
                request.addHeader("Client-ID", TwismAppData.CLIENT_ID);
            }
        };

        Type twitchGameType = new TypeToken<List<TwitchGame>>(){}.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(twitchGameType, new GameDeserializer());
        Gson gson = gsonBuilder.create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TwitchAPI.END_POINT)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(interceptor)
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
}
