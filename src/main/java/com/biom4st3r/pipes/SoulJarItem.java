package com.biom4st3r.pipes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.Hand;
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
		CompoundTag itemNbt = iS.toTag(new CompoundTag());
		CompoundTag entityNbt = le.toTag(new CompoundTag());
		
		CompoundTag temp = new CompoundTag();
		if(!(le instanceof PlayerEntity))
		{
			logger.warn(le.getType().toString());
			EntityType<?> qq = le.getType();
			//logger.warn(qq);
			//logger.warn(qq.getEntityClass());
			BlockEntity be;
			be.
			qq.spawn(pE.world,new CompoundTag(),new TranslatableTextComponent(qq.toString()), pE, pE.getPos(), SpawnType.EVENT, false, false);
			//logger.warn(le.getClass().toString());
			//logger.warn(le.getEntityName().toString());
			//logger.warn(le.getType().getEntityClass().toString());
			//logger.warn(le.getType().getEntityClass().getName().toString());
			//logger.warn(le.getType().getEntityClass().getDeclaringClass().toString());
			
			//pE.addChatMessage(new TranslatableTextComponent(le.getClass().toString()), true);
			//pE.writeCustomDataToTag(compoundTag_1);
			//itemNbt.put(heldNpcProperty, entityNbt);
			iS.setTag(new CompoundTag().copyFrom(entityNbt));
			
			return true;
		}
		
		return false;
	}
	
	


}
