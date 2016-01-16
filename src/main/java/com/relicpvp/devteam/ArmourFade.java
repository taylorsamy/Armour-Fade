package com.relicpvp.devteam;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmourFade extends JavaPlugin implements Listener {

	int r = 255;
	int g = 0;
	int b = 0;
	int time = 59;

	@Override
	public void onEnable() {
		getLogger().info("ArmourFade Actually Works! :D");
		Bukkit.getPluginManager().registerEvents(this, this);
		makeClockAndChangingTimers();
	}

	@Override
	public void onDisable() {
		getLogger().info("Looks like the server is shutting down... I guess that means I should too.");
	}

	public void makeClockAndChangingTimers() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {

//red = 255, green ++,
// green = 255,r --
//  r = 0, b ++
// b = 255, g --
// g = 0, r ++
// r = 255, b --

                if (r == 255 && b == 0 && g != 255){
                    g += 20;
                    if (g > 255){
                        g = 255;
                    }
                }
                if (g == 255 && r > 0){
                    r -= 20;
                    if (r < 0){
                        r = 0;
                    }
                }
                if (r == 0 && b != 255){
                    b += 20;
                    if (b > 255){
                        b = 255;
                    }
                }
                if (b == 255 && g > 0){
                    g -= 20;
                    if (g < 0){
                        g = 0;
                    }
                }
                if (g == 0 && r != 255){
                    r += 20;
                    if (r > 255){
                        r = 255;
                    }
                }
                if (r == 255 && b > 0){
                    b -= 20;
                    if (b < 0){
                        b = 0;
                    }
                }




				Color c = Color.fromRGB(r, g, b);
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player p = arrayOfPlayer[i];
					try {
						if (p.getInventory().getHelmet() != null && (p.getInventory().getHelmet().getItemMeta()
								.getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow helmet"))) {
							p.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET, c, "Rainbow Helmet"));
						}
						if ((p.getInventory().getChestplate() != null)
								&& (p.getInventory().getChestplate().getItemMeta().getDisplayName()
										.equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow chestplate"))) {
							p.getInventory()
									.setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE, c, "Rainbow Chestplate"));
						}
						if ((p.getInventory().getLeggings() != null) && (p.getInventory().getLeggings().getItemMeta()
								.getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow leggings"))) {
							p.getInventory()
									.setLeggings(getColorArmor(Material.LEATHER_LEGGINGS, c, "Rainbow Leggings"));
						}
						if ((p.getInventory().getBoots() != null) && (p.getInventory().getBoots().getItemMeta()
								.getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow boots"))) {
							p.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS, c, "Rainbow Boots"));
						}
					} catch (NullPointerException e) {

					}
				}
			}
		}, 0L, 2L);
	}
	public ItemStack getColorArmor(Material m, Color c, String displayName) {
		ItemStack i = new ItemStack(m, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_BLUE + displayName);
		meta.setColor(c);
		i.setItemMeta(meta);
		return i;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("afother")) {
			if (args.length == 1) {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				if (target == null) {
					sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY
							+ "]" + ChatColor.DARK_GREEN + args[0]
							+ " is not online... Did you think that would work?");
					return false;
				} else {
					PlayerInventory otherinventory = target.getInventory();
					ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
					ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
					ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
					ItemMeta helmetmeta = helmet.getItemMeta();
					helmetmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Helmet");
					helmet.setItemMeta(helmetmeta);
					ItemMeta chestmeta = chest.getItemMeta();
					chestmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Chestplate");
					chest.setItemMeta(chestmeta);
					ItemMeta legsmeta = legs.getItemMeta();
					legsmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Leggings");
					legs.setItemMeta(legsmeta);
					ItemMeta bootsmeta = boots.getItemMeta();
					bootsmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Boots");
					boots.setItemMeta(bootsmeta);
					otherinventory.addItem(helmet);
					otherinventory.addItem(chest);
					otherinventory.addItem(legs);
					otherinventory.addItem(boots);
					sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY
							+ "]" + ChatColor.DARK_GREEN + args[0] + " has been given rainbow armor!");
					target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY
							+ "]" + ChatColor.DARK_GREEN + " You have been given rainbow armor!");
				}
			} else {
				sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY + "]"
						+ ChatColor.DARK_GREEN + " Please specify a player");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("afself")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY + "]"
						+ ChatColor.DARK_GREEN + " Did you actually try to give the console rainbow armor?");
			} else {
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta helmetmeta = helmet.getItemMeta();
				helmetmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Helmet");
				helmet.setItemMeta(helmetmeta);
				ItemMeta chestmeta = chest.getItemMeta();
				chestmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Chestplate");
				chest.setItemMeta(chestmeta);
				ItemMeta legsmeta = legs.getItemMeta();
				legsmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Leggings");
				legs.setItemMeta(legsmeta);
				ItemMeta bootsmeta = boots.getItemMeta();
				bootsmeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Boots");
				boots.setItemMeta(bootsmeta);
				inventory.addItem(helmet);
				inventory.addItem(chest);
				inventory.addItem(legs);
				inventory.addItem(boots);
				sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY + "]"
						+ ChatColor.DARK_GREEN + " You gave yourself rainbow armor!");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("afinfo")) {
			sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmorFade" + ChatColor.DARK_GRAY + "]"
					+ ChatColor.DARK_GREEN + " Plugin created superminer10 and Taylorsamy for the Relic PVP Server");
		}
		return false;
	}
}