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

public final class armourfadev2 extends JavaPlugin implements Listener {
	


	int r = 0;
	int g = 0;
	int b = 0;
	int time = 59;

	@Override
	public void onEnable() {
		getLogger().info("ArmourFadeV2 Actually Works! :D"); // print startup
															// message to
															// console
		Bukkit.getPluginManager().registerEvents(this, this);
		makeClockAndChangingTimers();
	}

	@Override
	public void onDisable() {
		getLogger().info("Looks like the server is shutting down... I guess that means I should too."); // print
																										// shutdown
																										// message
																										// to
																										// console
	}

	public void makeClockAndChangingTimers() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				switch (time) {
				case 59:
					r = 255;
					g = 0;
					b = 0;
					time -= 1;
					break;
				case 58:
					r = 255;
					g = 68;
					b = 0;
					time -= 1;
					break;
				case 57:
					r = 255;
					g = 111;
					b = 0;
					time -= 1;
					break;
				case 56:
					r = 255;
					g = 171;
					b = 0;
					time -= 1;
					break;
				case 55:
					r = 255;
					g = 255;
					b = 0;
					time -= 1;
					break;
				case 54:
					r = 188;
					g = 255;
					b = 0;
					time -= 1;
					break;
				case 53:
					r = 128;
					g = 255;
					b = 0;
					time -= 1;
					break;
				case 52:
					r = 43;
					g = 255;
					b = 0;
					time -= 1;
					break;
				case 51:
					r = 0;
					g = 255;
					b = 9;
					time -= 1;
					break;
				case 50:
					r = 0;
					g = 255;
					b = 51;
					time -= 1;
					break;
				case 49:
					r = 0;
					g = 255;
					b = 111;
					time -= 1;
					break;
				case 48:
					r = 0;
					g = 255;
					b = 162;
					time -= 1;
					break;
				case 47:
					r = 0;
					g = 255;
					b = 230;
					time -= 1;
					break;
				case 46:
					r = 0;
					g = 239;
					b = 255;
					time -= 1;
					break;
				case 45:
					r = 0;
					g = 196;
					b = 255;
					time -= 1;
					break;
				case 44:
					r = 0;
					g = 173;
					b = 255;
					time -= 1;
					break;
				case 43:
					r = 0;
					g = 162;
					b = 255;
					time -= 1;
					break;
				case 42:
					r = 0;
					g = 137;
					b = 255;
					time -= 1;
					break;
				case 41:
					r = 0;
					g = 100;
					b = 255;
					time -= 1;
					break;
				case 40:
					r = 0;
					g = 77;
					b = 255;
					time -= 1;
					break;
				case 39:
					r = 0;
					g = 34;
					b = 255;
					time -= 1;
					break;
				case 38:
					r = 17;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 37:
					r = 37;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 36:
					r = 68;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 35:
					r = 89;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 34:
					r = 102;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 33:
					r = 124;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 32:
					r = 154;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 31:
					r = 222;
					g = 0;
					b = 255;
					time -= 1;
					break;
				case 30:
					r = 255;
					g = 0;
					b = 247;
					time -= 1;
					break;
				case 29:
					r = 255;
					g = 0;
					b = 179;
					time -= 1;
					break;
				case 28:
					r = 255;
					g = 0;
					b = 128;
					time = 59;
				}
				Color c = Color.fromRGB(r, g, b);
				// Logger log = Bukkit.getLogger();
				// for (Player player : Bukkit.getOnlinePlayers()) {
				// if (player.getInventory().getHelmet() == null){
				// // log.info("error handling FTW");
				// } else {
				// LeatherArmorMeta helmet = (LeatherArmorMeta)
				// player.getInventory().getHelmet().getItemMeta();
				// helmet.setColor(Color.AQUA);
				// //if (helmet.getDisplayName().equalsIgnoreCase("rainbow
				// helmet")) {
				// //helmet.setColor(Color.AQUA);
				// //}
				// log.info(helmet.getDisplayName());
				// }
				//
				// }
				//
				// }
				// }, 0l, 2l);
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
		}
		return false;
	}
}