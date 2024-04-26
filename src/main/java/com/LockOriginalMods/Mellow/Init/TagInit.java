package com.LockOriginalMods.Mellow.Init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagInit {
    public static void init() {
        Items.init();
    }

    private TagInit() {}

    public static class Items {
        private static void init() {
        }

        private Items() {
        }

        public static final TagKey<Item> SILICON = forgeTag("ingots/silicon");

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
