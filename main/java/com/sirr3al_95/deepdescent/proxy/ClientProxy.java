package com.sirr3al_95.deepdescent.proxy;

import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.utilities.DDSounds;
import com.sirr3al_95.deepdescent.utilities.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;

public class ClientProxy extends CommonProxy
{
	public static MusicTicker.MusicType MUSIC_TYPE_MARS;
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void preInit()
	{
		
	}
	
	@Override
	public void init()
	{
		MUSIC_TYPE_MARS = EnumHelper.addEnum(MusicTicker.MusicType.class, "MARS_JC", new Class[] { SoundEvent.class, Integer.TYPE, Integer.TYPE }, DDSounds.music, 12000, 24000);
	}
	
	@Override
	public void registerItemRenders()
	{
		
	}
	
	@Override
	public void registerBlockRenders(Block block, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), id));
	}
}
