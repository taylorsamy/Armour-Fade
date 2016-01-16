/**
 * @author taylorsamy
 *
 * */

package com.relicpvp.devteam;

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

    private static final String PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmourFade" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_GREEN + " ";
    int r = 255;
    int g = 0;
    int b = 0;

    @Override
    public void onEnable() {
        getLogger().info("ArmourFade Actually Works! :D");
        Bukkit.getPluginManager().registerEvents(this, this);
        colourChange();
    }

    @Override
    public void onDisable() {
        getLogger().info("Looks like the server is shutting down... I guess that means I should too.");
    }

    public void colourChange() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {


                if (r == 255 && b == 0 && g != 255) {
                    g += 10;
                    if (g > 255) {
                        g = 255;
                    }
                }
                if (g == 255 && r > 0) {
                    r -= 10;
                    if (r < 0) {
                        r = 0;
                    }
                }
                if (r == 0 && b != 255) {
                    b += 10;
                    if (b > 255) {
                        b = 255;
                    }
                }
                if (b == 255 && g > 0) {
                    g -= 10;
                    if (g < 0) {
                        g = 0;
                    }
                }
                if (g == 0 && r != 255) {
                    r += 10;
                    if (r > 255) {
                        r = 255;
                    }
                }
                if (r == 255 && b > 0) {
                    b -= 15;
                    if (b < 0) {
                        b = 0;
                    }
                }


                Color c = Color.fromRGB(r, g, b);
                checkInventory(c);
            }
        }, 0L, 1L);
    }

    private void checkInventory(Color c) {
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
        for (int i = 0; i < j; i++) {
            Player p = arrayOfPlayer[i];
            try {
                if (p.getInventory().getHelmet() != null && (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow helmet"))) {
                    p.getInventory().setHelmet(setArmourMeta(Material.LEATHER_HELMET, c, "Rainbow Helmet", (LeatherArmorMeta) p.getInventory().getHelmet().getItemMeta()));
                }
                if ((p.getInventory().getChestplate() != null) && (p.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow chestplate"))) {
                    p.getInventory().setChestplate(setArmourMeta(Material.LEATHER_CHESTPLATE, c, "Rainbow Chestplate", (LeatherArmorMeta) p.getInventory().getChestplate().getItemMeta()));
                }
                if ((p.getInventory().getLeggings() != null) && (p.getInventory().getLeggings().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow leggings"))) {
                    p.getInventory().setLeggings(setArmourMeta(Material.LEATHER_LEGGINGS, c, "Rainbow Leggings", (LeatherArmorMeta) p.getInventory().getLeggings().getItemMeta()));
                }
                if ((p.getInventory().getBoots() != null) && (p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow boots"))) {
                    p.getInventory().setBoots(setArmourMeta(Material.LEATHER_BOOTS, c, "Rainbow Boots", (LeatherArmorMeta) p.getInventory().getBoots().getItemMeta()));
                }
            } catch (NullPointerException e) {

            }
        }
    }

    public ItemStack setArmourMeta(Material m, Color c, String displayName, LeatherArmorMeta meta) {
        ItemStack i = new ItemStack(m, 1);
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
                    sender.sendMessage(PREFIX + args[0] + " is not online... Did you think that would work?");
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

                    boolean success = false;
                    if (otherinventory.getHelmet() == null && otherinventory.getChestplate() == null && otherinventory.getLeggings() == null && otherinventory.getBoots() == null) {
                        success = true;
                    } else {
                        sender.sendMessage(PREFIX + target.getName() + " needs to remove their current armour first.");
                        target.sendMessage(PREFIX + sender.getName() + " tried to give you Rainbow Armour, but first you need to remove your current armour!");
                    }

                    if (success) {

                        otherinventory.setHelmet(helmet);
                        otherinventory.setChestplate(chest);
                        otherinventory.setLeggings(legs);
                        otherinventory.setBoots(boots);
                        sender.sendMessage(PREFIX + target.getName() + " has been given Rainbow Armour!");
                        target.sendMessage(PREFIX + sender.getName() + " gave you Rainbow Armour!");
                    }
                }
            } else {
                sender.sendMessage(PREFIX + "Please specify a player");
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("afself")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(PREFIX + "Did you actually try to give the console Rainbow Armour?");
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

                boolean success = false;
                if (inventory.getHelmet() == null && inventory.getChestplate() == null && inventory.getLeggings() == null && inventory.getBoots() == null) {
                    success = true;
                } else {
                    sender.sendMessage(PREFIX + "Please remove your current armour first");
                }
                if (success) {
                    inventory.setHelmet(helmet);
                    inventory.setChestplate(chest);
                    inventory.setLeggings(legs);
                    inventory.setBoots(boots);

                    sender.sendMessage(PREFIX + "You gave yourself Rainbow Armour!");
                }
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("afinfo")) {
            sender.sendMessage(PREFIX + "Plugin created superminer10 and Taylorsamy for the Relic PVP Server");
            return true;
        }
        return false;
    }
}