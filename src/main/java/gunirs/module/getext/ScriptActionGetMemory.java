package gunirs.module.getext;

import net.eq2online.macros.scripting.ScriptCore;
import net.eq2online.macros.scripting.api.*;

@APIVersion(16)
public class ScriptActionGetMemory extends GetExtActionBase
{
    public String getName()
    {
        return "getmemory";
    }

    public boolean canExecuteNow(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        return true;
    }

    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        if (params.length == 2)
        {
            String command = ScriptCore.parseVars(provider, macro, params[0], false);

            switch (command)
            {
                case "max":
                    ScriptCore.setVariable(provider, macro, params[1], String.valueOf(Runtime.getRuntime().maxMemory()));
                    break;
                case "total":
                    ScriptCore.setVariable(provider, macro, params[1], String.valueOf(Runtime.getRuntime().totalMemory()));
                    break;
                case "free":
                    ScriptCore.setVariable(provider, macro, params[1], String.valueOf(Runtime.getRuntime().freeMemory()));
                    break;
                case "used":
                    ScriptCore.setVariable(provider, macro, params[1], String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
                    break;
            }
        }
        return null;
    }
}