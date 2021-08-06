package part2.common;

public class Log {
    static double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }

    static double baseTowLog(double x) {
        return Math.log10(x) / Math.log10(2);
    }

}
