package io.github.leyhline.PeacefulAboveSeaLevel;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnListener implements Listener {
    @EventHandler (ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        LivingEntity creature = event.getEntity();
        if (isMonster(creature) &&
                isAboveSeaLevel(creature.getLocation())) {
            event.setCancelled(true);
        }
    }

    private boolean isMonster(LivingEntity creature) {
        return Monster.class.isInstance(creature);
    }

    private boolean isAboveSeaLevel(Location loc) {
        World world = loc.getWorld();
        if (world.getEnvironment() == World.Environment.NORMAL &&
                loc.getY() >= world.getSeaLevel()) {
            return true;
        } else {
            return false;
        }
    }
}
