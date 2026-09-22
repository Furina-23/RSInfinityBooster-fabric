package uk.co.hexeption.rsinfinitybooster.setup;

import com.refinedmods.refinedstorage.registry.DeferredRegister;
import com.refinedmods.refinedstorage.registry.RSRegistries;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

import net.minecraft.world.item.Item;

/**
 * Registration
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:27 pm
 */
public class Registration {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(RSRegistries.ITEMS, RSInfinityBooster.ID);

	public static void register() {
		ModItems.register();
		ITEMS.register();
	}

}
