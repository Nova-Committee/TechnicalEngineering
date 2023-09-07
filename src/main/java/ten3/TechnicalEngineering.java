package ten3;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ten3.init.*;

@Mod(TConst.modid)
public class TechnicalEngineering {

    public TechnicalEngineering() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.regAll();
        FluidInit.regAll();
        TileInit.regAll();
        ContInit.regAll();

        ItemInit.regAll();
        RecipeInit.regAll();

        BlockInit.BLOCKS.register(bus);
        FluidInit.FLUIDS.register(bus);
        TileInit.TILES.register(bus);
        ContInit.CONS.register(bus);

        ItemInit.ITEMS.register(bus);
        RecipeInit.RECIPES_SERIALS.register(bus);
        RecipeInit.RECIPES_TYPES.register(bus);
    }

}
