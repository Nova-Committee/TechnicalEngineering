package ten3.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ten3.TConst;
import ten3.lib.recipe.CmSerializer;
import ten3.lib.recipe.FormsCombinedRecipe;
import ten3.lib.recipe.FormsCombinedRecipeSerializer;
import ten3.lib.recipe.RecipeTypeCm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RecipeInit {

    public static final Map<ResourceLocation, RegistryObject<RecipeSerializer<?>>> regs = new HashMap<>();
    public static final Map<ResourceLocation, RegistryObject<RecipeType<?>>> types = new HashMap<>();
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES_SERIALS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TConst.modid);
    public static final DeferredRegister<RecipeType<?>> RECIPES_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, TConst.modid);

    public static void regAll() {
        regFormsCombined("pulverizer", 1, 4);
        regFormsCombined("compressor", 2, 1);
        regFormsCombined("psionicant", 2, 1);
        regFormsCombined("induction_furnace", 3, 1);
        regFormsCombined("refiner", 2, 2);
    }

    public static void regFormsCombined(String id, int i, int o) {
        final ResourceLocation rl = new ResourceLocation(TConst.modid, id);
        regRcp(rl, () -> new FormsCombinedRecipeSerializer<>(FormsCombinedRecipe::new, rl, i, o));
    }

    public static void regRcp(ResourceLocation id, Supplier<CmSerializer<?>> s) {
        RegistryObject<RecipeSerializer<?>> reg = RECIPES_SERIALS.register(id.getPath(), s);//singleton
        regs.put(id, reg);

        RegistryObject<RecipeType<?>> reg2 = RECIPES_TYPES.register(id.getPath(), () -> new RecipeTypeCm<>(id));//singleton
        types.put(id, reg2);
    }

    public static RecipeSerializer<?> getRcpSerializer(ResourceLocation id) {
        return regs.get(id).get();
    }

    public static RecipeType<?> getRcpType(ResourceLocation id) {
        return types.get(id).get();
    }

}
