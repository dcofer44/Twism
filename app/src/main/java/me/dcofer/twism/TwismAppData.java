package me.dcofer.twism;

import java.util.ArrayList;

import me.dcofer.twism.model.game.TwitchGame;
import me.dcofer.twism.model.stream.TwitchStream;

/**
 * Created by derek on 4/21/15.
 */
public class TwismAppData
{
    //The Twitch API client id needs to be sent with every request
    public static final String CLIENT_ID = "q8tzi3jcfm1q1rsch1zuftp5g6rw07c";

    public static final int DEFAULT_LIMIT = 50;

    public static ArrayList<TwitchGame> GAMES = new ArrayList<>();

    public static ArrayList<TwitchStream> STREAMS = new ArrayList<>();

    public static int getGameOffset()
    {
        return GAMES.size();
    }

    public static int getStreamOffset()
    {
        return STREAMS.size();
    }

    public static String getGameName(int position)
    {
        return GAMES.get(position).getGameData().getName();
    }

    public static void clearStreams()
    {
        STREAMS.clear();
    }
}
