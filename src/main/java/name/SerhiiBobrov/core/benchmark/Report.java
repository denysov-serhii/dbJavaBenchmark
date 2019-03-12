package name.SerhiiBobrov.core.benchmark;

public class Report {
    private double memory;
    private double time;

    Report(double memory, double time) {
        this.memory = memory;
        this.time = time;
    }

    Report(){}

    public double getMemory() {
        return memory;
    }

    public double getTime() {
        return time;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
