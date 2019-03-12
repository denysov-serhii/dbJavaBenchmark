package name.SerhiiBobrov.core.benchmark;

import name.SerhiiBobrov.infrastructure.Loadable;

public class BenchmarkService {

    private Loadable service;
    private Runtime runtime = Runtime.getRuntime();

    public BenchmarkService(Loadable service) {
        this.service = service;
    }

    public Report makeMeasure() {

        Report report = new Report();
        double currentUsageMemory = runtime.totalMemory();
        long startTime = System.nanoTime();

        service.loadAll();

        report.setMemory(runtime.totalMemory() - currentUsageMemory);
        report.setTime(System.nanoTime() - startTime);

        return report;
    }
}
