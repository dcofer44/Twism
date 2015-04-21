package me.dcofer.twism.model.game;

import com.google.gson.annotations.SerializedName;

import me.dcofer.twism.model.TwitchRoot;
import me.dcofer.twism.model.pic.TwitchPicture;

/**
 * Created by derek on 4/15/15.
 */
public class TwitchGame
{
    private int channels;

    @SerializedName("game")
    private TwitchGameData gameData;

    private int viewers;

    public int getChannels()
    {
        return channels;
    }
    public void setChannels(int channels)
    {
        this.channels = channels;
    }
    public TwitchGameData getGameData()
    {
        return gameData;
    }
    public void setGameData(TwitchGameData gameData)
    {
        this.gameData = gameData;
    }
    public int getViewers()
    {
        return viewers;
    }
    public void setViewers(int viewers)
    {
        this.viewers = viewers;
    }
}
