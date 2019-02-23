package com.biom4st3r.pipes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.command.arguments.EntityArgumentType.Serializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;



public class SoulJarItem extends Item {

	public static final Logger logger = LogManager.getLogger();
	
	public static final String heldNpcProperty = PipesMod.MODID + ".HELD_NPC";
	public SoulJarItem() {
		super(new Settings().stackSize(16).itemGroup(ItemGroup.MISC));
		//addProperty(new Identifier(heldNpcProperty), itemPropertyGetter_1);
		//this.addProperty(new Identifier("NPC_held"));
		// TODO Auto-generated constructor stub
		
	}
	
	
	@Override
	public boolean interactWithEntity(ItemStack iS,PlayerEntity pE, LivingEntity le, Hand hand)
	{
		//CompoundTag itemNbt = iS.toTag(new CompoundTag());
		//CompoundTag entityNbt = le.toTag(new CompoundTag());
		
		if(!(le instanceof PlayerEntity))// && storedEntity_type == null)
		{
			//logger.warn(le.getType().toString());
			//logger.warn(Tag.TYPES);
			//storedEntity_type = le.getType();
			//EntityType<?> ff = le.getType();//Creature, Monster
			
			//Identifier i = EntityType.getId(ff); //minecraft:cow
			
			//logger.warn(le.getEntityId()); // sequantial Spawn incriment
			//EntityType.Builder<Entity> tt;
			
			
			
			le.invalidate();
			
			iS.addAmount(-1);
			
			
			ItemStack soulJar = new ItemStack(iS.getItem(),1);
			soulJar.addEnchantment(new SoulStealEnchantment(), 1);
			
			//sji.storedEntity_type = le.getType();
			//sji.storedEntity_data = le.toTag(new CompoundTag());
			
			//((SoulJarItem)soulJar.getItem()).storedEntity_data = le.toTag(new CompoundTag());
			//((SoulJarItem)soulJar.getItem()).storedEntity_type = le.getType();
			pE.inventory.insertStack(soulJar);
			
			//ItemStack tempiS = new ItemStack(sji, 1);
			//tempiS.setDisplayName(new TranslatableTextComponent(storedEntity_type.toString()));
			//tempiS.setTag(new CompoundTag().put("Enchantments", ));
			
			//tempiS.setTag(new CompoundTag().);
			
			//pE.inventory.insertStack(tempiS);
			
			
			
			
			//logger.warn(qq);
			//logger.warn(qq.getEntityClass());
			
			//logger.warn(le.getClass().toString());
			//logger.warn(le.getEntityName().toString());
			//logger.warn(le.getType().getEntityClass().toString());
			//logger.warn(le.getType().getEntityClass().getName().toString());
			//logger.warn(le.getType().getEntityClass().getDeclaringClass().toString());
			
			//pE.addChatMessage(new TranslatableTextComponent(le.getClass().toString()), true);
			//pE.writeCustomDataToTag(compoundTag_1);
			//itemNbt.put(heldNpcProperty, entityNbt);
			return true;
		}
		logger.warn("Full");
		return false;
	}
	
	


}
