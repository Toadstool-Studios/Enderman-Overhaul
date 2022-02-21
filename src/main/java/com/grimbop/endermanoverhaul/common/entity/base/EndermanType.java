package com.grimbop.endermanoverhaul.common.entity.base;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;


public record EndermanType(
        ResourceLocation texture,
        ResourceLocation glowingTexture,
        ResourceLocation model,
        ResourceLocation animation,
        AttributeSupplier attributes

) {

    public static class Builder {
        private ResourceLocation texture;
        private ResourceLocation glowingTexture;
        private ResourceLocation model;
        private ResourceLocation animation;
        private final AttributeSupplier.Builder attributes = BaseEnderman.createAttributes();

        public Builder setTexture(ResourceLocation texture) {
            this.texture = texture;
            return this;
        }

        public Builder setGlowingTexture(ResourceLocation glowingTexture) {
            this.glowingTexture = glowingTexture;
            return this;
        }
        

        public Builder setModel(ResourceLocation model) {
            this.model = model;
            return this;
        }

        public Builder setAnimation(ResourceLocation animation) {
            this.animation = animation;
            return this;
        }

        public Builder addAttribute(Attribute attribute, double value) {
            this.attributes.add(attribute, value);
            return this;
        }


        public EndermanType build() {
            return new EndermanType(texture, glowingTexture, model, animation, attributes.build());
        }
    }

}