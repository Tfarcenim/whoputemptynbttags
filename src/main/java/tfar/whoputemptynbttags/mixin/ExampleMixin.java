package tfar.whoputemptynbttags.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.whoputemptynbttags.WhoPutEmptyNbtTags;

@Mixin(Item.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "verifyTagAfterLoad")
	private void init(CompoundTag pCompoundTag, CallbackInfo ci) {
		if ((Object)this != Items.AIR && pCompoundTag != null && pCompoundTag.isEmpty()) {
			WhoPutEmptyNbtTags.LOGGER.warn("Someone has used an empty NBT tag on "+ this);
			new Throwable().printStackTrace();
		}
	}
}
