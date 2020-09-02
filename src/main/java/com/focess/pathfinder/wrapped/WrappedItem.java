package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;

public class WrappedItem extends WrappedType {

    private static final Method asNMSCopy;

    private static final Method getItem;

    static {
        register(NMSManager.getNMSClass("Item", true), WrappedItem.class);
        Class<?> CraftItemStack = NMSManager.getCraftClass("inventory.CraftItemStack");
        asNMSCopy = NMSManager.getMethod(CraftItemStack, "asNMSCopy", ItemStack.class);
        getItem = NMSManager.getMethod(NMSManager.getNMSClass("ItemStack"), "getItem");
    }

    private final Object nmsItem;

    private WrappedItem(Object nmsItem) {
        this.nmsItem = nmsItem;
    }

    public static WrappedItem getWrappedItem(ItemStack itemStack) {
        try {
            Object nmsItem = getItem.invoke(asNMSCopy.invoke(null, itemStack));
            return getWrappedItem(nmsItem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WrappedItem getWrappedItem(Object nmsItem) {
        return new WrappedItem(nmsItem);
    }


    @Override
    public Object toNMS() {
        return this.nmsItem;
    }
}
