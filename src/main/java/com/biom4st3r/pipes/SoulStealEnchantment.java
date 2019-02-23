package com.biom4st3r.pipes;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;

public class SoulStealEnchantment extends Enchantment {

	protected SoulStealEnchantment() {
		super(Weight.COMMON, EnchantmentTarget.ALL, new EquipmentSlot[] {EquipmentSlot.HAND_MAIN});
		
		this.translationName = "Soul Stealer";
		
	}

	@Override
	public int getMinimumLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMaximumLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public TextComponent getTextComponent(int int_1) {
		// TODO Auto-generated method stub
		return new TranslatableTextComponent("Soul Captured");
	}

	@Override
	public boolean isAcceptableItem(ItemStack itemStack_1) {
		// TODO Auto-generated method stub
		if(itemStack_1.getItem() instanceof SoulJarItem)
		{
			return true;
		}
		return false;
	}
	

}
