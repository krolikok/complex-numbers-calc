public class ComplexNumber {

    private double real,
            imag,
            magn,
            arg;


    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imag = imaginary;
        this.arg = calcArg();
        this.magn = calcMagnitude();
    }

    // Statyczne metody
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }

    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real + b.real, a.imag + b.imag);
    }

    public static ComplexNumber substract(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real - b.real, a.imag - b.imag);
    }

    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        // TODO: 24.03.18 Dodac obsluge bledu kiedy mianownik == 0
        double common_fraction = (Math.pow(b.real, 2) + Math.pow(b.imag, 2));
        return new ComplexNumber((a.real * b.real + a.imag * b.imag) / common_fraction, (a.imag * b.real - a.real * b.imag) / common_fraction);
    }

    public static ComplexNumber pow(ComplexNumber a, ComplexNumber b) {
        //
        double p = b.real;
        double arg_prim = a.arg * p;
        double mag_prim = Math.pow(a.magn, p);
        return new ComplexNumber(mag_prim * Math.cos(arg_prim), mag_prim * Math.sin(arg_prim));
    }

    private double calcArg() {
        return Math.atan2(this.imag, this.real);
    }

    private double calcMagnitude() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public double getArg() {
        return this.arg;
    }

    public double getMagnitude() {
        return this.magn;
    }

    // todo javie nie ma mozliwosci przeladowania operatorow takze mozna stworzyc dodatkowo metody .Add, .multiply,...


}
//
//    /** Compute the magnitude of a complex number */
//    public double magnitude() {
//        return Math.sqrt(x * x + y * y);
//    }
//
//    /**
//     * This method converts a ComplexNumber to a string. This is a method of
//     * Object that we override so that complex numbers can be meaningfully
//     * converted to strings, and so they can conveniently be printed out with
//     * System.out.println() and related methods
//     */
//    public String toString() {
//        return "{" + x + "," + y + "}";
//    }
//
//    /**
//     * This is a static class method. It takes two complex numbers, adds them, and
//     * returns the result as a third number. Because it is static, there is no
//     * "current instance" or "this" object. Use it like this: ComplexNumber c =
//     * ComplexNumber.add(a, b);
//     */
//    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
//        return new ComplexNumber(a.x + b.x, a.y + b.y);
//    }
//
//    /**
//     * This is a non-static instance method by the same name. It adds the
//     * specified complex number to the current complex number. Use it like this:
//     * ComplexNumber c = a.add(b);
//     */
//    public ComplexNumber add(ComplexNumber a) {
//        return new ComplexNumber(this.x + a.x, this.y + a.y);
//    }
//
//    /** A static class method to multiply complex numbers */
//    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
//        return new ComplexNumber(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
//    }
//
//    /** An instance method to multiply complex numbers */
//    public ComplexNumber multiply(ComplexNumber a) {
//        return new ComplexNumber(x * a.x - y * a.y, x * a.y + y * a.x);
//    }
