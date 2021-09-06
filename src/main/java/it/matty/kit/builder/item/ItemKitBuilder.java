package it.matty.kit.builder.item;

import it.matty.kit.objects.items.ItemKit;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ItemKitBuilder {
    private final ItemStack itemStack;
    private int slot;

    public ItemKitBuilder(@NonNull FileConfiguration file, @NonNull String path) {
        this.slot = file.getInt(path + ".slot");
        this.itemStack = new ItemBuilder(Material.getMaterial(file.getString(path + ".material")))
                .setName(file.getString(path + ".name"))
                .setLore(file.getStringList(path + ".lore"))
                .setAmount(file.getInt(path + ".amount")).build();

        if(file.getStringList(path + ".enchants").isEmpty()) return;

        for(String key : file.getStringList(path + ".enchants")) {
            System.out.println(key);
            String[] enchant = key.split("#");
            if(enchant.length != 2) continue;

            itemStack.addEnchantment(Objects.requireNonNull(Enchantment.getByName(enchant[0])), Integer.parseInt(enchant[1]));
        }
    }

    public ItemKitBuilder setSlot(int i) {
        this.slot = i;
        return this;
    }

    public ItemKit build() {
        return new ItemKit(this.itemStack, this.slot);
    }

}
