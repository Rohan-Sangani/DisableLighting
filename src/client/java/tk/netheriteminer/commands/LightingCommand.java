package tk.netheriteminer.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.minecraft.network.chat.Component;

public class LightingCommand {
    private static boolean modEnabled = true;

    public static void registerCommand() {
        // TODO: make translatable?
        Component currentlyEnabled = Component.literal("§eThe Disable Lighting Mod is currently §aenabled§e!");
        Component currentlyDisabled = Component.literal("§eThe Disable Lighting Mod is currently §cdisabled§e!");
        Component turnedOn = Component.literal("§eThe mod has been toggled to §aenabled§e! Due to Minecraft limitations and possibly my own bad programming, a restart may be required for the mod to work correctly again.");
        Component turnedOff = Component.literal("§eThe mod has been toggled to §cdisabled§e!");

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommands.literal("lighting")
            .executes(context -> {
                context.getSource().sendFeedback(modEnabled ? currentlyEnabled : currentlyDisabled);

                return 1;
            })

            .then(ClientCommands.literal("toggle")
                .executes(context -> {
                    modEnabled = !modEnabled;
                    context.getSource().sendFeedback(modEnabled ? turnedOn : turnedOff);

                    return 1;
                }))
        ));
    }

    public static boolean isModEnabled() {
        return modEnabled;
    }
}
