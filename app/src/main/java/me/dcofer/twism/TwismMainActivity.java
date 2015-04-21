package me.dcofer.twism;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import me.dcofer.twism.adapter.RecycleAdapter;
import me.dcofer.twism.api.TwitchAPI;
import me.dcofer.twism.api.json.GameDeserializer;
import me.dcofer.twism.model.game.TwitchGame;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class TwismMainActivity extends ActionBarActivity
{
    public static final String TAG = "TwismMainAcitivity";

    //    private GridView gridViewMain;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twism_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);

        RequestInterceptor interceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/vnd.twitchtv.v3+json");
                request.addHeader("Client-ID", "q8tzi3jcfm1q1rsch1zuftp5g6rw07c");
            }
        };

        Type type = new TypeToken<List<TwitchGame>>(){}.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(type, new GameDeserializer());
        Gson gson = gsonBuilder.create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TwitchAPI.END_POINT)
                .setConverter(new GsonConverter(gson))
                .build();
        TwitchAPI api = restAdapter.create(TwitchAPI.class);
        api.getGames("25", "0", new Callback<List<TwitchGame>>() {
            @Override
            public void success(List<TwitchGame> games, Response response)
            {
                adapter = new RecycleAdapter(TwismMainActivity.this, games);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Log.e(TAG, error.getMessage(), error.getCause());
                error.printStackTrace();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_twism_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}