package me.dcofer.twism;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by derek on 4/14/15.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ImageHolder>
{
    private static final int NUM_IMGS = 25;//TODO delete this later

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.dummy_image, viewGroup, false);
        return new ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageHolder imageHolder, int i)
    {
        imageHolder.textView.setText("Image #" + (1+i));
    }

    @Override
    public int getItemCount()
    {
        return NUM_IMGS;
    }

    /**
     * ImageHolder inner class. This is what holds the Views
     */
    public static class ImageHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ImageHolder(View v)
        {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
        }
    }
}
