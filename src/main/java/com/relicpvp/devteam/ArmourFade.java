/**
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.relicpvp.devteam;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Taylor on 16/01/2016.
 *
 * @author Taylorsamy
 */

public final class ArmourFade extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(Permissions.other);
        pm.addPermission(Permissions.self);
        new PlayerListener(this);
        saveReload();
    }

    private void saveReload() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.hasPermission(Permissions.self)) {
                PlayerListener.useNoPermission(player);
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Looks like the server is shutting down... I guess that means I should too.");
        getServer().getPluginManager().removePermission(Permissions.other);
        getServer().getPluginManager().removePermission(Permissions.self);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Commands commands = new Commands(sender, cmd, label, args);
        commands.checkForCommand();
        return true;
    }
}