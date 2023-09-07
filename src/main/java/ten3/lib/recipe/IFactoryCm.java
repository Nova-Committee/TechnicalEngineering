package ten3.lib.recipe;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public interface IFactoryCm<T extends FormsCombinedRecipe> {

    T create(
            ResourceLocation idIn,
            ResourceLocation recipeRl,
            List<FormsCombinedIngredient> ip,
            List<FormsCombinedIngredient> op, int cookTimeIn
    );

}
