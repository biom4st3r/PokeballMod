package com.biom4st3r.pipes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PipesMod implements ModInitializer {
	
	public static final String MODID = "biom4st3r";
	
	//public static final Item tItem = new Item(new Settings().itemGroup(ItemGroup.MISC));
	//public static final Block tBlock = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f, 1.0f).build());
	
	public static final Enchantment SoulStealEnchantment = new SoulStealEnchantment();
	
	
	@Override
	public void onInitialize() 
	{
		//Registry.BLOCK.register(new Identifier(MODID,"pipe"),tBlock);
		Registry.ITEM.register(new Identifier(MODID,"pokeball"),new PokeballItem());
		Registry.register(Registry.ENCHANTMENT, new Identifier(MODID,"soulsteal"), SoulStealEnchantment);
		//Registry.ITEM.register(new Identifier(MODID,"pipe"), new BlockItem(tBlock, new Item.Settings().stackSize(64).itemGroup(ItemGroup.MISC)));
		//System.out.println("Hello Fabric world!");
	}
}
