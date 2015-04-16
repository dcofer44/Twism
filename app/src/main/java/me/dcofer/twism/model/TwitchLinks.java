package me.dcofer.twism.model;

/**
 * Created by derek on 4/15/15.
 */
public class TwitchLinks extends TwitchRoot
{
    private String next;
    private String self;

    public String getNext()
    {
        return next;
    }

    public void setNext(String next)
    {
        this.next = next;
    }

    public String getSelf()
    {
        return self;
    }

    public void setSelf(String self)
    {
        this.self = self;
    }
}
