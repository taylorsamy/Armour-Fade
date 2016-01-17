/**
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.relicpvp.devteam;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Taylor on 16/01/2016.
 *
 * @author Taylorsamy
 */

public class PlayerListener implements Listener {
    static ArmourFade plugin;

    public PlayerListener(ArmourFade plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        PlayerListener.plugin = plugin;
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();

        if (player.hasPermission(Permissions.self)) {
            startColourClock(player);
        }
    }

    private void startColourClock(final Player player) {
        final ColourArmour colourArmour = new ColourArmour();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                colourArmour.createColour();
                colourArmour.checkInventory(colourArmour.c, player);
            }
        }, 0L, 1L);
    }

    static public void useNoPermission(final Player player) {
        final ColourArmour colourArmour = new ColourArmour();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                colourArmour.createColour();
                colourArmour.checkInventory(colourArmour.c, player);
            }
        }, 0L, 1L);
    }
}
