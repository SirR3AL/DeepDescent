package com.sirr3al_95.deepdescent.Items;

import com.sirr3al_95.deepdescent.init.DeepDescentItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCrystal extends ItemBlock
{
	public ItemBlockCrystal(Block block) 
	{
        super(block);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name;
		
		switch(itemstack.getItemDamage())
		{
		case 0:
			name = "_white";
			break;
		case 1:
			name = "_red";
			break;
		case 2:
			name = "_blue";
			break;
		case 3:
			name = "_cyan";
			break;
		case 4:
			name = "_light_blue";
			break;
		case 5:
			name = "_lime";
			break;
		case 6:
			name = "_green";
			break;
		case 7:
			name = "_purple";
			break;
		case 8:
			name = "_magenta";
			break;
		case 9:
			name = "_pink";
			break;
		case 10:
			name = "_yellow";
			break;
		case 11:
			name = "_orange";
			break;
		default:
			System.out.println("ERROR: Invalid metadata for Block Crystal");
			name = "Broken";
			break;
		}
		
		return this.getBlock().getUnlocalizedName() + name;
	}
}
