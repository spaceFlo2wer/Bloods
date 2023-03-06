package me.sanhak.bloods.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Location;

public class EntityDamageByEntity implements Listener {

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent entityDamageByEntityEvent) {
		int damage;

		if (entityDamageByEntityEvent.isCancelled() || entityDamageByEntityEvent.getDamage() <= 0.0f) {
			return;
		}

		if (entityDamageByEntityEvent.getEntity() instanceof Player
				&& entityDamageByEntityEvent.getDamager() instanceof Player) {
			// declare the variable
			damage = (int) entityDamageByEntityEvent.getDamage();
			// get object of player
			Player damagerPlayer = (Player) entityDamageByEntityEvent.getDamager();
			// Create a droplocation
			Location dropLocation = entityDamageByEntityEvent.getEntity().getLocation().add(0.5, -0.2, 0.5);

			// drop blood
			damagerPlayer.getLevel().dropItem(dropLocation,
					new Item(ItemID.REDSTONE_DUST, null, (int) ((damage / 100) * 0.5) * 5));
		}
	}
}
