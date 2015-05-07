package me.dcofer.twism.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.dcofer.twism.R;

/**
 * Created by derek on 5/6/15.
 */
public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ImageHolder>
{

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    /**
     * ImageHolder inner class. This is what holds the Views
     */
    public static class ImageHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageItem;
        public TextView textView;
        public ImageHolder(View v)
        {
            super(v);
            imageItem = (ImageView) v.findViewById(R.id.imageItem);
            textView = (TextView) v.findViewById(R.id.imgeTextView);
        }
    }
}
