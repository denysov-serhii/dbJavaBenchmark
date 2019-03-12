package name.SerhiiBobrov.application;

import name.SerhiiBobrov.application.commands.BenchmarkCommand;
import name.SerhiiBobrov.application.commands.EmptyCommand;
import name.SerhiiBobrov.application.commands.UserPointPopulateCommand;
import name.SerhiiBobrov.core.benchmark.BenchmarkService;
import name.SerhiiBobrov.core.userPoint.UserPointDbMapper;
import name.SerhiiBobrov.core.userPoint.UserPointFactory;
import name.SerhiiBobrov.core.userPoint.UserPointService;
import name.SerhiiBobrov.infrastructure.CommandInterpreter.Command;
import name.SerhiiBobrov.infrastructure.CommandInterpreter.CommandDTOFactory;
import name.SerhiiBobrov.infrastructure.CommandInterpreter.CommandInterpreter;
import name.SerhiiBobrov.infrastructure.Db.DbClient;
import name.SerhiiBobrov.infrastructure.Db.FileDbConfiguration;

public class Application {
    public static void main(String[] args) {
        DbClient dbClient = new DbClient(new FileDbConfiguration("db.properties"));
        UserPointDbMapper userPointDbMapper = new UserPointDbMapper(dbClient, new UserPointFactory());
        UserPointService userPointService = new UserPointService(userPointDbMapper);

        Benchmark benchmark = new Benchmark(new BenchmarkService(userPointService), new ConsoleReportPresenter());

        Command[] commands = new Command[] {
                new UserPointPopulateCommand(userPointService),
                new BenchmarkCommand(benchmark),
                new EmptyCommand()
        };

        new CommandInterpreter(commands).run(
                new CommandDTOFactory().create(args)
        );
    }
}
