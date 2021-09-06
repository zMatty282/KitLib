package it.matty.kit.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import it.matty.kit.builder.item.ItemKitBuilder;
import it.matty.kit.objects.items.IKitItem;
import it.matty.kit.objects.PlayerKit;
import it.matty.kit.objects.items.ItemKit;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

@Getter
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
    public void saveKit(FileConfiguration file, String kit, String path) {
        PlayerKit playerKit = getKit(kit);
        file.set(path + ".name", kit);

        int i = 0;
        for(IKitItem itemItem : playerKit.getItems()) {
            ItemKit item = (ItemKit) itemItem;
            List<String> enchants = Lists.newArrayList();
            String section = String.format("%s.items.%d.", path, i);

            file.set(section + "material", item.getItemStack().getType().name());
            file.set(section + "name", item.getItemStack().getItemMeta().getDisplayName());
            file.set(section + "lore", item.getItemStack().getItemMeta().getLore());
            file.set(section + "amount", item.getItemStack().getAmount());
            file.set(section + "slot", item.getSlot());

            for (Enchantment enchantment : item.getItemStack().getEnchantments().keySet()) {
                enchants.add(enchantment.getName() + "#" + item.getItemStack().getEnchantments().get(enchantment));
            }

            file.set(section + "enchants", enchants);
            enchants.clear();
            i++;
        }
    }

    @Override
    public void loadKit(FileConfiguration file, String path) {
        if(file.getConfigurationSection(path) == null) return;
        List<IKitItem> items = Lists.newArrayList();

        for(String item : file.getConfigurationSection(path + ".items").getKeys(true)) {
            items.add(new ItemKitBuilder(file, path + ".items." + item).build());
        }

        register(new PlayerKit(file.getString(path + ".name"), items));
    }

    @Override
    public void register(PlayerKit kit) {
        this.kits.add(kit);
    }
}
