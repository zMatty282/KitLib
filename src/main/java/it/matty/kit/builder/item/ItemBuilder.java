package it.matty.kit.builder.item;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder setName(String text) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', text));
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        List<String> strings = Lists.newArrayList();

        for(String s : lore) {
            strings.add(ChatColor.translateAlternateColorCodes('&', s));
        }

        itemMeta.setLore(strings);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
