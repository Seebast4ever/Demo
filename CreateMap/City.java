import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class City extends JPanel {
    Coordinate[] points = new Coordinate[6];
    ArrayList<Line> Lines = new ArrayList<Line>(6);
    JFrame f;
    
    Coordinate cor;

    public City() {
	setSize(new Dimension(1000, 600));
	setPreferredSize(new Dimension(1000, 600));
	cor = new Coordinate(50, 50);
    }
    
    //Creates a hexagon around the selected coordinate
    public City(Coordinate cor) {
	this.cor = cor;
	points[0] = new Coordinate(cor.getX() - 10, cor.getY() - 10);
	points[1] = new Coordinate(cor.getX() - 10, cor.getY() + 10);
	points[2] = new Coordinate(cor.getX(), cor.getY() + 20);
	points[3] = new Coordinate(cor.getX() + 10, cor.getY() + 10);
	points[4] = new Coordinate(cor.getX() + 10, cor.getY() - 10);
	points[5] = new Coordinate(cor.getX(), cor.getY() - 20);
    }

    public City(int x, int y) {
	this(new Coordinate(x, y));
    }

    public void paint(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(cor.getX()-5, cor.getY()-5, 10, 10);
    }
    
    public static void main(String[]args) {
	City p = new City();
	
	JFrame f = new JFrame();
	f.setTitle("Testing city-maker");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(1000, 600);
	f.setVisible(true);

	JButton b = new JButton("Create a city at 50,50");
	
	p.add(b);
	f.add(p, BorderLayout.EAST);

	final City c = new City(50, 50);
	/*
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    c.paint();
		}
	
		} );*/
    }
	    

}
