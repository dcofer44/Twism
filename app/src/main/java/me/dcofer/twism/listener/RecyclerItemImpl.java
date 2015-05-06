package me.dcofer.twism.listener;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import me.dcofer.twism.TwismAppData;

/**
 * Created by derek on 5/5/15.
 *
 * A implementation of the OnItemClickListener for RecyclerItemClickListener
 */
public class RecyclerItemImpl implements RecyclerItemClickListener.OnItemClickListener
{
    private static final String TAG = "RecyclerItemImpl";

    private Context context;

    public RecyclerItemImpl(Context context)
    {
        this.context = context;
    }

    @Override
    public void onItemClick(View view, int position)
    {
        String name = TwismAppData.getGameName(position);
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext()
    {
        return context;
    }
}
