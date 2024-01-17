package net.bryanc12.minecraft.stek;

import org.bukkit.plugin.java.JavaPlugin;

public final class Stek extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new net.bryanc12.minecraft.stek.events.PigStick(), this);
        getServer().getConsoleSender().sendMessage("[STEK] The plugin was started successfully!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[STEK] The plugin was stopped successfully!");
    }

}
