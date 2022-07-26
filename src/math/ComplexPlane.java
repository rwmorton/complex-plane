package math;

import java.awt.Image;
import java.awt.image.BufferedImage;

//
//map drawing surface to complex plane
//drawing surface origin is at top left corner
//100 pixels represents 1 unit and vice-versa
//
public class ComplexPlane
{
    private int width;
    private int height;
    private Complex complexPlane[]; //each pixel represents a complex number
    private ComplexSet complexSet; //the complex set to calculate

    public ComplexPlane(int width,int height,ComplexSet complexSet)
    {
        //check image size - keep to powers of two
        if(width % 2 != 0) this.width = width + 1;
        else this.width = width;
        if(height % 2 != 0) this.height = height + 1;
        else this.height = height;

        this.complexSet = complexSet;

        //quick hacks
        double scale = 0.00225; //0.005;
        double shift = 300.0;

        //fill complex plane
        complexPlane = new Complex[this.width*this.height];
        double x,y;
        int half_width = this.width / 2;
        int half_height = this.height / 2;
        for(int h=0; h<this.height; h++)
        {
            for(int w=0; w<this.width; w++)
            {
                if(w < half_width) x = w - half_width;
                else x = (w + 1) - half_width;

                if(h < half_height) y = half_height - h;
                else y = half_height - (h + 1);

                //quick hack
                x -= shift;
                x *= scale; //post scale
                y *= scale;

                complexPlane[(h * width) + w] = new Complex(x,y);
            }
        }
    }

    public int getWidth() { return width; }
    public void setWidth(int w) { width = w; }
    public int getHeight() { return height; }
    public void setHeight(int h) { height = h; }

    public Image compute()
    {
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int h=0; h<height; h++)
        {
            for(int w=0; w<width; w++)
            {
                if(complexSet.iterate(complexPlane[(h * width) + w]))
                {
                    image.setRGB(w,h,0);
                }
                else
                {
                    //image.setRGB(w,h,Integer.MAX_VALUE);
                    image.setRGB(w,h,complexSet.getColor().getRGB());
                }
            }
        }
        return image;
    }

    public Complex[] getComplexPlane() { return complexPlane; }
    public int getComplexPlaneSize() { return width*height; }
    public ComplexSet getComplexSet() { return complexSet; }
    public void setComplexSet(ComplexSet complexSet) { this.complexSet = complexSet; }
}
