package me.dcofer.twism;

import android.os.AsyncTask;

import me.dcofer.twism.api.TwitchAPI;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by derek on 4/16/15.
 */
public class TwitchTask extends AsyncTask<Void, Void, Void>
{
    @Override
    protected Void doInBackground(Void... params)
    {
        RequestInterceptor interceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/vnd.twitchtv.v3+json");
            }
        };
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TwitchAPI.END_POINT). build();
        TwitchAPI api = restAdapter.create(TwitchAPI.class);
//        TwitchGameRoot gameRoot = api.getGames();

//        Log.v(TwismMainActivity.TAG, gameRoot.getTop().get(0).getGame().getName() + "");
        return  null;
    }
}
