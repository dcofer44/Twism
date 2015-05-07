package me.dcofer.twism.model.token;

import com.google.gson.annotations.SerializedName;

/**
 * Created by derek on 5/7/15.
 */
public class AccessToken
{
    @SerializedName("mobile_restricted")
    private boolean mobileRestricted;

    private String sig;

    private String token;

    public boolean isMobileRestricted()
    {
        return mobileRestricted;
    }

    public void setMobileRestricted(boolean mobileRestricted)
    {
        this.mobileRestricted = mobileRestricted;
    }

    public String getSig()
    {
        return sig;
    }

    public void setSig(String sig)
    {
        this.sig = sig;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}
