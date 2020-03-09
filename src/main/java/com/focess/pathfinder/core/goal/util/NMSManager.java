package com.focess.pathfinder.core.goal.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NMSManager {

    public static final Class<?> CraftEntity;
    // basic class
    public static final Class<?> CraftServer;
    public static final Class<?> CraftWorld;

    // NBT Builder
    private static final Method e;
    public static final Class<?> Entity;
    public static final Class<?> EntityPlayer;
    // basic
    private static final Map<Class<?>, Map<String, Field>> loadedFields = new HashMap<>();
    private static final Map<Class<?>, Map<String, Method>> loadedMethods = new HashMap<>();

    private static final Map<String, Class<?>> loadedNMSClasses = new HashMap<>();
    public static final Class<?> MinecraftServer;

    public static final Class<?> NBTTagCompound;
    private static int versionInt = -1;
    private static String versionString;
    public static final Class<?> World;
    public static final Class<?> WorldServer;
    private static String versionStringAsClassName;


    static {
        World = NMSManager.getNMSClass("World");
        MinecraftServer = NMSManager.getNMSClass("MinecraftServer");
        WorldServer = NMSManager.getNMSClass("WorldServer");
        CraftWorld = NMSManager.getCraftClass("CraftWorld");
        CraftServer = NMSManager.getCraftClass("CraftServer");
        EntityPlayer = NMSManager.getNMSClass("EntityPlayer");
        CraftEntity = NMSManager.getCraftClass("entity.CraftEntity");
        Entity = NMSManager.getNMSClass("FocessEntity");
        NBTTagCompound = NMSManager.getNMSClass("NBTTagCompound");
        if (NMSManager.getVersionInt() < 12)
            e = NMSManager.getMethod(NMSManager.Entity, "e", NMSManager.NBTTagCompound);
        else
            e = NMSManager.getMethod(NMSManager.Entity, "save", NMSManager.NBTTagCompound);
    }

    public static Object getConnection(final Player player) {
        final Method getHandleMethod = NMSManager.getMethod(player.getClass(), "getHandle");

        if (getHandleMethod != null)
            try {
                final Object nmsPlayer = getHandleMethod.invoke(player);
                final Field playerConField = NMSManager.getField(nmsPlayer.getClass(), "playerConnection");
                return playerConField.get(nmsPlayer);
            } catch (final Exception e) {
                e.printStackTrace();
            }

        return null;
    }

    public static Constructor<?> getConstructor(final Class<?> clazz, final Class<?>[] params) {
        try {
            return clazz.getConstructor(params);
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> getCraftClass(final String nmsClassName) {
        if (NMSManager.loadedNMSClasses.containsKey(nmsClassName))
            return NMSManager.loadedNMSClasses.get(nmsClassName);
        final String clazzName = "org.bukkit.craftbukkit." + NMSManager.getVersionString() + nmsClassName;
        final Class<?> clazz;
        try {
            clazz = Class.forName(clazzName);
        } catch (final Throwable t) {
            t.printStackTrace();
            return NMSManager.loadedNMSClasses.put(nmsClassName, null);
        }
        NMSManager.loadedNMSClasses.put(nmsClassName, clazz);
        return clazz;
    }

    public static Field getField(final Class<?> clazz, final String fieldName) {
        if (!NMSManager.loadedFields.containsKey(clazz))
            NMSManager.loadedFields.put(clazz, new HashMap<String, Field>());
        final Map<String, Field> fields = NMSManager.loadedFields.get(clazz);
        if (fields.containsKey(fieldName))
            return fields.get(fieldName);
        try {
            final Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            fields.put(fieldName, field);
            NMSManager.loadedFields.put(clazz, fields);
            return field;
        } catch (final Exception e) {
            e.printStackTrace();
            fields.put(fieldName, null);
            NMSManager.loadedFields.put(clazz, fields);
        }
        return null;
    }

    public static Method getMethod(final Class<?> clazz, final String methodName, final Class<?>... params) {
        if (!NMSManager.loadedMethods.containsKey(clazz))
            NMSManager.loadedMethods.put(clazz, new HashMap<String, Method>());
        final Map<String, Method> methods = NMSManager.loadedMethods.get(clazz);
        if (methods.containsKey(methodName) && Arrays.equals(methods.get(methodName).getParameterTypes(), params))
            return methods.get(methodName);
        try {
            final Method method = clazz.getDeclaredMethod(methodName, params);
            method.setAccessible(true);
            methods.put(methodName, method);
            NMSManager.loadedMethods.put(clazz, methods);
            return method;
        } catch (final Exception e) {
            e.printStackTrace();
            methods.put(methodName, null);
            NMSManager.loadedMethods.put(clazz, methods);
        }
        return null;
    }

    public static Class<?> getNMSClass(final String nmsClassName) {
        return getNMSClass(nmsClassName,false);
    }

    public static Class<?> getNMSClass(final String nmsClassName ,boolean flag) {
        if (NMSManager.loadedNMSClasses.containsKey(nmsClassName))
            return NMSManager.loadedNMSClasses.get(nmsClassName);
        final String clazzName = "net.minecraft.server." + NMSManager.getVersionString() + nmsClassName;
        final Class<?> clazz;
        try {
            clazz = Class.forName(clazzName);
        } catch (final Exception e) {
            if (!flag)
                e.printStackTrace();
            return NMSManager.loadedNMSClasses.put(nmsClassName, null);
        }
        NMSManager.loadedNMSClasses.put(nmsClassName, clazz);
        return clazz;
    }

    public static int getVersionInt() {
        if (NMSManager.versionInt == -1) {
            final String v = Bukkit.getServer().getClass().getPackage().getName();
            NMSManager.versionInt = Integer.parseInt(v.substring(v.lastIndexOf('.') + 1).split("_")[1]);
        }
        return NMSManager.versionInt;
    }

    public static String getVersionString() {
        if (NMSManager.versionString == null) {
            final String name = Bukkit.getServer().getClass().getPackage().getName();
            NMSManager.versionString = name.substring(name.lastIndexOf('.') + 1) + ".";
        }
        return NMSManager.versionString;
    }

    public static String getVersionStringAsClassName() {
        if (NMSManager.versionStringAsClassName == null)
            versionStringAsClassName = ("net.minecraft.server." + NMSManager.getVersionString()).replace(".","/");
        return NMSManager.versionStringAsClassName;
    }
}