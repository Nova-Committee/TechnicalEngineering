package ten3.core.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ten3.core.network.Network;
import ten3.core.network.packets.PTSChangeModePack;

import static ten3.core.client.TEKeyRegistry.C_CHANGE_MODE;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class TEKeys {

    @SubscribeEvent
    public static void inputEvent(InputEvent.KeyInputEvent e) {
        if (C_CHANGE_MODE.consumeClick()) {
            Network.sendToServer(new PTSChangeModePack());
        }
    }

}
