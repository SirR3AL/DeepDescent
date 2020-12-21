package com.sirr3al_95.deepdescent.init;

import java.util.ArrayList;
import java.util.List;

import com.sirr3al_95.deepdescent.Items.ItemBase;
import com.sirr3al_95.deepdescent.Items.ItemBlockCrystal;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DeepDescentItems 
{
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Ingots and Gems
	public static final Item AQUAMARINE_GEM = new ItemBase("aquamarine_gem");
	public static final Item SAPPHIRE_GEM = new ItemBase("sapphire_gem");
	public static final Item AMETRINE_GEM = new ItemBase("ametrine_gem");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item ALUMINUM_INGOT = new ItemBase("aluminum_ingot");
	public static final Item TIN_INGOT = new ItemBase("tin_ingot");
}
