package me.dcofer.twism.model.game;


import java.util.ArrayList;

import me.dcofer.twism.model.TwitchRoot;

/**
 * Created by derek on 4/15/15.
 */
public class TwitchGameRoot extends TwitchRoot
{
    private int _total;
    private ArrayList<TwitchGameStream> top;

    public int get_total()
    {
        return _total;
    }

    public void set_total(int _total)
    {
        this._total = _total;
    }

    public ArrayList<TwitchGameStream> getTop()
    {
        return top;
    }

    public void setTop(ArrayList<TwitchGameStream> top)
    {
        this.top = top;
    }
}
