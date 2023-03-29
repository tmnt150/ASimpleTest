package yuziouo.MiniGame.GameType;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import yuziouo.MiniGame.Room.Room;

public class GetDiamondGame implements GameHandle {
    @Override
    public boolean handle(Room room, int currentTime) {
        //假設當玩家拿到鑽石遊戲就結束
        for (Player player:room.getTotalPlayer()){
            if (player.getInventory().contains(Item.get(Item.DIAMOND)))
                //只要回傳true就代表遊戲結束
                return true;
        }
        return false;
    }
}
