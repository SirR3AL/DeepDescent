package com.sirr3al_95.deepdescent.utilities.handlers;

import com.sirr3al_95.deepdescent.Items.ItemBlockCrystal;
import com.sirr3al_95.deepdescent.init.DeepDescentBiomes;
import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.IHasModel;
import com.sirr3al_95.deepdescent.world.DDOreGen;
import com.sirr3al_95.deepdescent.world.generators.CaveMossGenerator;
import com.sirr3al_95.deepdescent.world.generators.CrystalFormationGenerator;
import com.sirr3al_95.deepdescent.world.generators.StoneStalagmiteGenerator;
import com.sirr3al_95.deepdescent.world.generators.StoneStalagtiteGenerator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(DeepDescentItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : DeepDescentItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).regsiterModels();
			}
		}
		
		for(Block block : DeepDescentBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).regsiterModels();
			}
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(DeepDescentBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	public static void otherRegistries()
	{
		GameRegistry.registerWorldGenerator(new DDOreGen(), 0);
		GameRegistry.registerWorldGenerator(new CaveMossGenerator(), 0);
		GameRegistry.registerWorldGenerator(new StoneStalagtiteGenerator(), 0);
		GameRegistry.registerWorldGenerator(new StoneStalagmiteGenerator(), 0);
		GameRegistry.registerWorldGenerator(new CrystalFormationGenerator(128), 0);
		
		DeepDescentBiomes.registerBiomes();
	}
}
