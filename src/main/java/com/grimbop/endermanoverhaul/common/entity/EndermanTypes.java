package com.grimbop.endermanoverhaul.common.entity;

import com.grimbop.endermanoverhaul.Endermen;
import com.grimbop.endermanoverhaul.common.entity.base.EndermanType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EndermanTypes {
    public static final EndermanType BADLANDS = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/badlands_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/badlands_enderman_glow.png"))
            .setModel(modLoc("geo/badlands_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType CAVE = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/cave_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/cave_enderman_glow.png"))
            .setModel(modLoc("geo/cave_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType END_ISLANDS = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/end_islands_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/end_islands_enderman_glow.png"))
            .setModel(modLoc("geo/end_islands_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType DESERT = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/desert_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/desert_enderman_glow.png"))
            .setModel(modLoc("geo/desert_enderman.geo.json"))
            .setAnimation(modLoc("animations/desert.enderman.walk.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType ICE_SPIKES = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/ice_spikes_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/ice_spikes_enderman_glow.png"))
            .setModel(modLoc("geo/ice_spikes_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType SAVANNA = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/savanna_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/savanna_enderman_glow.png"))
            .setModel(modLoc("geo/savanna_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType SNOWY = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/snowy_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/snowy_enderman_glow.png"))
            .setModel(modLoc("geo/snowy_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    public static final EndermanType SWAMP = new EndermanType.Builder()
            .setTexture(modLoc("textures/entity/swamp_enderman.png"))
            .setGlowingTexture(modLoc("textures/entity/swamp_enderman_glow.png"))
            .setModel(modLoc("geo/swamp_enderman.geo.json"))
            .setAnimation(modLoc("animations/enderman.animation.json"))
            .addAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5)
            .build();

    private static ResourceLocation modLoc(String string) {
        return new ResourceLocation(Endermen.MODID, string);
}}
