package com.sirr3al_95.deepdescent.utilities;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IModelRegister 
{
	@SideOnly (Side.CLIENT)
	void registerModels();
}
