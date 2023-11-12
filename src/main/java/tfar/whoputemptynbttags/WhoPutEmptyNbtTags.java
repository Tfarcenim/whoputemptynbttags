package tfar.whoputemptynbttags;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WhoPutEmptyNbtTags.MODID)
public class WhoPutEmptyNbtTags
{
    public static final String MODID = "whoputemptynbttags";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public WhoPutEmptyNbtTags() {
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        //MinecraftForge.EVENT_BUS.addListener(this::blockBreak);
    }

    public void blockBreak(BlockEvent.BreakEvent event) {
        event.getPlayer().getMainHandItem().getOrCreateTag();
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
