package com.wdiscute.sellingbin.emi;

import com.wdiscute.sellingbin.SellingBin;
import com.wdiscute.sellingbin.processors.AbstractProcessor;
import com.wdiscute.sellingbin.registry.ModDataMaps;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SellingBinSellingEmptyEmiRecipe implements EmiRecipe
{
    public SellingBinSellingEmptyEmiRecipe()
    {
    }

    @Override
    public EmiRecipeCategory getCategory()
    {
        return SellingBinEmiPlugin.SELLING_BIN_SELLING_CATEGORY;
    }

    @Override
    public @Nullable ResourceLocation getId()
    {
        return SellingBin.rl("/selling/empty");
    }

    @Override
    public List<EmiIngredient> getInputs()
    {
        return List.of();
    }

    @Override
    public List<EmiStack> getOutputs()
    {
        return List.of();
    }

    @Override
    public int getDisplayWidth()
    {
        return 350;
    }

    @Override
    public int getDisplayHeight()
    {
        return 100;
    }

    @Override
    public void addWidgets(WidgetHolder widgets)
    {

        widgets.addText(Component.translatable("gui.selling_bin.selling.empty.0"), 5, 1, 0x000000, false);
        widgets.addText(Component.translatable("gui.selling_bin.selling.empty.1"), 5, 10, 0x000000, false);
        widgets.addText(Component.translatable("gui.selling_bin.selling.empty.2"), 5, 20, 0x000000, false);
        widgets.addText(Component.translatable("gui.selling_bin.selling.empty.3"), 5, 30, 0x000000, false);

    }
}
