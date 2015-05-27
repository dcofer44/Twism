package me.dcofer.twism;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import me.dcofer.twism.adapter.GameAdapter;
import me.dcofer.twism.api.TwitchService;
import me.dcofer.twism.listener.EndlessScrollListener;
import me.dcofer.twism.listener.RecyclerItemClickListener;


public class TwismMainActivity extends ActionBarActivity implements RecyclerItemClickListener.OnItemClickListener
{
    public static final String TAG = "TwismMainAcitivity";

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twism_main);//TODO maybe use autofit RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 3);
        adapter = new GameAdapter(TwismMainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this));


        final TwitchService service = TwitchService.getInstance();
        service.addGamesData(adapter);

        recyclerView.setOnScrollListener(new EndlessScrollListener(layoutManager)
        {
            @Override
            public void onLoadMore(int currentPage)
            {
                Log.d(TAG, "Adding more data");
                service.addGamesData(adapter);
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

    @Override
    public void onItemClick(View view, int position)
    {
        String name = TwismAppData.getGameName(position);
        Intent intent = new Intent(this, StreamsActivity.class);
        intent.putExtra(StreamsActivity.GAME_NAME, name);
        startActivity(intent);
    }

    @Override
    public Context getContext()
    {
        return this;
    }
}