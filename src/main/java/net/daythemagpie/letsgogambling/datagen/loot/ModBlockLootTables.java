package net.daythemagpie.letsgogambling.datagen.loot;

import net.daythemagpie.letsgogambling.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.EXPENSIVE_TWIST_WOOL.get());
        this.dropSelf(ModBlocks.EXPENSIVE_TILED_WOOL.get());
        this.dropSelf(ModBlocks.EXPENSIVE_STRIPED_WOOL.get());
        this.dropSelf(ModBlocks.EXPENSIVE_RETRO_WOOL.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> list = new ArrayList<>();
        list.add(ModBlocks.EXPENSIVE_TWIST_WOOL.get());
        list.add(ModBlocks.EXPENSIVE_TILED_WOOL.get());
        list.add(ModBlocks.EXPENSIVE_STRIPED_WOOL.get());
        list.add(ModBlocks.EXPENSIVE_RETRO_WOOL.get());


        return list::iterator;
    }
}
