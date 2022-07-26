package complex_plane;

import math.*;
import ui.ComplexPlaneFrame;

public class Main
{
    public static void main(String[] args)
    {
        ComplexSet complexSet = new Mandlebrot(2.0);
        ComplexPlane complexPlane = new ComplexPlane(1500,1000,complexSet);
        new ComplexPlaneFrame(complexPlane);
    }
}
