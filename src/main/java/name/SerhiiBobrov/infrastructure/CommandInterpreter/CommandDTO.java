package name.SerhiiBobrov.infrastructure.CommandInterpreter;

import java.util.Map;

public class CommandDTO {

    public final static String EMPTY_COMMAND = "empty";

    private String commandName;
    private Map<String, String> options;

    CommandDTO(String commandName, Map<String, String> options) {
        this.commandName = commandName;
        this.options = options;
    }

    public String getCommandName() {
        return commandName;
    }

    public Map<String, String> getOptions() {
        return options;
    }
}
