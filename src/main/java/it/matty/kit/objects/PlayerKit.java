package it.matty.kit.objects;

import it.matty.kit.objects.items.IKitItem;
import lombok.Data;

import java.util.List;

@Data
public class PlayerKit {
    private final String name;
    private final List<IKitItem> items;
}
