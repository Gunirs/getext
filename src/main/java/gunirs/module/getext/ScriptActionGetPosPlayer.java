package gunirs.module.getext;

import net.eq2online.macros.scripting.ScriptCore;
import net.eq2online.macros.scripting.api.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

@APIVersion(16)
public class ScriptActionGetPosPlayer extends GetExtActionBase
{
    public String getName()
    {
        return "getposplayer";
    }

    public boolean canExecuteNow(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        return true;
    }

    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        if(params.length > 1)
        {
            String playerName = ScriptCore.parseVars(provider, macro, params[0], false);
            EntityPlayer player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(playerName);
            EntityPlayer player1 = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(Minecraft.getMinecraft().thePlayer.getGameProfile().getName());

            if (player != null)
            {
                ScriptCore.setVariable(provider, macro, params[1], String.valueOf(player.lastTickPosX));
                if (params.length > 2)
                    ScriptCore.setVariable(provider, macro, params[2], String.valueOf(player.lastTickPosY));
                if (params.length > 3)
                    ScriptCore.setVariable(provider, macro, params[3], String.valueOf(player.lastTickPosZ));
                if (params.length > 4)
                    ScriptCore.setVariable(provider, macro, params[4], String.valueOf(player.getDistanceToEntity(player1)));
                if (params.length > 5)
                    ScriptCore.setVariable(provider, macro, params[5], String.valueOf(player.cameraPitch));
                if (params.length > 6)
                    ScriptCore.setVariable(provider, macro, params[6], String.valueOf(player.cameraYaw));
            }
        }

        return new ReturnValue(true);
    }
}