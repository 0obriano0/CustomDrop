package com.kunyihua.customdrop.config;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.kunyihua.customdrop.craftclass.CustomItem;
import com.kunyihua.customdrop.GlobalVar;

public class LoadConfig
{	
	// �D�nŪ���]�w��
	private FileConfiguration data = null;
	
	// �}�ɥ�
	private File filePreload = null;
	
	public LoadConfig()
	{
		
	}
	
	// ��Ū�]�w��
	public void ReloadConfig()
	{
		// �T�{�ɮ׬O�_�s�b
	    this.filePreload = new File(GlobalVar.pluginMainDir + "config.yml");
	    if (this.filePreload.exists())
	    {
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else
	    {
	    	// �ɮפ��s�b�A�إ߹w�]��
	    	CreateDefaultConfig();
	    	// �����ɮ�
	    	this.filePreload = new File(GlobalVar.pluginMainDir + "config.yml");
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
		if (data.contains("CustomDrop"))
	    {
			// ���������~�W��
			String ItemName = "";
			// ���������~�O�_�M�έ�l�W��
			int UseOriginalName = 0;
			// ���������~����
			List<String> ItemLores = new ArrayList<String>();
			// ���������~ID(��lID)
			int ItemID = 0;
			// ���������~�W��(��l�W��)
			String ItemRealname = "";
			// ��m
			byte Red = 0;
			byte Green = 0;
			byte Blue = 0;
			// ���������~����ID(��lID)
			byte ItemSubID = 0;
			// ���������~���]
			List<String> Enchants = new ArrayList<String>();
			// ���������~�ƶq
			int Quantity = 1;
			// ���������v
			double Chance = 1000;
			// ��w�a��
			String OnlyWorld = "";
			// ��Ѫ��~����ID��
			String strItemID = "";
			
			// ���x�s���������M��
			List<CustomItem> dropItems = new ArrayList<CustomItem>();
			
			// ���o�ͪ��W��
			for (String entity_name : data.getConfigurationSection("CustomDrop").getKeys(false))
		    {
				// �M�żȦs��
				dropItems = new ArrayList<CustomItem>();
				// �j��Ū�X������
				for (String name : data.getConfigurationSection("CustomDrop." + entity_name).getKeys(false))
			    {
					// ###########################################
					// �M�żȦs��
					// ###########################################
					// ���������~�W��
					ItemName = "";
					// ���������~�O�_�M�έ�l�W��
					UseOriginalName = 0;
					// ���������~����
					ItemLores = new ArrayList<String>();
					// ���������~ID(��lID)
					ItemID = 0;
					// ���������~�W��(��l�W��)
					ItemRealname = "";
					// ��m
					Red = 0;
					Green = 0;
					Blue = 0;
					// ���������~����ID(��lID)
					ItemSubID = 0;
					// ���������~���]
					Enchants = new ArrayList<String>();
					// ���������~�ƶq
					Quantity = 1;
					// ���������v
					Chance = 1000;
					// ��w�a��
					OnlyWorld = "";
					// ��Ѫ��~����ID��
					strItemID = "";
					// ###########################################
					// �}�lŪ�����e
					// ###########################################
					// Ū�����~�W��
					ItemName = name.replaceAll("_", " ");
					// �O�_�M�έ�l�W��
					if (data.contains("CustomDrop." + entity_name + "." + name + ".UseCustomName"))
					{
						UseOriginalName = this.data.getInt("CustomDrop." + entity_name + "." + name + ".UseCustomName");
					}
					// ���~����
					if (data.contains("CustomDrop." + entity_name + "." + name + ".ItemLores"))
					{
						ItemLores = this.data.getStringList("CustomDrop." + entity_name + "." + name + ".ItemLores");
						for (int i = 0; i < ItemLores.size(); i++)
						{
							ItemLores.set(i, ItemLores.get(i).replace("_", " "));
						}
					}
					if (data.contains("CustomDrop." + entity_name + "." + name + ".ItemRealname"))
					{
						ItemRealname = this.data.getString("CustomDrop." + entity_name + "." + name + ".ItemRealname").toUpperCase();
					}
					// ���~ID
					if (data.contains("CustomDrop." + entity_name + "." + name + ".ItemID"))
					{
						strItemID = this.data.getString("CustomDrop." + entity_name + "." + name + ".ItemID");
						// �P�_���L�lID
						if (strItemID.indexOf(":") != -1)
						{
							ItemID = Integer.parseInt(strItemID.split(":")[0]);
							// �P�_�O�_���֥�(�lID���V��X)
							if (ItemID == 298 || ItemID == 299 || ItemID == 300 || ItemID == 301)
							{
								Red = Byte.parseByte(strItemID.split(":")[1].split(",")[0]);
								Green = Byte.parseByte(strItemID.split(":")[1].split(",")[1]);
								Blue = Byte.parseByte(strItemID.split(":")[1].split(",")[2]);
							}
							else
							{
								ItemSubID = Byte.parseByte(strItemID.split(":")[1]);
							}
						}
						else
						{
							ItemID = Integer.parseInt(strItemID);
							ItemSubID = 0;
						}
					}
					// ���o���]
					if (data.contains("CustomDrop." + entity_name + "." + name + ".Enchants"))
					{
						Enchants = this.data.getStringList("CustomDrop." + entity_name + "." + name + ".Enchants");
					}
					if (data.contains("CustomDrop." + entity_name + "." + name + ".Quantity"))
					{
						Quantity = this.data.getInt("CustomDrop." + entity_name + "." + name + ".Quantity");
					}
					if (data.contains("CustomDrop." + entity_name + "." + name + ".Chance"))
					{
						Chance = this.data.getDouble("CustomDrop." + entity_name + "." + name + ".Chance");
					}
					if (data.contains("CustomDrop." + entity_name + "." + name + ".OnlyWorld"))
					{
						OnlyWorld = this.data.getString("CustomDrop." + entity_name + "." + name + ".OnlyWorld");
					}
					// �P�_�O�_�����n��T
					if (ItemID > 0)
					{
						// �[�J
						dropItems.add(new CustomItem(ItemName, UseOriginalName, ItemLores, ItemID, ItemRealname, Red, Green, Blue, ItemSubID, Enchants, Quantity, Chance, OnlyWorld));
					}
					else
					{
						// ĵ�i
						System.out.println(GlobalVar.detailStr + "[ReloadConfig]" + entity_name + "��������" + name + "���]�wItemID!");
					}
			    }
				GlobalVar.CustomItemMap.put(entity_name, dropItems);
		    }
	    }
	}
	
	// �إ߹w�]��
	public void CreateDefaultConfig()
	{
		try
		{
			File createDir = new File(GlobalVar.pluginMainDir);
	
			if (!createDir.exists())
			{
				boolean dirCreated = false;
	
				int retries = 15;
	
				while ((!dirCreated) && (retries != 0))
				{
					retries--;
					dirCreated = createDir.mkdir();
				}
	
				if (!dirCreated)
				{
					System.out.println(GlobalVar.detailStr + "[CreateDefaultConfig]Directory failed to create. No permissions?");
					return;
				}
			}

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(GlobalVar.pluginMainDir + "config.yml")));
			out.write("CustomDrop:\r\n");
			out.write("#==========================#\r\n");
			out.write("#�ͪ�����ID                #\r\n");
			out.write("#CREEPER       : �W�O��    #\r\n");
			out.write("#SKELETON      : �u�\      #\r\n");
			out.write("#SPIDER        : �j��      #\r\n");
			out.write("#GIANT         : ���H      #\r\n");
			out.write("#ZOMBIE        : �L��      #\r\n");
			out.write("#SLIME         : �v�ܩi    #\r\n");
			out.write("#GHAST         : ���F����  #\r\n");
			out.write("#PIGZOMBIE     : �L�ͽޤH  #\r\n");
			out.write("#ENDERMAN      : �׬ɨϪ�  #\r\n");
			out.write("#CAVESPIDER    : �}�޻j��  #\r\n");
			out.write("#SILVERFISH    : ���Y��    #\r\n");
			out.write("#BLAZE         : �P�K�Ϫ�  #\r\n");
			out.write("#LAVASLIME     : �P�K�v�ܩi#\r\n");
			out.write("#ENDERDRAGON   : �׬��s    #\r\n");
			out.write("#WITHERBOSS    : ��s��    #\r\n");
			out.write("#WITCH       �@: �űC      #\r\n");
			out.write("#BAT           : ����      #\r\n");
			out.write("#PIG           : ��        #\r\n");
			out.write("#SHEEP         : ��        #\r\n");
			out.write("#COW           : ��        #\r\n");
			out.write("#CHICKEN       : ��        #\r\n");
			out.write("#SQUID         : ����      #\r\n");
			out.write("#WOLF          : �T        #\r\n");
			out.write("#MUSHROOMCOW   : Ĩۣ��    #\r\n");
			out.write("#SNOWMAN       : ���H      #\r\n");
			out.write("#OZELOT        : ��        #\r\n");
			out.write("#VILLAGERGOLEM : �K�H      #\r\n");
			out.write("#ENTITYHORSE   : ��        #\r\n");
			out.write("#VILLAGER      : ����      #\r\n");
			out.write("#==========================#\r\n");
			out.write("  ZOMBIE:\r\n");
			out.write("#==============#\r\n");
			out.write("#���������~�W��#\r\n");
			out.write("#==============#\r\n");
			out.write("    ��f���p������C��f:\r\n");
			out.write("#==========================#\r\n");
			out.write("#���������~�O�_�M�έ�l�W��#\r\n");
			out.write("#==========================#\r\n");
			out.write("      UseOriginalName: 1\r\n");
			out.write("#==============================#\r\n");
			out.write("#���������~��lID(�ҡG��C=268)#\r\n");
			out.write("#==============================#\r\n");
			out.write("      ItemID: 268\r\n");
			out.write("#���������~��l�W��(�ҡG��C=WOODEN_SWORD)#\r\n");
			out.write("#==============================#\r\n");
			out.write("      ItemRealname: WOODEN_SWORD\r\n");
			out.write("#==============#\r\n");
			out.write("#���������~����#\r\n");
			out.write("#==============#\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e���p���ۤv�d�X�Ӫ���C��f\r\n");
			out.write("#=============================#\r\n");
			out.write("#���������~���]               #\r\n");
			out.write("#- <���]>:<����>              #\r\n");
			out.write("#PROTECTION_ENVIRONMENTAL �O�@#\r\n");
			out.write("#PROTECTION_EXPLOSIONS ���z   #\r\n");
			out.write("#PROTECTION_PROJECTILE ���u   #\r\n");
			out.write("#PROTECTION_FIRE �ܤ�         #\r\n");
			out.write("#PROTECTION_FALL ����(�})     #\r\n");
			out.write("#ARROW_INFINITE �L���}        #\r\n");
			out.write("#ARROW_DAMAGE �j�O�}          #\r\n");
			out.write("#ARROW_FIRE ���V�}            #\r\n");
			out.write("#ARROW_KNOCKBACK �}���h       #\r\n");
			out.write("#DAMAGE_UNDEAD �����g�P       #\r\n");
			out.write("#DAMAGE_ALL �W�Q              #\r\n");
			out.write("#DAMAGE_ARTHROPODS �`�ϫg�P   #\r\n");
			out.write("#OXYGEN ���(�Y)              #\r\n");
			out.write("#DURABILITY �@�[              #\r\n");
			out.write("#LOOT_BONUS_BLOCKS ���B       #\r\n");
			out.write("#LOOT_BONUS_MOBS ����         #\r\n");
			out.write("#SILK_TOUCH ������Ĳ          #\r\n");
			out.write("#WATER_WORKER �ˤ���          #\r\n");
			out.write("#DIG_SPEED �Ĳv               #\r\n");
			out.write("#KNOCKBACK ���h�C             #\r\n");
			out.write("#FIRE_ASPECT ���K���[         #\r\n");
			out.write("#=============================#\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - DAMAGE_ALL:1\r\n");
			out.write("#==================#\r\n");
			out.write("#���������~�ƶq    #\r\n");
			out.write("#���G���]���~�L��  #\r\n");
			out.write("#==================#\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("#========================#\r\n");
			out.write("#���������v(0.01~100)    #\r\n");
			out.write("#�Y�L���]�w�h���100%����#\r\n");
			out.write("#========================#\r\n");
			out.write("      Chance: 100\r\n");
			out.write("#============================#\r\n");
			out.write("#���w�������@��              #\r\n");
			out.write("#�Y�L���]�w�h�����@�ɳ��|����#\r\n");
			out.write("#============================#\r\n");
			out.write("      OnlyWorld: world\r\n");
			out.write("#========#\r\n");
			out.write("#��L�d��#\r\n");
			out.write("#========#\r\n");
			out.write("  PIGZOMBIE:\r\n");
			out.write("    ��f���r�d-�u�L�v��f:\r\n");
			out.write("      ItemID: 339\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�����u�L�v�u�͡v�u�ޡv�u�H�v��f\r\n");
			out.write("      - ��e�Y�i�X���L�ͽޤH�����ơ�f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    ��f���r�d-�u�͡v��f:\r\n");
			out.write("      ItemID: 339\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�����u�L�v�u�͡v�u�ޡv�u�H�v��f\r\n");
			out.write("      - ��e�Y�i�X���L�ͽޤH�����ơ�f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    ��f���r�d-�u�ޡv��f:\r\n");
			out.write("      ItemID: 339\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�����u�L�v�u�͡v�u�ޡv�u�H�v��f\r\n");
			out.write("      - ��e�Y�i�X���L�ͽޤH�����ơ�f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    ��f���r�d-�u�H�v��f:\r\n");
			out.write("      ItemID: 339\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�����u�L�v�u�͡v�u�ޡv�u�H�v��f\r\n");
			out.write("      - ��e�Y�i�X���L�ͽޤH�����ơ�f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
		    out.close();
		}
		catch (Exception e)
		{
			System.out.println(GlobalVar.detailStr + "[CreateDefaultConfig]Error on create default config!");
		}
	}
}