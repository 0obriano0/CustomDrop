package com.kunyihua.customdrop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.LinkedList;

import org.bukkit.Server;

//import com.herocraftonline.heroes.Heroes;
import com.kunyihua.customdrop.config.LoadConfig;
//import com.kunyihua.genie.crafte.scoreboard.Scoreboard;
import com.kunyihua.customdrop.craftclass.CustomItem;

public class GlobalVar
{
	// �D����
	public static Main main;
	
	// �]�w��
	public static LoadConfig loadConfig;
	
	// ���A��
	public static Server server;
	
	// ������D
	public static String detailStr = "[CustomDrop]";
	
	// ����ؿ�
	public static String pluginMainDir = "./plugins/CustomDrop/";

	// �������~�M��
	public static Map<String, List<CustomItem>> CustomItemMap = new HashMap<String, List<CustomItem>>();

	// ��ܰT��
	public static void Print(String msg)
	{
		System.out.print(detailStr + msg);
	}
	
	// ���o�ͪ��W��(����)
	public static String GetEntityName(String entityId)
	{
		if (entityId.equals("CREEPER")) { return "�W�O��"; }
		else if (entityId.equals("SKELETON")) { return "�u�\"; }
		else if (entityId.equals("SPIDER")) { return "�j��"; }
		else if (entityId.equals("GIANT")) { return "���H"; }
		else if (entityId.equals("ZOMBIE")) { return "�L��"; }
		else if (entityId.equals("SLIME")) { return "�v�ܩi"; }
		else if (entityId.equals("GHAST")) { return "���F����"; }
		else if (entityId.equals("PIGZOMBIE")) { return "�L�ͽޤH"; }
		else if (entityId.equals("ENDERMAN")) { return "�׬ɨϪ�"; }
		else if (entityId.equals("CAVESPIDER")) { return "�}�޻j��"; }
		else if (entityId.equals("SILVERFISH")) { return "���Y��"; }
		else if (entityId.equals("BLAZE")) { return "�P�K�Ϫ�"; }
		else if (entityId.equals("LAVASLIME")) { return "�P�K�v�ܩi"; }
		else if (entityId.equals("ENDERDRAGON")) { return "�׬��s"; }
		else if (entityId.equals("WITHERBOSS")) { return "��s��"; }
		else if (entityId.equals("WITCH")) { return "�űC"; }
		else if (entityId.equals("BAT")) { return "����"; }
		else if (entityId.equals("PIG")) { return "��"; }
		else if (entityId.equals("SHEEP")) { return "��"; }
		else if (entityId.equals("COW")) { return "��"; }
		else if (entityId.equals("CHICKEN")) { return "��"; }
		else if (entityId.equals("SQUID")) { return "����"; }
		else if (entityId.equals("WOLF")) { return "�T"; }
		else if (entityId.equals("MUSHROOMCOW")) { return "Ĩۣ��"; }
		else if (entityId.equals("SNOWMAN")) { return "���H"; }
		else if (entityId.equals("OZELOT")) { return "��"; }
		else if (entityId.equals("VILLAGERGOLEM")) { return "�K�H"; }
		else if (entityId.equals("ENTITYHORSE")) { return "��"; }
		else if (entityId.equals("VILLAGER")) { return "����"; }
		return entityId;
	}
}