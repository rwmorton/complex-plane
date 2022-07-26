package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import math.ComplexPlane;

public class ComplexPlanePanel extends JPanel implements ChangeListener
{
    private ComplexPlane complexPlane;
    private JSlider iterations;

    public ComplexPlanePanel(ComplexPlane complexPlane)
    {
        this.complexPlane = complexPlane;
        this.setSize(complexPlane.getWidth(),complexPlane.getHeight());

        iterations = new JSlider();
        iterations.setMinimum(1);
        iterations.setMaximum(complexPlane.getComplexSet().getMaxIterations());
        iterations.setValue(1);
        iterations.setMajorTickSpacing(5);
        iterations.setPaintTicks(true);
        iterations.setPaintLabels(true);
        iterations.addChangeListener(this);
        this.add(iterations);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image image = complexPlane.compute();
        g.drawImage(image,0,0,complexPlane.getWidth(),complexPlane.getHeight(),null);
    }

    public void stateChanged(ChangeEvent changeEvent)
    {
        int iters = iterations.getValue();
        complexPlane.getComplexSet().setIterations(iters);
        this.repaint();
    }
}
