package com.kunyihua.customdrop.craftclass;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CustomItem
{
	//���~�W��
	public String ItemName;
	//���~�W��
	public int UseOriginalName;
	// ���~����
	public List<String> ItemLores;
	// ���~ID(��lID)
	public int ItemID;
	// �C��
	public byte Red;
	public byte Green;
	public byte Blue;
	// ���~����ID(��lID)
	public byte ItemSubID;
	// ���~���]
	public List<String> Enchants;
	// �o�쪺���~�ƶq
	public int Quantity;
	// �����v
	public double Chance;
	// ���w�a��
	public String OnlyWorld;
	
	public CustomItem(String newItemName,
					   int newUseOriginalName,
					   List<String> newItemLores,
					   int newItemID,
					   byte newRed,
					   byte newGreen,
					   byte newBlue,
					   byte newItemSubID,
					   List<String> newEnchants,
					   int newQuantity,
					   double newChance,
					   String newOnlyWorld)
	{	    
		// �]�w���
		this.ItemName = newItemName;
		this.UseOriginalName = newUseOriginalName;
		this.ItemLores = newItemLores;
		this.ItemID = newItemID;
		this.Red = newRed;
		this.Green = newGreen;
		this.Blue = newBlue;
		this.ItemSubID = newItemSubID;
		this.Enchants = newEnchants;
		this.Quantity = newQuantity;
		this.Chance = newChance;
		this.OnlyWorld = newOnlyWorld;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem()
	{
	    // ���ͪ��~��
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// �X����o�쪺���~�]�w
		if (this.ItemSubID != 0)
		{ ResultItem = new ItemStack(Material.getMaterial(this.ItemID), 1, this.ItemSubID); }
		else
		{ ResultItem = new ItemStack(Material.getMaterial(this.ItemID)); }
		// �P�_�O�_�n�]�w�C��
		if (this.ItemID == 298 || this.ItemID == 299|| this.ItemID == 300 || this.ItemID == 301)
		{
			LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
			LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
			ResultItem.setItemMeta(LeatherArmorMeta);
		}
		newItemMeta = ResultItem.getItemMeta();
		// ���]
		for (int i = 0; i < this.Enchants.size(); i++)
		{
			String[] EnchantsParts = this.Enchants.get(i).split(":");
			int level = Integer.parseInt(EnchantsParts[1]);
			Enchantment enchantment = Enchantment.getByName(EnchantsParts[0]);
			newItemMeta.addEnchant(enchantment, level, true);
		}
		// �W��
		if (this.UseOriginalName == 0)
		{
			newItemMeta.setDisplayName(this.ItemName);
		}
		// ����
		if (this.ItemLores.size() > 0)
		{
			newItemMeta.setLore(this.ItemLores);
		}
		// �g�J���
		ResultItem.setItemMeta(newItemMeta);
    	// �]�w�ƶq
		ResultItem.setAmount(this.Quantity);
	    // �]�w�@�[���̰�
		ResultItem.setDurability((short)0);
		// �^��
		return ResultItem;
	}
}