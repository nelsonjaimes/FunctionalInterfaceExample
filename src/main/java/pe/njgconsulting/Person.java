package pe.njgconsulting;

public class Person {
    private String name;
    private double availableAmount;

    public Person(String name, double availableAmount) {
        this.name = name;
        this.availableAmount = availableAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
