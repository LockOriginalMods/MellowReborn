package com.LockOriginalMods.Mellow.Init;


import com.LockOriginalMods.Mellow.block.RubberCropBlock.RubberCropBlock;
import com.LockOriginalMods.Mellow.block.crusher.CrusherBlock;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);



    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ALUMINUM_ORE = registerBlock("aluminum_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));


    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DEEPSLATE)));


    public static final RegistryObject<Block> Electric_Furnace = registerBlock("electric_furnace", ()-> new ElectricFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> CRUSHER = registerBlock("crusher", ()-> new CrusherBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DEEPSLATE)));


    public static final RegistryObject<Block> RUBBER_CROP = BLOCKS.register("rubber_crop",
            ()-> new RubberCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties()));
  }

    private static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItems(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
