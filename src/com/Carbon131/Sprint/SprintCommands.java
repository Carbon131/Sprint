package com.Carbon131.Sprint;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.config.Configuration;

public class SprintCommands implements CommandExecutor
{
	public SprintCommands(Sprint instance) 
    {
    }

    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
    	if(sender instanceof Player)
    	{
    	Player player = ((Player) sender);
    			if (label.equalsIgnoreCase("sprint"))
    			{
    	    		if ((Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.allow")))
    	    		{
        				if (args.length < 1)
        				{
        					player.sendMessage("------------------§6[ §eSprint Commands §6]§f------------------");
        					player.sendMessage("/sprint on §f: §3Enables sprinting.");
        					player.sendMessage("/sprint off §f: §3Disables sprinting.");
        					player.sendMessage("");
        					player.sendMessage("§4/sprint admin §f: §4Sprint Administration.");
        					return true;
        				}
	    	    		if (Sprint.requirescommandenabled == true)
	    				{
	        				if (args[0].equalsIgnoreCase("on"))
	        				{
	    		    	        sender.sendMessage("Sprinting enabled.");
	    		    	        Sprint.status.put(player, true);
	    					}
	        				if (args[0].toLowerCase().equals("off"))
	        				{
	    		    	        sender.sendMessage("Sprinting disabled.");
	    		    	        Sprint.status.put(player, false);
	    					}
	    				}
    	    		}
					else
					{
						sender.sendMessage("§cYou do not have access to that command.");
				    	return true;
					}
    	    		if ((Sprint.Permissions == null && player.isOp()) || (Sprint.Permissions != null && Sprint.Permissions.has(player, "sprint.admin")))
    	    		{
	    				if (args[0].equalsIgnoreCase("admin"))
	    				{
	    					if (args.length < 2)
	    					{
		    					sender.sendMessage("-----------§6[ §eSprint Administration (Page 1/2) §6]§f-----------");
		    					sender.sendMessage("/sprint speed §b<amount> §f: §3Change sprint speed.");
		    					sender.sendMessage("/sprint energygainedpersecond §b<amount> §f: §3Change energy gained per second.");
		    					sender.sendMessage("/sprint energylostpersecond §b<amount> §f: §3Change energy lost per second.");
		    					sender.sendMessage("/sprint highjump §b<enable|disable> §f: §3Enable/disable sprint highjump.");
		    					sender.sendMessage("/sprint requiresitem §b<enable|disable> §f: §3Enable/disable require item to wear.");
		    					sender.sendMessage("/sprint requirescommand §b<enable|disable> §f: §3Enable/disable require command to enable/disable sprinting.");
			    	        	return true;
	    					}
	    					if (args.length > 0)
	    					{
	    	    				if (args[1].equals("1"))
	    	    				{
			    					sender.sendMessage("-----------§6[ §eSprint Administration (Page 1/2) §6]§f-----------");
			    					sender.sendMessage("/sprint speed §b<amount> §f: §3Change sprint speed.");
			    					sender.sendMessage("/sprint energygainedpersecond §b<amount> §f: §3Change energy gained per second.");
			    					sender.sendMessage("/sprint energylostpersecond §b<amount> §f: §3Change energy lost per second.");
			    					sender.sendMessage("/sprint highjump §b<enable|disable> §f: §3Enable/disable sprint highjump.");
			    					sender.sendMessage("/sprint requiresitem §b<enable|disable> §f: §3Enable/disable require item to wear.");
			    					sender.sendMessage("/sprint requirescommand §b<enable|disable> §f: §3Enable/disable require command to enable/disable sprinting.");
				    	        	return true;
	    	    				}
			    				else if (args[1].equals("2"))
		    	    			{
			    					sender.sendMessage("-----------§6[ §eSprint Administration (Page 2/2) §6]§f-----------");
			    					sender.sendMessage("/sprint helditem §b<enable|disable> §f: §3Enable/disable being able to enable/disable sprint using an item.");
			    					sender.sendMessage("/sprint helditemid §b<id> §f: §3Change the item that is used to enable/disable sprinting.");
			    					sender.sendMessage("/sprint itemid §b<id> §f: §3Change the required item to be worn.");
			    					sender.sendMessage("/sprint messagesinterval §b<seconds> §f: §3Change the interval between messages sent while sprinting.");
			    					sender.sendMessage("/sprint energygainedcolor §b<color> §f: §3Change the color of the energy gained message.");
			    					sender.sendMessage("/sprint energylostcolor §b<color> §f: §3Change the color of the energy lost message.");
				    	        	return true;
		    	    			}
	    					}
	    				}
	    				if (args[0].equalsIgnoreCase("speed"))
	    				{
	    					if (args.length < 2)
	    					{
	    						sender.sendMessage("§4Usage: §6/sprint speed <amount>");
	    						return true;
	    					}
	    					if (args.length > 0)
	    					{
	    						Sprint.speed = new Double(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("options.speed", new Double(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set sprint speed to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("energygainedpersecond"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint energygainedpersecond <amount>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.energygainedpersecond = new Double(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("options.energy-gained-per-second", new Double(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set energy gained per second to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("energylostpersecond"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint energylostpersecond <amount>");
	    						return false;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.energylostpersecond = new Double(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("options.energy-lost-per-second", new Double(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set energy lost per second to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("highjump"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint highjump <enable|disable>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	if (args[1].equalsIgnoreCase("enable") || args[1].equalsIgnoreCase("on"))
			    	        	{
			    	        		config.setProperty("options.high-jump-enabled", true);
			    	        		Sprint.highjumpenabled = true;
			    	        		sender.sendMessage("Highjump enabled.");
			    	        	}
			    	        	if (args[1].equalsIgnoreCase("disable") || args[1].equalsIgnoreCase("off"))
			    	        	{
			    	        		config.setProperty("options.high-jump-enabled", false);
			    	        		Sprint.highjumpenabled = false;
			    	        		sender.sendMessage("Highjump disabled.");
			    	        	}
			    	        	config.save();
			    	        	return true;
			    			}
						}
						if (args[0].toLowerCase().equalsIgnoreCase("requiresitem"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint requiresitem <enable|disable>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	if (args[1].equalsIgnoreCase("enable") || args[1].equalsIgnoreCase("on"))
			    	        	{
			    	        		config.setProperty("requires-item.enabled", true);
			    	        		Sprint.requiresitem = true;
			    	        		sender.sendMessage("Requires item enabled.");
			    	        	}
			    	        	if (args[1].equalsIgnoreCase("disable") || args[1].equalsIgnoreCase("off"))
			    	        	{
			    	        		config.setProperty("requires-item.enabled", false);
			    	        		Sprint.requiresitem = false;
			    	        		sender.sendMessage("Requires item disabled.");
			    	        	}
			    	        	config.save();
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("requirescommand"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint requirescommand <enable|disable>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	if (args[1].equalsIgnoreCase("enable") || args[1].equalsIgnoreCase("on"))
			    	        	{
			    	        		config.setProperty("options.requires-command-enabled", true);
			    	        		Sprint.requirescommandenabled = true;
			    	        		sender.sendMessage("Requires command enabled.");
			    	        	}
			    	        	if (args[1].equalsIgnoreCase("disable") || args[1].equalsIgnoreCase("off"))
			    	        	{
			    	        		config.setProperty("options.requires-command-enabled", false);
			    	        		Sprint.requirescommandenabled = false;
			    	        		sender.sendMessage("Requires command disabled.");
			    	        	}
			    	        	config.save();
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("helditem"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint helditem <enable|disable>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	if (args[1].equalsIgnoreCase("enable") || args[1].equalsIgnoreCase("on"))
			    	        	{
			    	        		config.setProperty("held-item.enabled", true);
			    	        		Sprint.helditemenabled = true;
			    	        		sender.sendMessage("Held item enabled.");
			    	        	}
			    	        	if (args[1].equalsIgnoreCase("disable") || args[1].equalsIgnoreCase("off"))
			    	        	{
			    	        		config.setProperty("held-item.enabled", false);
			    	        		Sprint.helditemenabled = false;
			    	        		sender.sendMessage("Held item disabled.");
			    	        	}
			    	        	config.save();
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("helditemid"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint helditemid <id>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.helditemid = new Integer(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("held-item.item-id", new Integer(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set held item ID to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("itemid"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint itemid <id>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.itemid = new Integer(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("requires-item.item-id", new Integer(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set item ID to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("messagesinterval"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint messagesinterval <seconds>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.messagesinterval = new Integer(args[1]);
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("messages.interval", new Integer(args[1]));
			    	        	config.save();
			    	        	sender.sendMessage("Set messages interval to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("energygainedcolor"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint energygainedcolor <color>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.energygainedcolor = args[1];
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("messages.energy-gained-color", args[1]);
			    	        	config.save();
			    	        	sender.sendMessage("Set energy gained color to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
						if (args[0].equalsIgnoreCase("energylostcolor"))
						{
			    			if (args.length < 2)
	    					{
			    				sender.sendMessage("§4Usage: §6/sprint energylostcolor <color>");
	    						return true;
	    					}
			    			if (args.length > 0)
			    			{
			    				Sprint.energylostcolor = args[1];
			    	        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
			    	        	config.load();
			    	        	config.setProperty("messages.energy-lost-color", args[1]);
			    	        	config.save();
			    	        	sender.sendMessage("Set energy lost color to: " + args[1] + ".");
			    	        	return true;
			    			}
						}
    	    		}
					else
					{
						sender.sendMessage("§cYou do not have access to that command.");
			    		return true;
					}
    		}
    		return true;
    	}        
        return false;
    }
}

