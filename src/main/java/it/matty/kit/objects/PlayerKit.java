package it.matty.kit.objects;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class PlayerKit {
    private final String name;
    private final List<? extends IKitItem> items = Lists.newArrayList();
}
