package yuziouo.MiniGame.Room;


import cn.nukkit.Player;
import cn.nukkit.Server;
import yuziouo.MiniGame.GameType.GameHandle;

import java.util.ArrayList;
import java.util.Map;

public abstract class Room {
    private RoomSetting setting;
    private GameHandle handle;
    private WaitRoomTask waitTask;
    public Room(RoomSetting setting, GameHandle handle){
        this.setting = setting;
        this.handle = handle;
        waitTask = new WaitRoomTask(this);
    }

    public RoomSetting getSetting() {
        return setting;
    }

    public void setSetting(RoomSetting setting) {
        this.setting = setting;
    }

    public GameHandle getHandle() {
        return handle;
    }
    public void addPlayer2Team(Player player){
       if (!roomIsFull()){
           setting.getTeams().get(getMinPlayerTeam()).add(player);
           player.teleport(setting.getWaitingRoom());
           if(roomIsFull()){
               Server.getInstance().getScheduler().scheduleRepeatingTask(waitTask,20);
           }
       }
    }
    public boolean roomIsFull(){
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            if (entry.getValue().size()<setting.getMaxTeamPlayer()) return false;
        }
        return true;
    }
    public String getMinPlayerTeam(){
        Map.Entry<String, ArrayList<Player>> minset = null;
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            if (minset == null) minset = entry;
            if(entry.getValue().size() < minset.getValue().size()) minset = entry;
        }
        return minset.getKey();
    }
    public int getTotalTeamPlayer(){
        int count = 0;
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            count+=entry.getValue().size();
        }
        return count;
    }
    public String Player2Team(Player player){
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            if (entry.getValue().contains(player)) return entry.getKey();
        }
        return null;
    }
    public void startGame(){
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            for (Player player:entry.getValue()){
                player.teleport(setting.getTeamGameSpawnLocation().get(entry.getKey()));
            }
        }
    }
    public void endGame(){
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            for (Player player:entry.getValue()){
                player.teleport(Server.getInstance().getDefaultLevel().getSpawnLocation());
            }
            setting.getTeams().get(entry.getKey()).clear();
        }
    }
    public ArrayList<Player> getTotalPlayer(){
        ArrayList<Player> players = new ArrayList<>();
        for(Map.Entry<String, ArrayList<Player>> entry:setting.getTeams().entrySet()){
            players.addAll(entry.getValue());
        }
        return players;
    }
}
