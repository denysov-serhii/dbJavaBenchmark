package name.SerhiiBobrov.application.commands;

import name.SerhiiBobrov.infrastructure.CommandInterpreter.Command;
import name.SerhiiBobrov.infrastructure.Creatable;

import java.util.Map;

abstract public class DataPopulateCommand extends Command {

    private final static String COUNT = "count";

    private Creatable service;

    public DataPopulateCommand(Creatable service) {
        this.service = service;
    }

    @Override
    public void run(Map<String, String> options) {
        if (!options.containsKey(COUNT)) {
            throw new RuntimeException("'" + COUNT  + "'" + " option is missed");
        }

        int count;
        try {
            count = Integer.parseInt(options.get(COUNT));
        } catch (NumberFormatException e) {
            throw new RuntimeException(COUNT + " value is not valid, integer expected");
        }

        for (int i = 0; i < count; i++) {
            service.create(createFakeData());
        }
    }

    abstract protected Map<String, String> createFakeData();
}
