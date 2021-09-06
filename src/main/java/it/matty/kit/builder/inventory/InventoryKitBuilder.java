package it.matty.kit.builder.inventory;

import com.google.common.collect.Lists;
import it.matty.kit.manager.IKitManager;
import it.matty.kit.objects.items.IKitItem;
import it.matty.kit.objects.PlayerKit;
import it.matty.kit.objects.items.ItemKit;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class InventoryKitBuilder {
    private final List<IKitItem> items;
    private final String name;

    public InventoryKitBuilder(String name, PlayerInventory inventory) {
        items = Lists.newArrayList();
        this.name = name;

        for(int i = 0; i < inventory.getSize(); i++) {
            if(inventory.getItem(i) == null) continue;
            items.add(new ItemKit(inventory.getItem(i), i));
        }
    }


    public void create(IKitManager manager) {
        manager.register(new PlayerKit(name, items));
    }
}
