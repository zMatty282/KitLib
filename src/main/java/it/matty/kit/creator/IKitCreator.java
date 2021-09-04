package it.matty.kit.creator;

import it.matty.kit.objects.IKitItem;

import java.util.List;

public interface IKitCreator {

    String name();

    List<IKitItem> items();
}
