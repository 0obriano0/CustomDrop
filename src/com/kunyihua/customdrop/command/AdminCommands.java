package com.kunyihua.customdrop.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kunyihua.customdrop.craftclass.CustomItem;
import com.kunyihua.customdrop.GlobalVar;

public class AdminCommands implements CommandExecutor
{    
    public AdminCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// �P�_�O�_�����a�����O
		if (sender instanceof Player)
		{
			// �P�_���O����
			if (args.length == 0)
			{
				// ��ܻ���
				sender.sendMessage("��9==========��dCustomDrop��9==========");
				sender.sendMessage("��a/cdrop reload ��f- ��e��Ū�]�w��");
				sender.sendMessage("��a/cdrop list ��f- ��e�C�X�Ҧ��ͪ���������T");
				return true;
			}
			else
			{
				if (args[0].equals("reload"))
				{
					// �M���X����
					GlobalVar.server.resetRecipes();
					// �M����Ӫ�
					GlobalVar.CustomItemMap.clear();
					// ��Ū
					GlobalVar.loadConfig.ReloadConfig();
					sender.sendMessage(ChatColor.YELLOW +"�]�w��Ū������");
					return true;
				}
				else if (args[0].equals("list"))
				{
					// �j�����
					List<CustomItem> lstCustomItem = new ArrayList<CustomItem>();
					sender.sendMessage("��9==================================");
					for (String key : GlobalVar.CustomItemMap.keySet())
					{
						sender.sendMessage("��a�u" + GlobalVar.GetEntityName(key) + "�v");
						lstCustomItem = GlobalVar.CustomItemMap.get(key);
						for (CustomItem customItem : lstCustomItem)
						{
							if (customItem.OnlyWorld.equals(""))
							{
								sender.sendMessage("��a" + customItem.ItemName + "��a(��f" + customItem.Chance + "%��a������f" + customItem.Quantity + "��a��)");
							}
							else
							{
								sender.sendMessage("��a" + customItem.ItemName + "��a(��f" + customItem.Chance + "%��a������f" + customItem.Quantity + "��a��) - ���w�b��f" + customItem.OnlyWorld);
							}
						}
			        }
					sender.sendMessage("��9==================================");
					return true;
				}
			}
	    }
		else
		{
	    	sender.sendMessage("�����O���䴩����x�Ҧ�!");
	    	return false;
	    }
		return false;
	}
}