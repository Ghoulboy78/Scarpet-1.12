package carpet.script;

import carpet.script.value.Value;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.BlockPos;

public class CarpetContext extends Context
{
    public ICommandSender s;
    public final BlockPos origin;
    public CarpetContext(ScriptHost host, ICommandSender source, BlockPos origin)
    {
        super(host);
        s = source;
        this.origin = origin;
    }

    @Override
    public Context duplicate()
    {
        return new CarpetContext(this.host, this.s, this.origin);
    }

    @Override
    protected void initialize()
    {
        super.initialize();
        variables.put("_x", (c, t) -> Value.ZERO);
        variables.put("_y", (c, t) -> Value.ZERO);
        variables.put("_z", (c, t) -> Value.ZERO);
    }
}
