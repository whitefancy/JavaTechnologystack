package designpattern.decoratorpattern.starbuzz;

public enum Size {
    tall(.1),
    grande(.15),
    venti(.2);
    private final double abbreviation;

    private Size(double abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double getAbbreviation() {
        return abbreviation;
    }
}
