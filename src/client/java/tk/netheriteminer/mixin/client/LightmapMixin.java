package tk.netheriteminer.mixin.client;

import net.minecraft.client.renderer.Lightmap;
import net.minecraft.client.renderer.state.LightmapRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tk.netheriteminer.commands.LightingCommand;

@Mixin(Lightmap.class)
public class LightmapMixin {
	@Inject(at = @At("HEAD"), method = "render", cancellable = true)
	private void disableLightUpdate(LightmapRenderState renderState, CallbackInfo info) {
		if (LightingCommand.isModEnabled()) {
			info.cancel();
		}
	}
}