package it.matty.kit.objects.items;

import com.google.common.collect.Sets;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Set;

@Data
public class EffectItemKit implements IKitItem {
    private final ItemStack itemStack;
    private final Set<PotionEffect> effects = Sets.newHashSet();
    private final int slot;

    @Override
    public void apply(Player player) {
        player.getInventory().setItem(slot, itemStack);
    }
}
