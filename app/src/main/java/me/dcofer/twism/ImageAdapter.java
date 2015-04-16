package me.dcofer.twism;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by derek on 4/7/15.
 */
public class ImageAdapter extends BaseAdapter
{
    private static final int NUM_IMGS = 25;//TODO delete this later

    private Context context;

    public ImageAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount()
    {
        return NUM_IMGS;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView image = null;
        if(convertView == null)
        {
            image = new ImageView(context);
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//            image.setLayoutParams(new GridView.LayoutParams(85, 85));
            image.setPadding(8, 8, 8, 8);
        }
        else
        {
            image = (ImageView) convertView;
        }
        image.setImageResource(R.drawable.dummy_img);
        return image;
    }
}
