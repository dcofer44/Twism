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
import android.widget.Toast;

import me.dcofer.twism.adapter.GameAdapter;
import me.dcofer.twism.adapter.StreamAdapter;
import me.dcofer.twism.api.TwitchService;
import me.dcofer.twism.listener.EndlessScrollListener;
import me.dcofer.twism.listener.RecyclerItemClickListener;


public class StreamsActivity extends ActionBarActivity implements RecyclerItemClickListener.OnItemClickListener
{
    public static final String GAME_NAME = "StreamsActivity.GAME_NAME";
    private static final String TAG = "StreamsActivity";

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twism_main);

        Intent intent = getIntent();
        final String gameName = intent.getStringExtra(GAME_NAME);
        Log.d(TAG, gameName);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        adapter = new StreamAdapter(StreamsActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this));

        final TwitchService service = TwitchService.getInstance();
        service.addStreamData(adapter, gameName);

        recyclerView.setOnScrollListener(new EndlessScrollListener(layoutManager)
        {
            @Override
            public void onLoadMore(int currentPage)
            {
                Log.d(TAG, "Adding more stream data");
                service.addStreamData(adapter, gameName);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        TwismAppData.clearStreams();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_streams, menu);
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
        String disName = TwismAppData.STREAMS.get(position).getChannel().getDisplayname();
        Toast.makeText(this, disName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext()
    {
        return this;
    }
}
