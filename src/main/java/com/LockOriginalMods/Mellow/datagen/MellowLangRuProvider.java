package com.LockOriginalMods.Mellow.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowLangRuProvider extends LanguageProvider {
    public MellowLangRuProvider(PackOutput output) {
        super(output, MOD_ID, "ru_ru");
    }

    @Override
    protected void addTranslations() {
        /*Items*/
        add("item.mellow.tin_ingot", "Слиток олова");
        add("item.mellow.raw_tin", "Сырое олово");
        /*Dusts*/
        add("item.mellow.aluminum_dust", "Алюминивая пыль");
        add("item.mellow.amethyst_dust", "Аметистовая пыль");
        add("item.mellow.brass_dust", "Латуневая пыль");
        add("item.mellow.coal_dust", "Угольная пыль");
        add("item.mellow.copper_dust", "Медная пыль");
        add("item.mellow.deepslate_dust", "Глубино-сланцевая пыль");
        add("item.mellow.gold_dust", "Золотая пыль");
        add("item.mellow.iron_dust", "Железная пыль");
        add("item.mellow.stone_dust", "Каменая пыль");
        /*Blocks*/
        add("block.mellow.tin_block","Блок олова");
        add("block.mellow.tin_ore", "Оловянная руда");
        add("block.mellow.raw_tin_block", "Блок сырого олова");
        add("block.mellow.deepslate_tin_ore", "Глубино-сланцевая оловянная руда");
        /*Creative tab*/
        add("creative.mellow_tab", "Mellow");
    }
}
