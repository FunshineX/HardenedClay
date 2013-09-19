package com.FunshineX.hardenedclay.item;

import com.FunshineX.hardenedclay.block.BlockInfo;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class ItemStainedClay extends ItemBlock {
    public ItemStainedClay(int id) {
        super(id);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        String name = ItemDye.dyeColorNames[~stack.getItemDamage()&15] + BlockInfo.STAINEDCLAY_NAME;

        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
