package me.dcofer.twism.model.stream;

import com.google.gson.annotations.SerializedName;

/**
 * Created by derek on 5/6/15.
 */
public class TwitchChannel
{
    @SerializedName("display_name")
    private String displayname;

    private String name;

    @SerializedName("Status")
    private String title;

    public String getDisplayname()
    {
        return displayname;
    }

    public void setDisplayname(String displayname)
    {
        this.displayname = displayname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
