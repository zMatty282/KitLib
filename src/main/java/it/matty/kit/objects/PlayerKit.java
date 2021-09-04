package it.matty.kit.objects;

import lombok.Data;

import java.util.List;

@Data
public class PlayerKit {
    private final String name;
    private final List<IKitItem> items;
}
