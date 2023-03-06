package me.sanhak.bloods.main;

import cn.nukkit.plugin.PluginBase;
import me.sanhak.bloods.listeners.EntityDamageByEntity;

public class Main extends PluginBase {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
		getLogger().info("[Bloods] plugin has been enabled !");
	}

}
