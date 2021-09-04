package it.matty.kit.builder.item;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import lombok.SneakyThrows;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
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
        itemMeta.displayName(Component.translatable(text));
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        List<Component> componentList = Lists.newArrayList();

        for (String s : lore)
            componentList.add(Component.translatable(s));

        itemMeta.lore(componentList);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
