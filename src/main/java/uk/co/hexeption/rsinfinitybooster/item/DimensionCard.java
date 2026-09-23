package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.item.UpgradeItem;
import net.minecraft.world.item.ItemStack;

/**
 * DimensionCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 01/03/2021 - 04:33 pm
 */
public class DimensionCard extends UpgradeItem {
	public DimensionCard() {
		super(Type.RANGE);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
}
