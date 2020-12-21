package com.sirr3al_95.deepdescent;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.sirr3al_95.deepdescent.creativetabs.DeepDescentTab;
import com.sirr3al_95.deepdescent.init.DeepDescentDimensions;
import com.sirr3al_95.deepdescent.init.DeepDescentRecipes;
import com.sirr3al_95.deepdescent.proxy.CommonProxy;
import com.sirr3al_95.deepdescent.utilities.Reference;
import com.sirr3al_95.deepdescent.utilities.handlers.ConfigHandler;
import com.sirr3al_95.deepdescent.utilities.handlers.RegistryHandler;
import com.sirr3al_95.deepdescent.world.worldgen.WorldGenBedrockHole;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DeepDescent
{ 
	public static File config;
	
	@Instance
	public static DeepDescent instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs DEEP_DESCENT_TAB = new DeepDescentTab();

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	proxy.preInit();
    	
    	RegistryHandler.otherRegistries();
    	DeepDescentDimensions.registerDimensions();
    	ConfigHandler.registerConfig(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    	
    	DeepDescentRecipes.init();
    	GameRegistry.registerWorldGenerator(new WorldGenBedrockHole(), 0);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}
