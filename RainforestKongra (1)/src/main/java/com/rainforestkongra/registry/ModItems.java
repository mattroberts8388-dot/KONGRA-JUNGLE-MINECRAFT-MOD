package com.rainforestkongra.registry;

import com.rainforestkongra.RainforestKongraMod;
import com.rainforestkongra.item.KongraArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final KongraArmorMaterial KONGRA_MATERIAL = new KongraArmorMaterial();

    public static final Item RAINFOREST_FANG = new Item(new Item.Settings());
    public static final Item JUNGLE_ESSENCE = new Item(new Item.Settings());
    public static final Item KONGRA_SCALE = new Item(new Item.Settings());

    public static final Item KONGRA_HELMET = new ArmorItem(KONGRA_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item KONGRA_CHESTPLATE = new ArmorItem(KONGRA_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item KONGRA_LEGGINGS = new ArmorItem(KONGRA_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item KONGRA_BOOTS = new ArmorItem(KONGRA_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());

    // Spawn eggs registered later once entities exist (uses lazy suppliers not needed; entities registered before item group callback fires)
    public static SpawnEggItem KONGRA_SPAWN_EGG;
    public static SpawnEggItem JAGUAR_SPAWN_EGG;
    public static SpawnEggItem TOUCAN_SPAWN_EGG;

    public static final RegistryKey<ItemGroup> GROUP_KEY =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(RainforestKongraMod.MOD_ID, "main"));

    public static final ItemGroup GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(KONGRA_CHESTPLATE))
            .displayName(Text.translatable("itemGroup.rainforestkongra.main"))
            .build();

    private static Item reg(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RainforestKongraMod.MOD_ID, name), item);
    }

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, GROUP);

        reg("rainforest_fang", RAINFOREST_FANG);
        reg("jungle_essence", JUNGLE_ESSENCE);
        reg("kongra_scale", KONGRA_SCALE);
        reg("kongra_helmet", KONGRA_HELMET);
        reg("kongra_chestplate", KONGRA_CHESTPLATE);
        reg("kongra_leggings", KONGRA_LEGGINGS);
        reg("kongra_boots", KONGRA_BOOTS);

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(entries -> {
            entries.add(RAINFOREST_FANG);
            entries.add(JUNGLE_ESSENCE);
            entries.add(KONGRA_SCALE);
            entries.add(KONGRA_HELMET);
            entries.add(KONGRA_CHESTPLATE);
            entries.add(KONGRA_LEGGINGS);
            entries.add(KONGRA_BOOTS);
            if (KONGRA_SPAWN_EGG != null) entries.add(KONGRA_SPAWN_EGG);
            if (JAGUAR_SPAWN_EGG != null) entries.add(JAGUAR_SPAWN_EGG);
            if (TOUCAN_SPAWN_EGG != null) entries.add(TOUCAN_SPAWN_EGG);
        });
    }

    public static void registerSpawnEggs(EntityType<?> kongra, EntityType<?> jaguar, EntityType<?> toucan) {
        KONGRA_SPAWN_EGG = new SpawnEggItem((EntityType) kongra, 0x2b2b2b, 0x88ff44, new Item.Settings());
        JAGUAR_SPAWN_EGG = new SpawnEggItem((EntityType) jaguar, 0xd9a441, 0x3b2f1e, new Item.Settings());
        TOUCAN_SPAWN_EGG = new SpawnEggItem((EntityType) toucan, 0x111111, 0xffaa00, new Item.Settings());
        reg("kongra_spawn_egg", KONGRA_SPAWN_EGG);
        reg("jaguar_spawn_egg", JAGUAR_SPAWN_EGG);
        reg("toucan_spawn_egg", TOUCAN_SPAWN_EGG);
    }
}