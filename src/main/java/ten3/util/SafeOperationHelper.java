package ten3.util;

import net.minecraft.Util;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;

public class SafeOperationHelper {

    public static String regNameOf(IForgeRegistryEntry<?> entry) {

        return Objects.requireNonNull(entry.getRegistryName()).getPath();

    }

    static Random random = new Random();

    @SuppressWarnings("all")
    public static <T> T randomInCollection(Collection<T> col) {

        if (col == null) return null;
        if (col.size() == 0) return null;

        Object[] items = col.toArray();
        Object j = Util.getRandom(items, random);
        return (T) j;

    }

    public static int safeInt(Integer i) {

        if (i == null) return 0;

        return i;

    }

}
