package me.dcofer.twism.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by derek on 5/5/15.
 *
 * Code found on StackOverflow
 * Link @see <a href="http://stackoverflow.com/a/26196831" </a>
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener
{
    /**
     * Inner interface
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        Context getContext();
    }

    private OnItemClickListener listener;
    private GestureDetector detector;

    public RecyclerItemClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
        detector = new GestureDetector(listener.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
    {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if(childView != null && listener != null && detector.onTouchEvent(e)) {
            listener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    //Not used
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {}
}
