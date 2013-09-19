package com.FunshineX.hardenedclay.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import java.util.List;

public class BlockStainedClay extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public BlockStainedClay(int id, Material material)
    {
        super(id, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int i, int j)
    {
        return this.icons[j];
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    public static int getDyeFromBlock(int par0)
    {
        return ~par0 & 15;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < 16; ++i)
        {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.icons = new Icon[16];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.STAINEDCLAY_TEXTURE + ItemDye.dyeColorNames[getDyeFromBlock(i)]);
        }
    }
}
