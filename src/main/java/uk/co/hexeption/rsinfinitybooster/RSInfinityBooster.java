package uk.co.hexeption.rsinfinitybooster;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;
import uk.co.hexeption.rsinfinitybooster.setup.Registration;

public final class RSInfinityBooster implements ModInitializer {
    public static final String ID = "rsinfinitybooster";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    @Override
    public void onInitialize() {
        SERVER_CONFIG.getSpec().load(
            FabricLoader.getInstance().getConfigDir().resolve("rsinfinitybooster-server.json")
        );
        Registration.register();
        registerTab();
    }

    private static void registerTab() {
        CreativeModeTab tab = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.INFINITY_CARD.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.INFINITY_CARD.get());
                output.accept(ModItems.DIMENSION_CARD.get());
            })
            .title(Component.translatable("item_group." + ID + ".tab"))
            .build();
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(ID, "infinity_booster"),
            tab
        );
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
