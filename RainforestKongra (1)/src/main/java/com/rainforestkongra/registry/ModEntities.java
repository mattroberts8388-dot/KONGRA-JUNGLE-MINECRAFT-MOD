package com.rainforestkongra.registry;

import com.rainforestkongra.RainforestKongraMod;
import com.rainforestkongra.entity.JaguarEntity;
import com.rainforestkongra.entity.KongraEntity;
import com.rainforestkongra.entity.ToucanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<KongraEntity> KONGRA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RainforestKongraMod.MOD_ID, "kongra"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KongraEntity::new)
                    .dimensions(EntityDimensions.fixed(1.6f, 3.2f))
                    .trackRangeBlocks(64)
                    .build()
    );

    public static final EntityType<JaguarEntity> JAGUAR = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RainforestKongraMod.MOD_ID, "jaguar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JaguarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f))
                    .trackRangeBlocks(32)
                    .build()
    );

    public static final EntityType<ToucanEntity> TOUCAN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RainforestKongraMod.MOD_ID, "toucan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ToucanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.7f))
                    .trackRangeBlocks(32)
                    .build()
    );

    public static void register() {
        ModItems.registerSpawnEggs(KONGRA, JAGUAR, TOUCAN);
    }
}