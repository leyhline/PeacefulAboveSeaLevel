/*
Minecraft Plugin: PeacefulAboveSeaLevel
Copyright (C) 2020  Thomas Leyh <thomas.leyh@mailbox.org>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
