package net.bryanc12.minecraft.stek.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PigStick implements Listener {

    @EventHandler
    public static void onPigStick(PlayerInteractAtEntityEvent event) {
//      Get the entity that was clicked
        Entity targetEntity = event.getRightClicked();

//      Check if the player is holding a stick
        boolean isStick = event.getPlayer().getInventory().getItemInMainHand().getType().toString().equals("STICK");
        if (!isStick) {
            return;
        }

//      Check if the entity is a pig
        boolean isPig = targetEntity.getName().equals("Pig");
        if (!isPig) {
            return;
        }

//      Cast the entity to a pig
        Pig targetPig = (Pig) targetEntity;

//      Check if the entity has a saddle
        boolean hasSaddle = targetPig.hasSaddle();
        if (!hasSaddle) {
            return;
        }

//      Remove saddle from pig and Drop the saddle
        Location pigLocation = targetPig.getLocation();
        ItemStack saddle = new ItemStack(Material.SADDLE, 1);
        World world = pigLocation.getWorld();

        targetPig.setSaddle(false);
        world.dropItem(pigLocation, saddle);
    }
}
