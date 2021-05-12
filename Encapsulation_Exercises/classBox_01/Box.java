package classBox_01;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        dataValidation(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        dataValidation(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        dataValidation(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height) + (2 * this.length * this.width);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    private void dataValidation(double side, String messagePrefix) {
        if(side <= 0) {
            throw new IllegalArgumentException(messagePrefix + " cannot be zero or negative.");
        }
    }
}
