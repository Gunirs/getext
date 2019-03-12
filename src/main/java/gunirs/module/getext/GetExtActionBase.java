package gunirs.module.getext;

import net.eq2online.macros.scripting.ScriptContext;
import net.eq2online.macros.scripting.api.IMacro;
import net.eq2online.macros.scripting.api.IMacroAction;
import net.eq2online.macros.scripting.api.IMacroActionProcessor;
import net.eq2online.macros.scripting.api.IMacroActionStackEntry;
import net.eq2online.macros.scripting.api.IScriptAction;
import net.eq2online.macros.scripting.api.IScriptActionProvider;

public abstract class GetExtActionBase implements IScriptAction
{
    public ScriptContext getContext()
    {
        return ScriptContext.getContext("main");
    }

    public String toString()
    {
        return getName();
    }

    public void onInit()
    {
        getContext().getCore().registerScriptAction(this);
    }

    public boolean isThreadSafe()
    {
        return false;
    }

    public boolean isStackPushOperator()
    {
        return false;
    }

    public boolean isStackPopOperator()
    {
        return false;
    }

    public boolean canBePoppedBy(IScriptAction action)
    {
        return false;
    }

    public boolean executeStackPush(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        return false;
    }

    public boolean executeStackPop(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params, IMacroAction popAction)
    {
        return false;
    }

    public boolean canBreak(IMacroActionProcessor processor, IScriptActionProvider provider, IMacro macro, IMacroAction instance, IMacroAction breakAction)
    {
        return false;
    }

    public boolean isConditionalOperator()
    {
        return false;
    }

    public boolean isConditionalElseOperator(IScriptAction action)
    {
        return false;
    }

    public boolean matchesConditionalOperator(IScriptAction action)
    {
        return false;
    }

    public boolean executeConditional(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params)
    {
        return false;
    }

    public void executeConditionalElse(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params, IMacroActionStackEntry top) {}

    public int onTick(IScriptActionProvider provider)
    {
        return 0;
    }

    public boolean isClocked()
    {
        return true;
    }

    public boolean isPermissable()
    {
        return false;
    }

    public String getPermissionGroup()
    {
        return null;
    }

    public void registerPermissions(String actionName, String actionGroup) {}

    public boolean checkExecutePermission()
    {
        return true;
    }

    public boolean checkPermission(String actionName, String permission)
    {
        return true;
    }

    public void onStopped(IScriptActionProvider provider, IMacro macro, IMacroAction instance) {}

}