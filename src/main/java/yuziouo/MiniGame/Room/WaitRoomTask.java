package yuziouo.MiniGame.Room;

import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;

public class WaitRoomTask extends Task {
    private int currentTime;
    private final Room room;

    public WaitRoomTask(Room room) {
        this.room = room;
        currentTime = 0;
    }

    @Override
    public void onRun(int i) {
        currentTime++;
        if (room.getTotalTeamPlayer() >= room.getSetting().getTeams().size()&&currentTime >= room.getSetting().getWaitTime()){
            room.startGame();
            Server.getInstance().getScheduler().scheduleRepeatingTask(new GameProcessTask(room),20);
            this.cancel();
        }
    }
}
