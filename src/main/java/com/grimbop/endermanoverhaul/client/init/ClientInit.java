package com.grimbop.endermanoverhaul.client.init;

import com.grimbop.endermanoverhaul.Endermen;
import com.grimbop.endermanoverhaul.client.renderer.normal.EndermanModel;
import com.grimbop.endermanoverhaul.client.renderer.normal.EndermanRenderer;
import com.grimbop.endermanoverhaul.common.entity.EndermanTypes;
import com.grimbop.endermanoverhaul.common.entity.base.BaseEnderman;
import com.grimbop.endermanoverhaul.common.entity.base.EndermanType;
import com.grimbop.endermanoverhaul.common.registry.EndermanEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Endermen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

    @SubscribeEvent
    public static void onClient(FMLClientSetupEvent event) {
        EntityRenderers.register(EndermanEntities.BADLANDS_ENDERMAN.get(), createRenderer(EndermanTypes.BADLANDS));
        EntityRenderers.register(EndermanEntities.CAVE_ENDERMAN.get(), createRenderer(EndermanTypes.CAVE));
        EntityRenderers.register(EndermanEntities.END_ISLANDS_ENDERMAN.get(), createRenderer(EndermanTypes.END_ISLANDS));
        EntityRenderers.register(EndermanEntities.DESERT_ENDERMAN.get(), createRenderer(EndermanTypes.DESERT));
        EntityRenderers.register(EndermanEntities.ICE_SPIKES_ENDERMAN.get(), createRenderer(EndermanTypes.ICE_SPIKES));
        EntityRenderers.register(EndermanEntities.SAVANNA_ENDERMAN.get(), createRenderer(EndermanTypes.SAVANNA));
        EntityRenderers.register(EndermanEntities.SNOWY_ENDERMAN.get(), createRenderer(EndermanTypes.SNOWY));
        EntityRenderers.register(EndermanEntities.SWAMP_ENDERMAN.get(), createRenderer(EndermanTypes.SWAMP));
    }

    private static <E extends BaseEnderman> EntityRendererProvider<E> createRenderer(EndermanType type) {
        return manager -> new EndermanRenderer<>(manager, new EndermanModel<>(type));
    }
}