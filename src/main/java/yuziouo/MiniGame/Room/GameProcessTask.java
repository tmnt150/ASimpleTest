package yuziouo.MiniGame.Room;

import cn.nukkit.scheduler.Task;

public class GameProcessTask extends Task {
    private final Room room;
    private int currentTime;
    public GameProcessTask(Room room) {
        this.room = room;
        currentTime = 0;
    }

    @Override
    public void onRun(int i) {
        currentTime++;
        if (currentTime < room.getSetting().getTimeLimit()){
            if (room.getHandle().handle(room,currentTime)){
                room.endGame();
                this.cancel();
            }
        }else {
            room.endGame();
            this.cancel();
        }
    }
}
