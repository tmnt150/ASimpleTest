package yuziouo.MiniGame.GameType;

import yuziouo.MiniGame.Room.Room;

public interface GameHandle {
    boolean handle(Room room,int currentTime);
}
