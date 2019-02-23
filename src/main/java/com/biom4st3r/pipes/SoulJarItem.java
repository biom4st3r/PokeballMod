package com.biom4st3r.pipes;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;




public class SoulJarItem extends Item {

	public static final Logger logger = LogManager.getLogger();
	
	public static final String heldNpcTags = PipesMod.MODID + ".NPCTag";
	public static final String heldNpcName = PipesMod.MODID + ".NPCName";
	public SoulJarItem() {
		super(new Settings().stackSize(16).itemGroup(ItemGroup.MISC));
		//addProperty(new Identifier(heldNpcProperty), itemPropertyGetter_1);
		//this.addProperty(new Identifier("NPC_held"));
		// TODO Auto-generated constructor stub
		
	}
	private static String Capitalize(String s)
	{
		String t = s.substring(0,1);
		return t.toUpperCase() + s.substring(1);
	}
	
	@Override
	public boolean interactWithEntity(ItemStack iS,PlayerEntity pE, LivingEntity le, Hand hand)
	{
		//CompoundTag itemNbt = iS.toTag(new CompoundTag());
		//CompoundTag entityNbt = le.toTag(new CompoundTag());
		
		if(!(le instanceof PlayerEntity) && !iS.hasEnchantments())// && storedEntity_type == null)
		{

			le.invalidate(); // Remove Clicked mob
			iS.addAmount(-1); 
			ItemStack soulJar = new ItemStack(iS.getItem(),1);
			//Begin SoulJarFull Definitition 
			
			String mobName = EntityType.getId(le.getType()).toString(); // returned mob name string i.E. minecraft:cow
			
			CompoundTag mobTypeName = new CompoundTag(); // { nbt data }
			mobTypeName.putString(heldNpcName, mobName);// { heldNpcName:""}
			logger.warn(mobTypeName);
			soulJar.setTag(mobTypeName); // { heldNpcName:"minecraft:cow" }
			
			CompoundTag mobAttributes = new CompoundTag();
			mobAttributes.put(heldNpcTags, le.toTag(new CompoundTag()));
			soulJar.setTag(mobAttributes);
			
			soulJar.addEnchantment(new SoulStealEnchantment(), 1);
	
			mobName = Capitalize(mobName.substring((mobName.indexOf(':')+1)));
			soulJar.setDisplayName(new TranslatableTextComponent(mobName + " Jar"));
			
			//end SoulJarFullDefinition
			pE.inventory.insertStack(soulJar);
			
			return true;
		}
		return false;
	}



	@Override
	public ActionResult useOnBlock(ItemUsageContext iuc) {
		if(iuc.getItemStack().hasEnchantments())
		{
			ItemStack iS = iuc.getItemStack();
			logger.warn(iS.getTag().getString(heldNpcName));
			//EntityType<?> et = EntityType.get(iS.getTag().getString(heldNpcName)).get();
			//et.spawn(iuc.getWorld(), iS.getSubCompoundTag(heldNpcTags), null, null, iuc.getBlockPos(), SpawnType.EVENT,false,false);
			//iS.addAmount(-1);
		}
		return super.useOnBlock(iuc);
	}
	
	


}
