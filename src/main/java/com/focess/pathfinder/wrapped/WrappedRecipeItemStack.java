package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class WrappedRecipeItemStack extends WrappedType {

    private static final Method asNMSCopy;

    private static Constructor<?> StackProviderConstructor;

    private static Constructor<?> RecipeItemStackConstructor;

    static {
        register(NMSManager.getNMSClass("RecipeItemStack", true), WrappedRecipeItemStack.class);
        Class<?> CraftItemStack = NMSManager.getCraftClass("inventory.CraftItemStack");
        asNMSCopy = NMSManager.getMethod(CraftItemStack, "asNMSCopy", ItemStack.class);
        Class<?> StackProvider = NMSManager.getNMSClass("RecipeItemStack$StackProvider", true);
        if (StackProvider != null)
            StackProviderConstructor = NMSManager.getConstructor(StackProvider, NMSManager.getNMSClass("ItemStack"));
        Class<?> RecipeItemStack = NMSManager.getNMSClass("RecipeItemStack", true);
        if (NMSManager.getVersionInt() >= 13)
            RecipeItemStackConstructor = NMSManager.getConstructor(RecipeItemStack, Stream.class);
        else if (NMSManager.getVersionInt() >= 12)
            RecipeItemStackConstructor = NMSManager.getConstructor(RecipeItemStack, NMSManager.arrayType(NMSManager.getNMSClass("ItemStack")));
    }

    private final Object nmsRecipeItemStack;

    private WrappedRecipeItemStack(Object nmsRecipeItemStack) {
        this.nmsRecipeItemStack = nmsRecipeItemStack;
    }

    public static WrappedRecipeItemStack getWrappedRecipeItemStack(Stream<ItemStack> itemStacks) {
        try {
            Object nmsRecipeItemStack;
            if (NMSManager.getVersionInt() >= 13) {
                nmsRecipeItemStack = RecipeItemStackConstructor.newInstance(itemStacks.map(i -> {
                    try {
                        return StackProviderConstructor.newInstance(asNMSCopy.invoke(null, i));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }));
            } else if (NMSManager.getVersionInt() >= 12) {
                Object array = Array.newInstance(NMSManager.getNMSClass("ItemStack"), (int) itemStacks.count());
                AtomicInteger pos = new AtomicInteger();
                itemStacks.forEach(i -> {
                    try {
                        Array.set(array, pos.getAndIncrement(), asNMSCopy.invoke(null, i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                nmsRecipeItemStack = RecipeItemStackConstructor.newInstance(array);
            } else throw new NullPointerException();
            return getWrappedRecipeItemStack(nmsRecipeItemStack);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WrappedRecipeItemStack getWrappedRecipeItemStack(Object nmsRecipeItemStack) {
        return new WrappedRecipeItemStack(nmsRecipeItemStack);
    }

    @Override
    public Object toNMS() {
        return null;
    }
}
