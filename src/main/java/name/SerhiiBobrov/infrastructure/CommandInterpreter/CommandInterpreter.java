package name.SerhiiBobrov.infrastructure.CommandInterpreter;

import java.util.HashMap;
import java.util.Map;

public class CommandInterpreter {

    private Map<String, Command> map = new HashMap<>();

    public CommandInterpreter(Command[] commands) {
        for (Command command: commands) {
            map.put(command.getCommandName(), command);
        }
    }

    public void run(CommandDTO commandDTO) {
        if (!map.containsKey(commandDTO.getCommandName())) {
            throw new RuntimeException("Command not found");
        }

        map.get(commandDTO.getCommandName()).run(commandDTO.getOptions());
    }
}
