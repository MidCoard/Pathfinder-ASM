package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;

public class WrappedItemStack extends WrappedType {

    private static final Method asNMSCopy;

    static {
        register(NMSManager.getNMSClass("ItemStack", true), WrappedItemStack.class);
        Class<?> CraftItemStack = NMSManager.getCraftClass("inventory.CraftItemStack");
        asNMSCopy = NMSManager.getMethod(CraftItemStack, "asNMSCopy", ItemStack.class);
    }

    private final Object nmsItemStack;

    private WrappedItemStack(Object nmsItemStack) {
        this.nmsItemStack = nmsItemStack;
    }

    public static WrappedItemStack getWrappedItemStack(ItemStack itemStack) {
        try {
            Object nmsItemStack = asNMSCopy.invoke(null, itemStack);
            return getWrappedItemStack(nmsItemStack);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WrappedItemStack getWrappedItemStack(Object nmsItemStack) {
        return new WrappedItemStack(nmsItemStack);
    }

    @Override
    public Object toNMS() {
        return this.nmsItemStack;
    }
}
