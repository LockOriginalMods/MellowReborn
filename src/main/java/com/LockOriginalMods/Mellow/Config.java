    package com.LockOriginalMods.Mellow;

    import net.minecraftforge.common.ForgeConfigSpec;
    import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
    import net.minecraftforge.common.ForgeConfigSpec.IntValue;
    import net.minecraftforge.fml.common.Mod;

    import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

    // An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config extends ConfigTemplate
{
    private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
    private static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.IntValue TIMER_COOLDOWN;
    public static ForgeConfigSpec.IntValue MAX_STAGE;
    public static BooleanValue BREAKABLE_HANDLE;
    public static BooleanValue AUTOMATION_ALLOWED;
    static {
        CFG.comment("General settings").push(MOD_ID);
        AUTOMATION_ALLOWED = (BooleanValue) CFG.comment("\r\nTrue means automation is allowed as normal; false will disable the capabilities so hoppers, cables, pipes will not connect")
                .define("allowAutomation", true);
        BREAKABLE_HANDLE = CFG.comment("\r\nCan the handle break if its used too many times while the input is empty")
                .define("breakableHandle", true);
        TIMER_COOLDOWN = CFG.comment("\r\nHow many ticks must be in between two player interactions; this is the cooldown in between spins at maximum speed (20 ticks in one second)")
                .defineInRange("timerCooldown", 5, 1, 80);
        MAX_STAGE = CFG.comment("\r\nHow many stages (player uses) trigger a recipe. Each stage is one cardinal direction, meaning 4 stages is one full rotation")
                .defineInRange("stagesPerRecipe", 4, 1, 444);
        CFG.pop(); // one pop for every push
        COMMON_CONFIG = CFG.build();
    }

    public Config() {
        COMMON_CONFIG.setConfig(setup(MOD_ID));
    }


}
