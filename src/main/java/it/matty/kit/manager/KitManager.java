package it.matty.kit.manager;

import com.google.common.collect.Sets;
import it.matty.kit.objects.IKitItem;
import it.matty.kit.objects.PlayerKit;
import org.bukkit.entity.Player;

import java.util.Set;

public class KitManager implements IKitManager {
    private final Set<PlayerKit> kits = Sets.newHashSet();

    @Override
    public PlayerKit getKit(String name) {
        return this.kits.stream().filter(k -> k.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void apply(Player player, String kit) {
        PlayerKit playerKit = getKit(kit);

        for(IKitItem item : playerKit.getItems()) item.apply(player);
    }

    @Override
    public void register(PlayerKit kit) {
        this.kits.add(kit);
    }
}
