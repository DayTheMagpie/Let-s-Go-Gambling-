package net.daythemagpie.letsgogambling.datagen;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.daythemagpie.letsgogambling.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(pOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput Writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SLOT_MACHINE.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.COMPARATOR)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(Writer);
    }
}