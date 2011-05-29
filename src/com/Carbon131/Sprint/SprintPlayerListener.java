package com.Carbon131.Sprint;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class SprintPlayerListener extends PlayerListener
{
	public SprintPlayerListener(final Sprint plugin) {
	}
	
 	public void onPlayerMove(PlayerMoveEvent event) {
 		Player player = event.getPlayer();
 		if (player.isSneaking())
 		{
 	 		if ((Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.allow")))
 	 		{
 	 			if (Sprint.requiresitem == true)
 	 			{
 	                if (player.getInventory().getBoots().getTypeId() == Sprint.itemid || player.getInventory().getChestplate().getTypeId() == Sprint.itemid || player.getInventory().getHelmet().getTypeId() == Sprint.itemid || player.getInventory().getLeggings().getTypeId() == Sprint.itemid)
 	                {
 	 	 				int material = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ()).getTypeId();
 	 	 				if (material != 0 && material != 8 && material != 9 && material != 50 && material != 65)
 	 	 				{ 	  
 	 	 					if (Sprint.players.get(player) != null)
 	 	 					{
 	 	 						if ((Sprint.requirescommandenabled == true || Sprint.helditemenabled == true) && (Sprint.status.get(player) != null && Sprint.status.get(player).booleanValue() == true))
 	 	 						{
	 	 	 						double currentenergy = Sprint.players.get(player).doubleValue();
	 	 	 						double energy = minusenergy(currentenergy);
	 	 	 						Sprint.players.put(player, new Double(energy));
	 	 	 						if (energy > 0)
	 	 	 						{
	 	 	 							if (Sprint.highjumpenabled == true && (Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.highjump")))
	 	 	 							{
	 	 	 								Vector dir = player.getLocation().getDirection().multiply(Sprint.speed);
	 	 	 								player.setVelocity(dir);
	 	 	 							}
	 	 	 							else
	 	 	 							{
	 	 	 								Vector dir = player.getLocation().getDirection().multiply(Sprint.speed).setY(0);
	 	 	 								player.setVelocity(dir);
	 	 	 							}
	 	 	 							if (energy%Sprint.messagesinterval == 0 && Sprint.energylostpersecond != 0)
	 	 	 							{
	 	 	 								player.sendMessage("§"+ Sprint.energylostcolor + "Stamina: " + energy + "%");
	 	 	 							}
	 	 	 						}
	 	 	 						else
	 	 	 						{
	 	                				player.sendMessage("§4Stamina: 0% - You Must Rest!");
	 	 	 						} 	  
 	 	 						}
 	 	 						else if (Sprint.requirescommandenabled == false && Sprint.helditemenabled == false)
 	 	 						{
	 	 	 						double currentenergy = Sprint.players.get(player).doubleValue();
	 	 	 						double energy = minusenergy(currentenergy);
	 	 	 						Sprint.players.put(player, new Double(energy));
	 	 	 						if (energy > 0)
	 	 	 						{
	 	 	 							if (Sprint.highjumpenabled == true && (Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.highjump")))
	 	 	 							{
	 	 	 								Vector dir = player.getLocation().getDirection().multiply(Sprint.speed);
	 	 	 								player.setVelocity(dir);
	 	 	 							}
	 	 	 							else
	 	 	 							{
	 	 	 								Vector dir = player.getLocation().getDirection().multiply(Sprint.speed).setY(0);
	 	 	 								player.setVelocity(dir);
	 	 	 							}
	 	 	 							if (energy%Sprint.messagesinterval == 0 && Sprint.energylostpersecond != 0)
	 	 	 							{
	 	 	 								player.sendMessage("§"+ Sprint.energylostcolor + "Stamina: " + energy + "%");
	 	 	 							}
	 	 	 						}
	 	 	 						else
	 	 	 						{
	 	                				player.sendMessage("§4Stamina: 0% - You Must Rest!");
	 	 	 						} 	  
 	 	 						}
 	 	 					}
 	 	 					else
 	 	 					{
 	 	 						Sprint.players.put(player, new Double(100));
 	                		}
 	                	}
 	                }
 	 			}
 	 			else
 	 			{
	               	int material = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ()).getTypeId();
 	                if (material != 0 && material != 8 && material != 9 && material != 50 && material != 65)
 	                {
	                	if (Sprint.players.get(player) != null)
 	                	{
	 	 					if ((Sprint.requirescommandenabled == true || Sprint.helditemenabled == true) && (Sprint.status.get(player) != null && Sprint.status.get(player).booleanValue() == true))
 	 	 					{
	 	 	 					double currentenergy = Sprint.players.get(player).doubleValue();
	 	 	 					double energy = minusenergy(currentenergy);
	 	 	 					Sprint.players.put(player, new Double(energy));
	 	 	 					if (energy > 0)
	 	 	 					{
	 	 	 						if (Sprint.highjumpenabled == true && (Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.highjump")))
	 	 	 						{
	 	 	 							Vector dir = player.getLocation().getDirection().multiply(Sprint.speed);
	 	 	 							player.setVelocity(dir);
	 	 	 						}
	 	 	 						else
	 	 	 						{
	 	 	 							Vector dir = player.getLocation().getDirection().multiply(Sprint.speed).setY(0);
	 	 	 							player.setVelocity(dir);
	 	 	 						}
	 	 	 						if (energy%Sprint.messagesinterval == 0 && Sprint.energylostpersecond != 0)
	 	 	 						{
	 	 	 							player.sendMessage("§"+ Sprint.energylostcolor + "Stamina: " + energy + "%");
	 	 	 						}
	 	 	 					}
	 	 	 					else
	 	 	 					{
	 	                			player.sendMessage("§4Stamina: 0% - You Must Rest!");
	 	 	 					} 	  
 	 	 					}
	 	 					else if (Sprint.requirescommandenabled == false && Sprint.helditemenabled == false)
 	 	 					{
	 	 	 					double currentenergy = Sprint.players.get(player).doubleValue();
	 	 	 					double energy = minusenergy(currentenergy);
	 	 	 					Sprint.players.put(player, new Double(energy));
	 	 	 					if (energy > 0)
	 	 	 					{
	 	 	 						if (Sprint.highjumpenabled == true && (Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.highjump")))
	 	 	 						{
	 	 	 							Vector dir = player.getLocation().getDirection().multiply(Sprint.speed);
	 	 	 							player.setVelocity(dir);
	 	 	 						}
	 	 	 						else
	 	 	 						{
	 	 	 							Vector dir = player.getLocation().getDirection().multiply(Sprint.speed).setY(0);
	 	 	 							player.setVelocity(dir);
	 	 	 						}
	 	 	 						if (energy%Sprint.messagesinterval == 0 && Sprint.energylostpersecond != 0)
	 	 	 						{
	 	 	 							player.sendMessage("§"+ Sprint.energylostcolor + "Stamina: " + energy + "%");
	 	 	 						}
	 	 	 					}
	 	 	 					else
	 	 	 					{
	 	                			player.sendMessage("§4Stamina: 0% - You Must Rest!");
	 	 	 					} 	  
 	 	 					} 	                			
 	                	}
 	                	else
 	                	{
 	                		Sprint.players.put(player, new Double(100));
 	                	}
 	                }
 	 			}
 			}
 		} 
 		else
 		{
 			if (Sprint.players.get(player) != null)
 			{
 				double currentenergy = Sprint.players.get(player).doubleValue();
 				double energy = addenergy(currentenergy);
 				Sprint.players.put(player, new Double(energy));
 				if ((Math.floor((energy)*10)/10)%Sprint.messagesinterval == 0 && (Math.floor((energy)*10)/10) != 100  && Sprint.energylostpersecond != 0)
 				{
 					player.sendMessage("§" + Sprint.energygainedcolor + "Stamina: " + Math.floor(energy) + "%");
 				}
 				else if ((Math.floor((energy)*10)/10) == 99.9  && Sprint.energylostpersecond != 0)
 				{
 					player.sendMessage("§" + Sprint.energygainedcolor + "Stamina: 100%");
 				}
 			}
        }
 	}
 	
 	public void onPlayerInteract(PlayerInteractEvent event) {
 		Player player = event.getPlayer();
 		event.getAction();
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
 		{
 	 		if ((Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.allow")))
 	 		{
 	 			if (Sprint.helditemenabled == true)
 	 			{
 	 				if (player.getItemInHand().getTypeId() == Sprint.helditemid)
 	 				{
	 	 				if (Sprint.status.get(player) != null)
	 	 				{
	 	 					if (Sprint.status.get(player).booleanValue() == true)
	 	 					{
	 	 						Sprint.status.put(player, false);
	 	 						player.sendMessage("Sprinting disabled.");
	 	 					}
	 	 					else
	 	 					{
	 	 						Sprint.status.put(player, true);
	 	 						player.sendMessage("Sprinting enabled.");
	 	 					}
	 	 				}
	 	 				else
	 	 				{
	 	 					Sprint.status.put(player, true);
	 	 					player.sendMessage("Sprinting enabled.");
	 	 				}
 	 				}
 	 			}
 	 		}
 		}
 	}
 	
 	public double minusenergy(double currentenergy)
 	{
 		if (currentenergy > 0)
 		{
 			double newcurrentenergy = Math.floor((currentenergy - (Sprint.energylostpersecond*.1))*10)/10;
 			return newcurrentenergy;
 		}
 		else
 		{
 			return currentenergy;
 		}
 	}
 	
 	public double addenergy(double currentenergy)
 	{
 		if (currentenergy < 100)
 		{
 			double newcurrentenergy = ((currentenergy + (Sprint.energygainedpersecond*.1))*10)/10;
 			return newcurrentenergy;
 		}
 		else
 		{
 			return currentenergy;
 		}
 	}
}