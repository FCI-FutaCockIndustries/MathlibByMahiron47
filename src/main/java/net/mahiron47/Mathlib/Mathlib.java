package net.mahiron47.Mathlib;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = Mathlib.MODID, name = Mathlib.NAME, version = Mathlib.VERSION, acceptedMinecraftVersions = "[1.12.2]", useMetadata = true)
public class Mathlib {
    public static final String MODID = "belowhorizons";
    public static final String NAME = "BelowHorizons";
    public static final String VERSION = "1.0.0";

    private static Logger logger;
    public static WorldType worldType;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Created by Mahiron47");
    }
}