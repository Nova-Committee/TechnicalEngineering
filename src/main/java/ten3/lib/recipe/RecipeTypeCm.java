package ten3.lib.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeTypeCm<T extends Recipe<?>> implements RecipeType<T> {
    private final ResourceLocation resourceLocation;

    public RecipeTypeCm(ResourceLocation rl) {
        resourceLocation = rl;
    }

    @Override
    public String toString() {
        return resourceLocation.getPath();
    }

}
