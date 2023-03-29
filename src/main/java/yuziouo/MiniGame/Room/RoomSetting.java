package yuziouo.MiniGame.Room;

import cn.nukkit.Player;
import cn.nukkit.level.Location;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomSetting {
    private final Location waitingRoom;
    private final int waitTime;
    private final HashMap<String,ArrayList<Player>> teams;
    private final int maxTeamPlayer;
    private final int timeLimit;
    private final HashMap<String,Location> teamGameSpawnLocation;

    public RoomSetting(Location waitingRoom,int waitTime, HashMap<String, ArrayList<Player>> teams, int maxTeamPlayer, int timeLimit, HashMap<String, Location> teamGameSpawnLocation) {
        this.waitingRoom = waitingRoom;
        this.waitTime = waitTime;
        this.teams = teams;
        this.maxTeamPlayer = maxTeamPlayer;
        this.timeLimit = timeLimit;
        this.teamGameSpawnLocation = teamGameSpawnLocation;
    }

    public Location getWaitingRoom() {
        return waitingRoom;
    }

    public HashMap<String, ArrayList<Player>> getTeams() {
        return teams;
    }

    public int getMaxTeamPlayer() {
        return maxTeamPlayer;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public HashMap<String, Location> getTeamGameSpawnLocation() {
        return teamGameSpawnLocation;
    }

    public int getWaitTime() {
        return waitTime;
    }
}
