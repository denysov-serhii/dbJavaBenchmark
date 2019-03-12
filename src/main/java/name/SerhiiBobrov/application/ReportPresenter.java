package name.SerhiiBobrov.application;

import name.SerhiiBobrov.core.benchmark.Report;

public interface ReportPresenter {
    void print(Report report);

    default double bytesToMegabytes(double bytes) {
        return bytes / 1024 / 1024;
    }

    default double nanoSecondsToSeconds(double nanoSeconds) {
        return nanoSeconds / 1000000000;
    }
}
