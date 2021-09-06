package it.matty.kit.manager;

import it.matty.kit.objects.PlayerKit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public interface IKitManager {

    PlayerKit getKit(String name);

    void apply(Player player, String kit);

    void saveKit(FileConfiguration file, String kit, String path);

    void loadKit(FileConfiguration file, String path);

    void register(PlayerKit kit);
}
