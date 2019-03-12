package name.SerhiiBobrov.infrastructure.CommandInterpreter;

import java.util.Map;

public abstract class Command {
    public abstract String getCommandName();
    public abstract void run(Map<String, String> options);
}
