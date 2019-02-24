package com.biom4st3r.pipes;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;

public class SoulStealEnchantment extends Enchantment {

	protected SoulStealEnchantment() {
		super(Weight.COMMON, EnchantmentTarget.ALL, new EquipmentSlot[] {EquipmentSlot.HAND_MAIN});
		
		this.translationName = "Soul Stealer";
		
		
		
	}

	/* (non-Javadoc)
	 * @see net.minecraft.enchantment.Enchantment#getTextComponent(int)
	 */
	@Override
	public TextComponent getTextComponent(int int_1) {
		// TODO Auto-generated method stub
		return new TranslatableTextComponent("Soul Captured");
	}




	

}
