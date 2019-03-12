package name.SerhiiBobrov.application;

import name.SerhiiBobrov.core.benchmark.Report;

class ConsoleReportPresenter implements ReportPresenter {
    public void print(Report report) {
        System.out.println("====== Report ======");
        System.out.println("Memory: " + bytesToMegabytes(report.getMemory()) + " megabytes");
        System.out.println("Time: " + nanoSecondsToSeconds(report.getTime()) + " seconds");
    }
}
