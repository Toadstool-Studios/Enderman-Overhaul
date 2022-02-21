package com.grimbop.endermanoverhaul;

import com.grimbop.endermanoverhaul.common.entity.EndermanTypes;
import com.grimbop.endermanoverhaul.common.registry.EndermanBlocks;
import com.grimbop.endermanoverhaul.common.registry.EndermanEntities;
import com.grimbop.endermanoverhaul.common.registry.EndermanItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.Random;
import java.util.stream.Collectors;

@Mod("endermanoverhaul")
public class Endermen
{
    public static final String MODID = "endermanoverhaul";

    private static final Logger LOGGER = LogManager.getLogger();

    public Endermen() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        EndermanBlocks.BLOCKS.register(modEventBus);
        EndermanItems.ITEMS.register(modEventBus);
        EndermanEntities.ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::addAttributes);
        modEventBus.addListener(this::onComplete);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        GeckoLib.initialize();

    }
    public void addAttributes(EntityAttributeCreationEvent event) {
        event.put(EndermanEntities.BADLANDS_ENDERMAN.get(), EndermanTypes.BADLANDS.attributes());
        event.put(EndermanEntities.CAVE_ENDERMAN.get(), EndermanTypes.CAVE.attributes());
        event.put(EndermanEntities.END_ISLANDS_ENDERMAN.get(), EndermanTypes.END_ISLANDS.attributes());
        event.put(EndermanEntities.DESERT_ENDERMAN.get(), EndermanTypes.DESERT.attributes());
        event.put(EndermanEntities.ICE_SPIKES_ENDERMAN.get(), EndermanTypes.ICE_SPIKES.attributes());
        event.put(EndermanEntities.SAVANNA_ENDERMAN.get(), EndermanTypes.SAVANNA.attributes());
        event.put(EndermanEntities.SNOWY_ENDERMAN.get(), EndermanTypes.SNOWY.attributes());
        event.put(EndermanEntities.SWAMP_ENDERMAN.get(), EndermanTypes.SWAMP.attributes());
    }
    public void onComplete(FMLLoadCompleteEvent event) {
        SpawnPlacements.register(EndermanEntities.BADLANDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.CAVE_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.END_ISLANDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.DESERT_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.ICE_SPIKES_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.SAVANNA_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.SNOWY_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
        SpawnPlacements.register(EndermanEntities.SWAMP_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Endermen::checkMonsterSpawnRulesAbove);
    }

    public static boolean checkMonsterSpawnRulesAbove(EntityType<? extends Monster> pType, ServerLevelAccessor pLevel, MobSpawnType pReason, BlockPos pPos, Random pRandom) {
        return pPos.getY() > pLevel.getSeaLevel() && pLevel.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(pLevel, pPos, pRandom) && Monster.checkMobSpawnRules(pType, pLevel, pReason, pPos, pRandom);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
        }
    }
}
