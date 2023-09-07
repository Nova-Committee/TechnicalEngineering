package ten3.core.machine.useenergy.compressor;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import ten3.lib.client.element.ElementBurnLeft;
import ten3.lib.client.element.ElementProgress;
import ten3.lib.tile.CmContainerMachine;
import ten3.lib.tile.CmScreenMachine;

public class CompressorScreen extends CmScreenMachine {

    public CompressorScreen(CmContainerMachine screenContainer, Inventory inv, Component titleIn) {

        super(screenContainer, inv, titleIn, "textures/gui/compressor.png", 256, 256);
        xSize = 176;
        ySize = 166;

    }

    ElementBurnLeft energy;
    ElementBurnLeft left;
    ElementProgress progress;

    public void addWidgets() {

        super.addWidgets();

        widgets.add(energy = getDefaultEne());
        widgets.add(left = new ElementBurnLeft(45, 36, 13, 13, 14, 0, handler));
        widgets.add(progress = new ElementProgress(76, 35, 22, 16, 27, 63, handler));

    }

    public void update() {

        energy.setPer(pEnergy());
        energy.setValue(energy(), maxEnergy());
        left.setPer(pEnergy());
        progress.setPer(pProgress());

    }

}
