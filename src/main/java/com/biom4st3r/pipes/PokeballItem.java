package com.biom4st3r.pipes;




import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ChatUtil;
import net.minecraft.util.Hand;




public class PokeballItem extends Item {
	public static final Logger logger = LogManager.getLogger();
	
	public static final String heldNpcTags = PipesMod.MODID + ".NPCTag";
	public static final String heldNpcName = PipesMod.MODID + ".NPCName";
	
	public PokeballItem() {
		super(new Settings().stackSize(16).itemGroup(ItemGroup.MISC));
		
	}
	private static String Capitalize(String s)
	{
		String t = s.substring(0,1);
		return t.toUpperCase() + s.substring(1);
	}

	
	@Override
	public boolean interactWithEntity(ItemStack iS,PlayerEntity pE, LivingEntity le, Hand hand)
	{
		
		if(!(le instanceof PlayerEntity) && !iS.hasEnchantments())// && storedEntity_type == null)
		{
			
			le.invalidate(); // Remove Clicked mob
			Item temp = iS.getItem();
			iS.addAmount(-1); 
			ItemStack soulJar = new ItemStack(temp,1);
			soulJar.setTag(new CompoundTag());
			//Begin SoulJarFull Definitition 
			String mobName = EntityType.getId(le.getType()).toString(); // returned mob name string i.E. minecraft:cow
			
			soulJar.getTag().put(heldNpcTags, le.toTag(new CompoundTag()));
			soulJar.getTag().putString(heldNpcName, mobName);
			soulJar.addEnchantment(new SoulStealEnchantment(), 1);
			
			mobName = Capitalize(mobName.substring((mobName.indexOf(':')+1)));
			soulJar.setDisplayName(new TranslatableTextComponent(TextFormat.RESET + mobName.replace('_', ' ') + " in a ball"));
			
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

			CompoundTag saferTag = (CompoundTag) iS.getTag().getTag(heldNpcTags);
			saferTag.remove("Pos"); // Pos was retained, because reflection
			saferTag.remove("UUIDLeast"); // matching UUID errors
			saferTag.remove("UUIDMost"); // matching UUID errors
			
			EntityType<?> et = EntityType.get(iS.getTag().getString(heldNpcName)).get();
			Entity e = et.spawn(iuc.getWorld(), new CompoundTag(), null, null, iuc.getBlockPos(), SpawnType.EVENT,false,false);

			//Class cls = e.getClass();
			//Method[] methods = cls.getMethods();
			try {
				//Method badSolution1 = e.getClass().getMethod("method_5651", CompoundTag.class);
				//badSolution1.setAccessible(true);
				//badSolution1.invoke(e, saferTag);
				Method badSolution2 = e.getClass().getMethod("method_5749", CompoundTag.class);
				badSolution2.setAccessible(true);
				badSolution2.invoke(e, saferTag);
				//Method badSolution3 = e.getClass().getMethod("method_5652", CompoundTag.class);
				//badSolution3.setAccessible(true);
				//badSolution3.invoke(e, saferTag);
				e.setPosition(iuc.getPos().x, iuc.getPos().y,iuc.getPos().z);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			for(int x = 0; x < methods.length; x++)
			{
				if(!methods[x].isAccessible() && methods[x].getParameterCount() == 1 && methods[x].getParameterTypes()[0] == CompoundTag.class && methods[x].getReturnType() == void.class)
				{
					logger.warn(x);
					logger.warn(methods[x].getName());
					methods[x].setAccessible(true);
				}
			}
			*/
			iS.addAmount(-1);
		}
		return super.useOnBlock(iuc);
	}
	
	


}
