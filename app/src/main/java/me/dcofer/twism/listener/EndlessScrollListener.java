package me.dcofer.twism.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by derek on 5/6/15.
 * Code taken from here <a href="https://gist.github.com/ssinss/e06f12ef66c51252563e"</a>
 */
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener
{
    private static final String TAG = "EndlessScrollListener";

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    private int firstVisibleItem, visibleItemCount, totalItemCount;

    private int currentPage = 1;

    private LinearLayoutManager manager;

    public EndlessScrollListener(LinearLayoutManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy)
    {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = manager.getItemCount();
        firstVisibleItem = manager.findFirstVisibleItemPosition();

        if(loading && totalItemCount > previousTotal)
        {
            loading = false;
            previousTotal = totalItemCount;
        }

        if(!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold))
        {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }
    }

    public abstract void onLoadMore(int currentPage);
}
