package io.github.leyhline.PeacefulAboveSeaLevel;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PeacefulAboveSeaLevel extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new SpawnListener(), this);
    }
}
