package math;

//
//mandlebrot function - f(Z) = Z^2 + C
//
public class Mandlebrot extends ComplexSet
{
    private double bound; //escape bound

    public Mandlebrot(double bound)
    {
        this.bound = bound; //set escape bound
    }

    public boolean iterate(Complex C)
    {
        Complex Z = new Complex(C); //Z starts as 0 + 0i - so just set to C (starting constant)
        i = 0; //reset iterations

        while(i < iterations)
        {
            if(Z.mod() > bound)
            {
                return false; //escaped the set
            }

            //compute the mandlebrot function for the ith pass
            Z = new Complex(Z.square().add(C));

            i++; //move to next iteration
        }

        return true; //did not escape the set
    }
}
