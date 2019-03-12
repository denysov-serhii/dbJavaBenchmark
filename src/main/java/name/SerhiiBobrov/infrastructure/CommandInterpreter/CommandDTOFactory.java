package name.SerhiiBobrov.infrastructure.CommandInterpreter;

import java.util.HashMap;

public class CommandDTOFactory {

    public CommandDTO create(String[] args) {
        HashMap<String, String> options = new HashMap<>();
        if (args.length == 0) {
            return new CommandDTO(CommandDTO.EMPTY_COMMAND, options);
        }

        String commandName = args[0];

        for(int i = 1; i < args.length; i++) {

            if (!isOption(args[i])) {
                throw new RuntimeException("Options are not valid");
            }

            String optionName = args[i], value = "";

            if ( existArgument(args, i + 1) && isValue(args[i + 1])) {
                value = args[i++];
            }

            options.put(optionName, value);
        }

        return new CommandDTO(commandName, options);
    }

    private boolean existArgument(String[] args, int index) {
        return index < args.length;
    }

    private boolean isOption(String string) {
        return string.contains("--");
    }

    private boolean isValue(String string) {
        return !isOption(string);
    }
}
