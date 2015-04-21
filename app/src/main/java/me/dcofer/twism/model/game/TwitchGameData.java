package me.dcofer.twism.model.game;

import me.dcofer.twism.model.pic.TwitchPicture;

/**
 * Created by derek on 4/21/15.
 */
public class TwitchGameData
{
    private int _id;
    private TwitchPicture box;
    private TwitchPicture logo;
    private String name;
    public int get_id()
    {
        return _id;
    }
    public void set_id(int _id)
    {
        this._id = _id;
    }
    public TwitchPicture getBox()
    {
        return box;
    }
    public void setBox(TwitchPicture box)
    {
        this.box = box;
    }
    public TwitchPicture getLogo()
    {
        return logo;
    }
    public void setLogo(TwitchPicture logo)
    {
        this.logo = logo;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
