package com.sirr3al_95.deepdescent.utilities.handlers;

import com.sirr3al_95.deepdescent.utilities.DDTeleporter;
import com.sirr3al_95.deepdescent.world.dimensions.IDimension;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class DimensionHandler 
{	
	public static int[] DIMENSION_INT_LIST = {0, ConfigHandler.DROP_DIM_ID, ConfigHandler.MAZE_DIM_ID, ConfigHandler.CRYSTAL_DIM_ID};
	
	@SubscribeEvent
	public static void dimensionUpdate(PlayerTickEvent event)
	{
		if(event.player instanceof EntityPlayerMP)
		{
			EntityPlayerMP entity = (EntityPlayerMP) event.player;
			
			int DimID = entity.getServerWorld().provider.getDimension();
			int DimPos = 0;
			int playerPosY = (int)entity.posY;
			
			for(int x = 0; x < DIMENSION_INT_LIST.length; x++)
			{
				if(DIMENSION_INT_LIST[x] == DimID)
				{
					DimPos = x;
				}
			}
			
			try
			{
				if(DimID == 0)
				{
					if(playerPosY <= ConfigHandler.OVERWORLD_HEIGHT + 1 && entity.isSneaking())
					{
						int checkPlayerPosY = ((IDimension)entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos + 1]).provider).getHeight() - 3;
						
						entity.changeDimension(DIMENSION_INT_LIST[DimPos + 1], new DDTeleporter(entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos + 1]), entity.getServerWorld(), checkPlayerPosY));
					}
				}
				
				else if(entity.getEntityWorld().provider instanceof IDimension)
				{
					if(playerPosY <= ((IDimension)entity.getEntityWorld().provider).getMinHeight() + 1 && entity.isSneaking() && (DimPos + 1) != DIMENSION_INT_LIST.length)
					{
						int checkPlayerPosY = ((IDimension)entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos + 1]).provider).getHeight() - 3;
						
						entity.changeDimension(DIMENSION_INT_LIST[DimPos + 1], new DDTeleporter(entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos + 1]), entity.getServerWorld(), checkPlayerPosY));
					}
					
					
					else if(playerPosY >= ((IDimension)entity.getEntityWorld().provider).getHeight() - 2)
					{
						int checkPlayerPosY = 0;
						
						if(DIMENSION_INT_LIST[DimPos - 1] == 0)
						{
							checkPlayerPosY = ConfigHandler.OVERWORLD_HEIGHT + 2;
						}
						
						else
						{
							checkPlayerPosY = ((IDimension)entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos -1]).provider).getMinHeight() + 2;
						}
						
						entity.changeDimension(DIMENSION_INT_LIST[DimPos - 1], new DDTeleporter(entity.getServer().getWorld(DIMENSION_INT_LIST[DimPos - 1]), entity.getServerWorld(), checkPlayerPosY));
					}
				}
				
			}catch(ClassCastException e)
			{
				return;
			}
		}
	}
}
