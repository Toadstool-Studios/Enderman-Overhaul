package com.grimbop.endermanoverhaul.client.renderer.normal;

import com.grimbop.endermanoverhaul.common.entity.base.BaseEnderman;
import com.grimbop.endermanoverhaul.common.entity.base.EndermanType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;
import java.util.List;

public class EndermanModel<E extends BaseEnderman> extends AnimatedGeoModel<E> {

    private final EndermanType type;

    public EndermanModel(EndermanType type) {
        this.type = type;

    }

    @Override
    public ResourceLocation getModelLocation(E entity) {
        return type.model();
    }

    @Override
    public ResourceLocation getTextureLocation(E entity) {
        return type.texture();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(E entity)  {
        return type.animation();
    }


}

