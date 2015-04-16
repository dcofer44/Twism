package me.dcofer.twism.model.game;

/**
 * Created by derek on 4/15/15.
 */
public class TwitchGameStream
{
    private int channels;
    private TwitchGame game;
    private int viewers;

    public int getChannels()
    {
        return channels;
    }

    public void setChannels(int channels)
    {
        this.channels = channels;
    }

    public TwitchGame getGame()
    {
        return game;
    }

    public void setGame(TwitchGame game)
    {
        this.game = game;
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
