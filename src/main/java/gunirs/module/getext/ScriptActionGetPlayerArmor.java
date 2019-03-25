package gunirs.module.getext;

import cpw.mods.fml.common.registry.GameRegistry;
import net.eq2online.macros.scripting.ScriptCore;
import net.eq2online.macros.scripting.api.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

@APIVersion(16)
public class ScriptActionGetPlayerArmor extends GetExtActionBase
{
    public String getName()
    {
        return "getplayerarmor";
    }

    public boolean canExecuteNow(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        return true;
    }

    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        if(params.length > 0)
        {
            String playerName = ScriptCore.parseVars(provider, macro, params[0], false);
            EntityPlayer player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(playerName);

            if (player != null)
            {
                if (params.length > 1 && player.inventory.armorItemInSlot(3) != null)
                {
                    GameRegistry.UniqueIdentifier item = GameRegistry.findUniqueIdentifierFor(player.inventory.armorItemInSlot(3).getItem());
                    ScriptCore.setVariable(provider, macro, params[1], item.modId + ":" + item.name);
                }
                if (params.length > 2 && player.inventory.armorItemInSlot(2) != null)
                {
                    GameRegistry.UniqueIdentifier item = GameRegistry.findUniqueIdentifierFor(player.inventory.armorItemInSlot(2).getItem());
                    ScriptCore.setVariable(provider, macro, params[2], item.modId + ":" + item.name);
                }
                if (params.length > 3 && player.inventory.armorItemInSlot(1) != null)
                {
                    GameRegistry.UniqueIdentifier item = GameRegistry.findUniqueIdentifierFor(player.inventory.armorItemInSlot(1).getItem());
                    ScriptCore.setVariable(provider, macro, params[3], item.modId + ":" + item.name);
                }
                if (params.length > 4 && player.inventory.armorItemInSlot(0) != null)
                {
                    GameRegistry.UniqueIdentifier item = GameRegistry.findUniqueIdentifierFor(player.inventory.armorItemInSlot(0).getItem());
                    ScriptCore.setVariable(provider, macro, params[4], item.modId + ":" + item.name);
                }
            }
        }
        return null;
    }
}
