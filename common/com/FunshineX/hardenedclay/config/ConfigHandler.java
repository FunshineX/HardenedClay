package com.FunshineX.hardenedclay.config;

import com.FunshineX.hardenedclay.block.BlockInfo;
import net.minecraftforge.common.Configuration;

import java.io.File;

public class ConfigHandler {

    public static void init(File file) {
        Configuration config = new Configuration(file);
        config.load();

        BlockInfo.HARDCLAY_ID = config.getBlock(BlockInfo.HARDCLAY_KEY, BlockInfo.HARDCLAY_DEFAULT).getInt();
        BlockInfo.STAINEDCLAY_ID = config.getBlock(BlockInfo.STAINEDCLAY_KEY, BlockInfo.STAINEDCLAY_DEFAULT).getInt();

        config.save();
    }
}
