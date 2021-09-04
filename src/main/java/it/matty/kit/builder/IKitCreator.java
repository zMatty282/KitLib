package it.matty.kit.builder;

import it.matty.kit.objects.IKitItem;

import java.util.List;

public interface IKitCreator {

    String name();

    List<IKitItem> items();
}
