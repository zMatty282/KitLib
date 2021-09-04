package it.matty.kit.builder.item;

import it.matty.kit.objects.items.ItemKit;
import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemKitBuilder {
    private final ItemStack itemStack;
    private final int slot;

    public ItemKitBuilder(@NonNull FileConfiguration file, @NonNull String path) {

        this.slot = file.getInt(path + ".slot");
        this.itemStack = new ItemBuilder((Material) file.get(path + ".material"))
                .setName(file.getString(path + ".name"))
                .setLore(file.getStringList(path + ".lore"))
                .setAmount(file.getInt(path + ".amount")).build();

        if(file.getConfigurationSection(path + ".enchants") == null) return;

        for(String key : file.getStringList(path + ".enchants")) {
            String[] enchant = key.split("#");
            if(enchant.length != 2) continue;

            itemStack.addEnchantment(Enchantment.getByName(enchant[0]), Integer.parseInt(enchant[1]));
        }

    }

    public ItemKit build() {
        return new ItemKit(this.itemStack, this.slot);
    }

}
