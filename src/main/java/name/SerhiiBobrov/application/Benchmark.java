package name.SerhiiBobrov.application;

import name.SerhiiBobrov.core.benchmark.BenchmarkService;

public class Benchmark {

    private BenchmarkService benchmarkService;
    private ReportPresenter reportPresenter;

    public Benchmark(BenchmarkService benchmarkService, ReportPresenter reportPresenter) {
        this.benchmarkService = benchmarkService;
        this.reportPresenter = reportPresenter;
    }

    public void benchmark() {
        reportPresenter.print(
                benchmarkService.makeMeasure()
        );
    }
}
