package com.kunyihua.customdrop.event;

import java.lang.Math;
import java.util.List;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.kunyihua.customdrop.GlobalVar;
import com.kunyihua.customdrop.craftclass.CustomItem;

public class EntityDeathEvents implements Listener
{
    public EntityDeathEvents()
    {
    	
	}
    
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityDeathEvents(EntityDeathEvent event)
    {
    	// ���o�������ͪ�����
    	LivingEntity entityDeth = event.getEntity();
    	// �P�_�O�_�����a������
    	if (entityDeth.getKiller() != null &&
    		entityDeth.getKiller() instanceof Player)
    	{
    		Player killBy = entityDeth.getKiller();
    		String sEntitlyName = "";
    		sEntitlyName = entityDeth.getType().getName().toUpperCase();
    		killBy.sendMessage("�����F" + GlobalVar.GetEntityName(sEntitlyName));
    		// �P�_�O�_���������M��
    		if (GlobalVar.CustomItemMap.containsKey(sEntitlyName))
    		{
    			// ���o�������M��
    			List<CustomItem> dropItems = GlobalVar.CustomItemMap.get(sEntitlyName);
    			CustomItem customItem;
    			// �j��P�_�O�_�������~
    			for (int i = 0; i < dropItems.size(); i++)
    			{
    				customItem = dropItems.get(i);
    				// �P�_�@�ɬO�_���T
    				if (customItem.OnlyWorld.equals("") || customItem.OnlyWorld.toUpperCase().equals(entityDeth.getWorld().getName().toUpperCase()))
    				{
    					// ���o���(�q1~10000����@�Ӹ��X)
        				int iChance = (int)(Math.random() * 10000 + 1);
        				// �P�_���~�������v(���H100��)�O�_�p����
        				if (iChance <= (customItem.Chance * 100))
        				{
        					// �P�w����
        					System.out.print("�P�w����");
        					entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), customItem.getResultItem());
        					// ��ܱ����T��
        					killBy.sendMessage(GlobalVar.GetEntityName(sEntitlyName) + "��6�����F��f" + customItem.ItemName);
        				}
    				}
    			}
    		}
    	}
    }
}