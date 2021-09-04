package it.matty.kit.manager;

import it.matty.kit.objects.PlayerKit;
import org.bukkit.entity.Player;

public interface IKitManager {

    PlayerKit getKit(String name);

    void apply(Player player, String kit);

    void register(PlayerKit kit);
}
