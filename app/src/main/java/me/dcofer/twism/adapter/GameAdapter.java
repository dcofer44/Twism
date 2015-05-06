package me.dcofer.twism.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.dcofer.twism.R;
import me.dcofer.twism.TwismAppData;

/**
 * Created by derek on 4/14/15.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ImageHolder>
{
    private Context context;

    public GameAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.image_item, viewGroup, false);
        return new ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageHolder imageHolder, int i)
    {
        String imageURL = TwismAppData.GAMES.get(i).getGameData().getBox().getLarge();
//        Picasso.with(context).load(imageURL).into(imageHolder.imageItem);
        Picasso.with(context).load(imageURL).resize(400, 600)
                .placeholder(R.drawable.dummy_img).into(imageHolder.imageItem);

        String game = TwismAppData.GAMES.get(i).getGameData().getName();
        imageHolder.textView.setText(game);
    }

    @Override
    public int getItemCount()
    {
        return TwismAppData.GAMES.size();
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
