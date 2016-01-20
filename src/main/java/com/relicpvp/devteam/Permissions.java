/**
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.relicpvp.devteam;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Taylor on 16/01/2016.
 *
 * @author Taylorsamy
 */

public class Permissions {
    public static Permission use = new Permission("armourfade.use");
    public static Permission give = new Permission("armourfade.give");
    public static Permission removeSelf = new Permission("armourfade.remove.self");
    public static Permission removeOther = new Permission("armourfade.remove.other");

    public static void init(PluginManager pm) {
        use.setDefault(PermissionDefault.FALSE);
        give.setDefault(PermissionDefault.FALSE);
        removeSelf.setDefault(PermissionDefault.FALSE);
        removeOther.setDefault(PermissionDefault.FALSE);
        pm.addPermission(use);
        pm.addPermission(give);
        pm.addPermission(removeSelf);
        pm.addPermission(removeOther);
    }
    public static void disable(PluginManager pm) {
        pm.removePermission(use);
        pm.removePermission(give);
        pm.removePermission(removeSelf);
        pm.removePermission(removeOther);
    }
}
