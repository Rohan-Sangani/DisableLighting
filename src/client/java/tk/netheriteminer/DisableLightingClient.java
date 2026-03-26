package tk.netheriteminer;

import net.fabricmc.api.ClientModInitializer;
import tk.netheriteminer.commands.LightingCommand;

public class DisableLightingClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        LightingCommand.registerCommand();
    }
}