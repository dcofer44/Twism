package me.dcofer.twism.model.stream;

import com.google.gson.annotations.SerializedName;

import me.dcofer.twism.model.pic.TwitchPicture;

/**
 * Created by derek on 5/6/15.
 */
public class TwitchStream
{
    private TwitchChannel channel;

    @SerializedName("preview")
    private TwitchPicture pics;

    public TwitchChannel getChannel()
    {
        return channel;
    }

    public void setChannel(TwitchChannel channel)
    {
        this.channel = channel;
    }

    public TwitchPicture getPics()
    {
        return pics;
    }

    public void setPics(TwitchPicture pics)
    {
        this.pics = pics;
    }
}
