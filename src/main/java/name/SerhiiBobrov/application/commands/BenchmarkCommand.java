package name.SerhiiBobrov.application.commands;

import name.SerhiiBobrov.application.Benchmark;
import name.SerhiiBobrov.infrastructure.CommandInterpreter.Command;

import java.util.Map;

public class BenchmarkCommand extends Command {

    private Benchmark benchmark;

    public BenchmarkCommand(Benchmark benchmarkService) {
        this.benchmark = benchmarkService;
    }

    @Override
    public String getCommandName() {
        return "benchmark";
    }

    @Override
    public void run(Map<String, String> options) {
        benchmark.benchmark();
    }
}
