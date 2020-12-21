package com.sirr3al_95.deepdescent.blocks;

import com.sirr3al_95.deepdescent.DeepDescent;
import com.sirr3al_95.deepdescent.Items.ItemBlockCrystal;
import com.sirr3al_95.deepdescent.init.DeepDescentBlocks;
import com.sirr3al_95.deepdescent.init.DeepDescentItems;
import com.sirr3al_95.deepdescent.utilities.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrystal extends BlockBreakable implements IHasModel
{
	private final boolean ignoreSimilarity = false;
	
	public static final PropertyEnum<EnumCrystalType> typeProperty = PropertyEnum.create("type", EnumCrystalType.class);
	
	public BlockCrystal(String name) 
	{
		super(Material.GLASS, false);
		
		setSoundType(SoundType.GLASS);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DeepDescent.DEEP_DESCENT_TAB);
		setHardness(4.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
		
		setLightLevel(0.2F);
		setDefaultState(this.blockState.getBaseState().withProperty(typeProperty, EnumCrystalType.WHITE));
		
		DeepDescentBlocks.BLOCKS.add(this);
		DeepDescentItems.ITEMS.add(new ItemBlockCrystal(this).setRegistryName(this.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (blockState != iblockstate)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
	
	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return 15728880;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	
    @Override
    protected BlockStateContainer createBlockState() 
	{
        return new BlockStateContainer(this, typeProperty);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) 
    {
        return getDefaultState().withProperty(typeProperty, EnumCrystalType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) 
    {
        return ((EnumCrystalType) state.getValue(typeProperty)).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state) 
    {
        return getMetaFromState(state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs creativetabs, NonNullList<ItemStack> list) 
    {
    	for(EnumCrystalType type : EnumCrystalType.values())
    	{
    		list.add(new ItemStack(this, 1, type.getMeta()));
    	}
    }
    
    public enum EnumCrystalType implements IStringSerializable 
    {
        WHITE(0, "white"),
        RED(1, "red"),
    	BLUE(2, "blue"),
    	CYAN(3, "cyan"),
    	LIGHT_BLUE(4, "light_blue"),
    	LIME(5, "lime"),
    	GREEN(6, "green"),
    	PURPLE(7, "purple"),
    	MAGENTA(8, "magenta"),
    	PINK(9, "pink"),
    	YELLOW(10, "yellow"),
    	ORANGE(11, "orange");

    	public final int meta;
    	public final String name;
    	
    	private final static EnumCrystalType[] values = values();
    	
    	private EnumCrystalType(int meta, String name)
    	{
    		this.meta = meta;
    		this.name = name;
    	}
    	
        @Override
        public String getName() 
        {
            return this.name;
        }
        
        public int getMeta() 
        {
        	return this.meta;
        }
        
        public static EnumCrystalType byMetadata(int meta)
        {
        	return values[meta];
        }
    }
    
	@Override
	public void regsiterModels() 
	{
		for(EnumCrystalType type : EnumCrystalType.values())
    	{
			DeepDescent.proxy.registerItemRenderer(Item.getItemFromBlock(this), type.getMeta(), "type=" + type.toString().toLowerCase());
    	}
	}
}
