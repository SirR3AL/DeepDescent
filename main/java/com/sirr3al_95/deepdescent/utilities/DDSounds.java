package com.sirr3al_95.deepdescent.utilities;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class DDSounds
{
    public static SoundEvent music;

    public static void registerSounds(IForgeRegistry<SoundEvent> registry)
    {
        music = registerSound(Reference.MODID + ".drop", registry);

    }

    private static SoundEvent registerSound(String soundName, IForgeRegistry<SoundEvent> registry)
    {
        ResourceLocation soundID = new ResourceLocation(Reference.MODID, soundName);
        SoundEvent result = new SoundEvent(soundID).setRegistryName(soundID);
        registry.register(result);
        return result;
    }
}