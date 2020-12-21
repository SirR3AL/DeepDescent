package com.sirr3al_95.deepdescent.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeepDescentRecipes 
{
	public static void init()
	{
		GameRegistry.addSmelting(DeepDescentBlocks.ACANTHITE_ORE_BLOCK, new ItemStack(DeepDescentItems.SILVER_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.SAPPHIRE_ORE_BLOCK, new ItemStack(DeepDescentItems.SAPPHIRE_GEM, 1), 5.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.AQUAMARINE_ORE_BLOCK, new ItemStack(DeepDescentItems.AQUAMARINE_GEM, 1), 5.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.AMETRINE_ORE_BLOCK, new ItemStack(DeepDescentItems.AMETRINE_GEM, 1), 8.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.COPPER_ORE_BLOCK, new ItemStack(DeepDescentItems.COPPER_INGOT, 1), 3.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.ALUMINUM_ORE_BLOCK, new ItemStack(DeepDescentItems.ALUMINUM_INGOT, 1), 3.0f);
		GameRegistry.addSmelting(DeepDescentBlocks.TIN_ORE_BLOCK, new ItemStack(DeepDescentItems.TIN_INGOT, 1), 3.0f);
	}
}
