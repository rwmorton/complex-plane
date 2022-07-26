package math;

import java.awt.Color;

public abstract class ComplexSet
{
    protected int iterations; //number of iterations
    protected int max_iterations = 50;
    protected Color colors[]; //iteration colors
    protected int i;

    protected ComplexSet()
    {
        iterations = 1; //set iterations to 1
        setColorLookup();
    }

    public void setIterations(int i) { iterations = i; }
    public int getIterations() { return iterations; }
    public void setMaxIterations(int i) { max_iterations = i; }
    public int getMaxIterations() { return max_iterations; }
    public abstract boolean iterate(Complex C);

    public Color getColor()
    {
        return colors[i];
    }

    private void setColorLookup()
    {
        colors = new Color[max_iterations];
        double incr = 1.0 / max_iterations;
        for(int i=0; i<max_iterations; i++)
        {
            colors[i] = new Color
            (
                (float)(1.0 - (incr * i)),
                (float)Math.random(),//(float)(Math.cos(incr * i) * 0.25),
                (float)(Math.log1p(incr*i))//(float)(Math.sin(incr * i) * 0.75)
            );
        }
    }
}
