package it.matty.kit.objects.items;

import it.matty.kit.objects.IKitItem;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Data
public class ItemKit implements IKitItem {
    private final ItemStack itemStack;
    private final int slot;

    @Override
    public void apply(Player player) {
        player.getInventory().setItem(slot, itemStack);
    }
}
