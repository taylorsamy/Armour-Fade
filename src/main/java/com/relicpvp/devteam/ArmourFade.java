/**
 * @author taylorsamy
 */

package com.relicpvp.devteam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmourFade extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info("ArmourFade Actually Works! :D");

        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(Permissions.other);
        pm.addPermission(Permissions.use);

        colourChange();
    }

    @Override
    public void onDisable() {
        getLogger().info("Looks like the server is shutting down... I guess that means I should too.");
        getServer().getPluginManager().removePermission(Permissions.other);
        getServer().getPluginManager().removePermission(Permissions.use);
    }

    public void colourChange() {
        final Colour colour = new Colour();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {


                colour.createColour();
                checkInventory(colour.c);
            }
        }, 0L, 1L);
    }

    private void checkInventory(Color c) {

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!(player.hasPermission(Permissions.use))) {
                return;
            }
            try {
                if (player.getInventory().getHelmet() != null && (player.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow helmet"))) {
                    player.getInventory().setHelmet(setArmourMeta(Material.LEATHER_HELMET, c, (LeatherArmorMeta) player.getInventory().getHelmet().getItemMeta()));
                }
                if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow chestplate"))) {
                    player.getInventory().setChestplate(setArmourMeta(Material.LEATHER_CHESTPLATE, c, (LeatherArmorMeta) player.getInventory().getChestplate().getItemMeta()));
                }
                if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow leggings"))) {
                    player.getInventory().setLeggings(setArmourMeta(Material.LEATHER_LEGGINGS, c, (LeatherArmorMeta) player.getInventory().getLeggings().getItemMeta()));
                }
                if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow boots"))) {
                    player.getInventory().setBoots(setArmourMeta(Material.LEATHER_BOOTS, c, (LeatherArmorMeta) player.getInventory().getBoots().getItemMeta()));
                }
            } catch (NullPointerException e) {
                return;
            }
        }
    }



    public ItemStack setArmourMeta(Material m, Color c, LeatherArmorMeta meta) {
        ItemStack i = new ItemStack(m, 1);
        meta.setColor(c);
        i.setItemMeta(meta);
        return i;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Commands commands = new Commands(sender, cmd, label, args);
        commands.checkForCommand();
        return true;
    }
}