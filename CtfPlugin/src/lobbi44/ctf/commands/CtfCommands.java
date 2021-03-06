package lobbi44.ctf.commands;


import lobbi44.ctf.CtfPlugin;
import lobbi44.ctf.statelogic.InitPeriod;
import lobbi44.ctf.statemachine.IStateCom;
import lobbi44.ctf.statemachine.StateInstantiationException;
import lobbi44.kt.command.CommandEvent;
import lobbi44.kt.command.annotations.Command;

/**
 * @author lobbi44
 */
public class CtfCommands {

    private CtfPlugin plugin;
    private IStateCom stateCom;

    public CtfCommands(CtfPlugin plugin, IStateCom stateCom) {
        this.plugin = plugin;
        this.stateCom = stateCom;
    }

    @Command(name = "ctf.start", description = "Starts the capture the flag game")
    public boolean startGame(CommandEvent args) {
        try {
            stateCom.setActive(InitPeriod.class);
            return true;
        } catch (StateInstantiationException e) {
            e.printStackTrace();
        }
        return false;
    }
}
