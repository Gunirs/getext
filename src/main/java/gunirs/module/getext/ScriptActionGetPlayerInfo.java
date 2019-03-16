package gunirs.module.getext;

import net.eq2online.macros.scripting.ScriptCore;
import net.eq2online.macros.scripting.api.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Arrays;

@APIVersion(16)
public class ScriptActionGetPlayerInfo extends GetExtActionBase
{
    public String getName()
    {
        return "getplayerinfo";
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
                if (params.length > 1)
                    ScriptCore.setVariable(provider, macro, params[1], String.valueOf(player.getHealth()));
                if (params.length > 2)
                    ScriptCore.setVariable(provider, macro, params[2], String.valueOf(player.getFoodStats().getFoodLevel()));
                if (params.length > 3)
                    ScriptCore.setVariable(provider, macro, params[3], String.valueOf(player.getAir()));
                if (params.length > 4)
                    ScriptCore.setVariable(provider, macro, params[4], String.valueOf(player.isBurning()));
                if (params.length > 5)
                    ScriptCore.setVariable(provider, macro, params[5], String.valueOf(player.getArmorVisibility()));
            }
        }
        return null;
    }
}