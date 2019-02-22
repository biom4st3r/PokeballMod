package com.biom4st3r.pipes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PipesMod implements ModInitializer {
	
	public static final String MODID = "biom4st3r";
	
	//public static final Item tItem = new Item(new Settings().itemGroup(ItemGroup.MISC));
	public static final Block tBlock = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f, 1.0f).build());
	@Override
	public void onInitialize() 
	{
		//Registry.BLOCK.register(new Identifier(MODID,"pipe"),tBlock);
		Registry.ITEM.register(new Identifier(MODID,"souljar"),new SoulJarItem());
		//Registry.ITEM.register(new Identifier(MODID,"pipe"), new BlockItem(tBlock, new Item.Settings().stackSize(64).itemGroup(ItemGroup.MISC)));
		//System.out.println("Hello Fabric world!");
	}
}
