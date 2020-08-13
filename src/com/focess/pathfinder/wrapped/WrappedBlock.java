package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import java.lang.reflect.Method;

public class WrappedBlock extends WrappedType {


    private static final Method getBlockMaterial;

    private static final Method getBlockMaterialByte;

    private static final Method getBlockMaterialData;

    private static final Method getBlock;

    static {
        register(NMSManager.getNMSClass("Block",true),WrappedBlock.class);
        Class<?> CraftMagicNumbers = NMSManager.getCraftClass("util.CraftMagicNumbers");
        Class<?> IBlockData = NMSManager.getNMSClass("IBlockData");
        getBlockMaterial = NMSManager.getMethod(CraftMagicNumbers,"getBlock",Material.class);
        getBlockMaterialByte = NMSManager.getMethod(CraftMagicNumbers,"getBlock",Material.class,byte.class);
        getBlockMaterialData = NMSManager.getMethod(CraftMagicNumbers,"getBlock", MaterialData.class);
        getBlock = NMSManager.getMethod(IBlockData,"getBlock");
    }

    private final Object nmsBlock;

    private WrappedBlock(Object nmsBlock) {
        this.nmsBlock = nmsBlock;
    }

    public static WrappedBlock getWrappedBlock(Object nmsBlock){
        return new WrappedBlock(nmsBlock);
    }

    public static WrappedBlock getWrappedBlock(Material material) {
        try {
            return getWrappedBlock(getBlockMaterial.invoke(null,material));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object getWrappedBlock0(Object iBlockData) {
        try {
            return getBlock.invoke(iBlockData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WrappedBlock getWrappedBlock(Material material,byte b){
        try {
            return getWrappedBlock(getWrappedBlock0(getBlockMaterialByte.invoke(null,material,b)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WrappedBlock getWrappedBlock(MaterialData materialData){
        try {
            return getWrappedBlock(getWrappedBlock0(getBlockMaterialData.invoke(null,materialData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object toNMS() {
        return this.nmsBlock;
    }
}
