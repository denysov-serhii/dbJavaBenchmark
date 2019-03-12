package name.SerhiiBobrov.application.commands;

import name.SerhiiBobrov.infrastructure.CommandInterpreter.Command;
import name.SerhiiBobrov.infrastructure.CommandInterpreter.CommandDTO;

import java.util.Map;

public class EmptyCommand extends Command {
    @Override
    public String getCommandName() {
        return CommandDTO.EMPTY_COMMAND;
    }

    @Override
    public void run(Map<String, String> options) {
        System.out.println("There were no any command");
    }
}
