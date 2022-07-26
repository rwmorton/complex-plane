package math;

public class Complex
{
    public double real; //real part
    public double imag; //imaginary part

    public Complex()
    {
        real = 0.0;
        imag = 0.0;
    }

    public Complex(double real,double imag)
    {
        this.real = real;
        this.imag = imag;
    }

    public Complex(Complex c)
    {
        real = c.real;
        imag = c.imag;
    }

    public final Complex add(Complex c)
    {
        return new Complex(real+c.real,imag+c.imag);
    }

    public final Complex sub(Complex c)
    {
        return new Complex(real-c.real,imag-c.imag);
    }

    public final Complex mul(Complex c)
    {
        return new Complex
        (
            real*c.real - imag*c.imag,
            real*c.imag + c.real*imag
        );
    }

    public final Complex square()
    {
        return new Complex
        (
            real*real - imag*imag,
            2*real*imag
        );
    }

    public final double mod()
    {
        return Math.sqrt(real*real + imag*imag);
    }

    public String toString()
    {
        return new String(Double.toString(real) + ' ' + Double.toString(imag) + 'i');
    }
}
