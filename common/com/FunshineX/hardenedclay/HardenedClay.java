package com.FunshineX.hardenedclay;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import com.FunshineX.hardenedclay.block.BlockHardClay;
import com.FunshineX.hardenedclay.block.BlockInfo;
import com.FunshineX.hardenedclay.block.BlockStainedClay;
import com.FunshineX.hardenedclay.config.ConfigHandler;
import com.FunshineX.hardenedclay.item.ItemStainedClay;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

@Mod(modid=ModInformation.ID, name=ModInformation.NAME, version=ModInformation.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HardenedClay {

    public static Block hardenedClay;
    public static Block stainedClay;

    @Instance(ModInformation.ID)
    public static HardenedClay instance;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
    }

    @Init
    public void load(FMLInitializationEvent event) {
        hardenedClay = (new BlockHardClay(BlockInfo.HARDCLAY_ID, Material.rock)).setHardness(1.25F).setResistance(7.0F).setUnlocalizedName(BlockInfo.HARDCLAY_UNLOCALIZED_NAME);
        GameRegistry.registerBlock(hardenedClay, hardenedClay.getUnlocalizedName2());

        stainedClay = (new BlockStainedClay(BlockInfo.STAINEDCLAY_ID, Material.rock)).setHardness(1.25F).setResistance(7.0F).setUnlocalizedName(BlockInfo.STAINEDCLAY_UNLOCALIZED_NAME);
        GameRegistry.registerBlock(stainedClay, ItemStainedClay.class, stainedClay.getUnlocalizedName2());

        LanguageRegistry.addName(hardenedClay, BlockInfo.HARDCLAY_NAME);

        for (int i=0; i<ItemDye.dyeColorNames.length; i++) {
            String name = ItemDye.dyeColorNames[~i&15] + BlockInfo.STAINEDCLAY_NAME;
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            LanguageRegistry.addName(new ItemStack(stainedClay, 1, i), name);
        }

        for (int i=0; i<ItemDye.dyeColorNames.length; i++) {
            GameRegistry.addRecipe(new ItemStack(stainedClay, 8, BlockStainedClay.getDyeFromBlock(i)), new Object[] {"###", "#X#", "###", '#', new ItemStack(hardenedClay), 'X', new ItemStack(Item.dyePowder, 1, i)});
        }

        FurnaceRecipes.smelting().addSmelting(Block.blockClay.blockID, new ItemStack(hardenedClay), 0.35F);
    }

}
