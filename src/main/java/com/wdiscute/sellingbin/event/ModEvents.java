package com.wdiscute.sellingbin.event;

import com.wdiscute.sellingbin.registry.ModDataMaps;
import com.wdiscute.sellingbin.SellingBin;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

@EventBusSubscriber(modid = SellingBin.MOD_ID)
public class ModEvents
{
    @SubscribeEvent
    public static void addRegistry(NewRegistryEvent event)
    {
        event.register(SellingBin.SELLING_BIN_REGISTRY);
    }

    @SubscribeEvent
    public static void registerAttributed(RegisterDataMapTypesEvent event)
    {
        event.register(ModDataMaps.SELLING_BIN_VALUE);
        event.register(ModDataMaps.SELLING_BIN_CURRENCIES);
    }
}
