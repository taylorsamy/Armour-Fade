/**
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.relicpvp.devteam;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Created by Taylor on 16/01/2016.
 *
 * @author Taylorsamy
 */

public class ColourArmour {

    public Color c;
    static int r = 255;
    static int g = 0;
    static int b = 0;

    public void createColour() {
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
        c = Color.fromRGB(r, g, b);
    }

    public void checkInventory(Color c, Player player) {
        if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getItemMeta().hasDisplayName()) {
            if (player.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow helmet")) {
                player.getInventory().setHelmet(setArmourMeta(Material.LEATHER_HELMET, c, (LeatherArmorMeta) player.getInventory().getHelmet().getItemMeta()));
            }
        }
        if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getItemMeta().hasDisplayName()) {
            if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow chestplate"))) {
                player.getInventory().setChestplate(setArmourMeta(Material.LEATHER_CHESTPLATE, c, (LeatherArmorMeta) player.getInventory().getChestplate().getItemMeta()));
            }
        }
        if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getItemMeta().hasDisplayName()) {
            if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow leggings"))) {
                player.getInventory().setLeggings(setArmourMeta(Material.LEATHER_LEGGINGS, c, (LeatherArmorMeta) player.getInventory().getLeggings().getItemMeta()));
            }
        }
        if (player.getInventory().getBoots() != null && player.getInventory().getBoots().getItemMeta().hasDisplayName()) {
            if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "rainbow boots"))) {
                player.getInventory().setBoots(setArmourMeta(Material.LEATHER_BOOTS, c, (LeatherArmorMeta) player.getInventory().getBoots().getItemMeta()));
            }
        }
    }

    private ItemStack setArmourMeta(Material m, Color c, LeatherArmorMeta meta) {
        ItemStack item = new ItemStack(m, 1);
        meta.setColor(c);
        item.setItemMeta(meta);
        return item;
    }
}
