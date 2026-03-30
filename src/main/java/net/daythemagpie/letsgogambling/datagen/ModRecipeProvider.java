package net.daythemagpie.letsgogambling.datagen;

import net.daythemagpie.letsgogambling.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(pOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput Writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SLOT_MACHINE.get())
                .pattern("123")
                .pattern("454")
                .pattern("454")
                .define('1', Items.MANGROVE_BUTTON)
                .define('2', Items.COMPARATOR)
                .define('3', Items.LEVER)
                .define('4', Items.GOLD_NUGGET)
                .define('5', Items.IRON_INGOT)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POKER_TABLE.get())
                .pattern("111")
                .pattern("222")
                .pattern(" 3 ")
                .define('1', Items.GREEN_WOOL)
                .define('2', Items.GOLD_INGOT)
                .define('3', Items.STRIPPED_DARK_OAK_LOG)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROULETTE_TABLE.get())
                .pattern("#11")
                .pattern("222")
                .pattern(" 3 ")
                .define('#', Items.GOLD_BLOCK)
                .define('1', Items.GREEN_WOOL)
                .define('2', Items.GOLD_INGOT)
                .define('3', Items.STRIPPED_DARK_OAK_LOG)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.RED_WOOL), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPENSIVE_STRIPED_WOOL)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.RED_WOOL), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPENSIVE_RETRO_WOOL)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.RED_WOOL), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPENSIVE_TILED_WOOL)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.RED_WOOL), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPENSIVE_TWIST_WOOL)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(Writer);
    }
}