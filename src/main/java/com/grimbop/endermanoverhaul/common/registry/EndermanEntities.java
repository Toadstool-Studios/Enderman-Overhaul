package com.grimbop.endermanoverhaul.common.registry;

import com.grimbop.endermanoverhaul.Endermen;
import com.grimbop.endermanoverhaul.common.entity.EndermanTypes;
import com.grimbop.endermanoverhaul.common.entity.base.BaseEnderman;
import com.grimbop.endermanoverhaul.common.entity.base.EndermanType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class EndermanEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Endermen.MODID);

    public static final RegistryObject<EntityType<BaseEnderman>> BADLANDS_ENDERMAN = ENTITY_TYPES.register("badlands_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.BADLANDS), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("badlands_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> CAVE_ENDERMAN = ENTITY_TYPES.register("cave_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.CAVE), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("cave_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> END_ISLANDS_ENDERMAN = ENTITY_TYPES.register("end_islands_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.END_ISLANDS), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("end_islands_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> DESERT_ENDERMAN = ENTITY_TYPES.register("desert_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.DESERT), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("desert_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> ICE_SPIKES_ENDERMAN = ENTITY_TYPES.register("ice_spikes_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.ICE_SPIKES), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("ice_spikes_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> SAVANNA_ENDERMAN = ENTITY_TYPES.register("savanna_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.SAVANNA), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("savanna_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> SNOWY_ENDERMAN = ENTITY_TYPES.register("snowy_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.SNOWY), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("snowy_enderman"));

    public static final RegistryObject<EntityType<BaseEnderman>> SWAMP_ENDERMAN = ENTITY_TYPES.register("swamp_enderman",
            () -> EntityType.Builder.<BaseEnderman>of((type, level) -> new BaseEnderman(type, level, EndermanTypes.SWAMP), MobCategory.MONSTER).sized(0.6F, 1.7F)
                    .clientTrackingRange(8).build("swamp_enderman"));
}
