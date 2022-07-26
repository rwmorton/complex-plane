package ui;

import javax.swing.JFrame;

import math.*;

public class ComplexPlaneFrame extends JFrame
{
    public ComplexPlaneFrame(ComplexPlane complexPlane)
    {
        ComplexPlanePanel complexPlanePanel = new ComplexPlanePanel(complexPlane);
        this.getContentPane().add(complexPlanePanel);
        this.setSize(complexPlane.getWidth(),complexPlane.getHeight());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
