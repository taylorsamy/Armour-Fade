/**
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.relicpvp.devteam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Taylor on 16/01/2016.
 *
 * @author Taylorsamy
 */

public class Commands {
    private CommandSender sender;
    private Command cmd;
    private String[] args;
    private static final String PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "ArmourFade" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_GREEN + " ";

    ItemStack helmet;
    ItemStack chest;
    ItemStack legs;
    ItemStack boots;

    public Commands(CommandSender sender, Command cmd, String[] args) {
        this.sender = sender;
        this.cmd = cmd;
        this.args = args;
    }

    public void checkForCommand() {
        if (cmd.getName().equalsIgnoreCase("afother")) {
            if (!(sender.hasPermission(Permissions.other))) {
                sender.sendMessage(PREFIX + ChatColor.RED + "You do not have permission to use this command.");
                return;
            }
            afOther();
        } else if (cmd.getName().equalsIgnoreCase("afself")) {
            if (!(sender.hasPermission(Permissions.self))) {
                sender.sendMessage(PREFIX + ChatColor.RED + "You do not have permission to use this command.");
                return;
            }
            afSelf();
        } else if (cmd.getName().equalsIgnoreCase("afinfo")) {
            afInfo();
        }
    }

    private void afOther() {
        if (args.length == 0) {
            sender.sendMessage(PREFIX + "Please specify a player");
            return;
        }

        Player target = null;

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(args[0])) {
                target = player;
                break;
            }
        }

        if (target == null) {
            sender.sendMessage(PREFIX + args[0] + " is not online... Did you think that would work?");
        } else {
            PlayerInventory inv = target.getInventory();
            createRainbowArmour();

            boolean success = false;
            if (inv.getHelmet() == null && inv.getChestplate() == null && inv.getLeggings() == null && inv.getBoots() == null) {
                success = true;
            } else {
                sender.sendMessage(PREFIX + target.getName() + " needs to remove their current armour first.");
                target.sendMessage(PREFIX + sender.getName() + " tried to give you Rainbow Armour, but first you need to remove your current armour!");
            }

            if (success) {
                inv.setHelmet(helmet);
                inv.setChestplate(chest);
                inv.setLeggings(legs);
                inv.setBoots(boots);
                sender.sendMessage(PREFIX + target.getName() + " has been given Rainbow Armour!");
                target.sendMessage(PREFIX + sender.getName() + " gave you Rainbow Armour!");
                PlayerListener.useNoPermission(target);
            }
        }
    }

    private void afSelf() {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "Did you actually try to give the console Rainbow Armour?");
        } else {
            Player player = (Player) sender;
            PlayerInventory inv = player.getInventory();
            createRainbowArmour();

            boolean success = false;
            if (inv.getHelmet() == null && inv.getChestplate() == null && inv.getLeggings() == null && inv.getBoots() == null) {
                success = true;
            } else {
                sender.sendMessage(PREFIX + "Please remove your current armour first");
            }
            if (success) {
                inv.setHelmet(helmet);
                inv.setChestplate(chest);
                inv.setLeggings(legs);
                inv.setBoots(boots);

                sender.sendMessage(PREFIX + "You gave yourself Rainbow Armour!");
            }
        }
    }

    private void afInfo() {
        sender.sendMessage(PREFIX + "Plugin created by Taylorsamy and Superminer10 for the Relic PVP Server.");
        sender.sendMessage(PREFIX + "For more information, visit the wiki at https://github.com/taylorsamy/Armour-Fade/wiki.");
        sender.sendMessage(PREFIX + "This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.");
    }

    private void createRainbowArmour() {
        helmet = new ItemStack(Material.LEATHER_HELMET, 1);
        chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        boots = new ItemStack(Material.LEATHER_BOOTS, 1);

        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Helmet");
        helmet.setItemMeta(helmetMeta);

        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Chestplate");
        chest.setItemMeta(chestMeta);

        ItemMeta legsMeta = legs.getItemMeta();
        legsMeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Leggings");
        legs.setItemMeta(legsMeta);

        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.DARK_BLUE + "Rainbow Boots");
        boots.setItemMeta(bootsMeta);
    }
}
