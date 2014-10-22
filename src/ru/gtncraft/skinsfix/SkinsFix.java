package ru.gtncraft.skinsfix;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SkinsFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        for (Player player : Bukkit.getServer().getOnlinePlayers())  {
            disguise(player);
        }
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void onPlayerJoin(final PlayerJoinEvent event) {
        disguise(event.getPlayer());
    }

    private void disguise(final Player player) {
        PlayerDisguise disguise = new PlayerDisguise(player.getName());
        disguise.setSkin(player.getName());
        DisguiseAPI.disguiseToAll(player, disguise);
    }
}
