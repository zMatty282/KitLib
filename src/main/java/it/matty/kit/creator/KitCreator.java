package it.matty.kit.creator;

import it.matty.kit.manager.IKitManager;
import it.matty.kit.objects.PlayerKit;

public abstract class KitCreator implements IKitCreator {

    public KitCreator(IKitManager manager) {
        manager.register(new PlayerKit(name(), items()));
    }

}
