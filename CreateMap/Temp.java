import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Temp extends JPanel {

    ArrayList<Line> hexTest = new ArrayList<Line>(6);
    
    int[][] gridPoint = MakeTiles.pointGrid(51);
    Coordinate[] points = MakeTiles.points(gridPoint, 100, 50);
    Hexagon[] hexes = MakeTiles.makeHexagon(points);

    public void addHexagon() { addHexagon(hexes); }
    
    public void addHexagon(Hexagon[] hexes) {
	//loops through hexagons
        for (int i = 0; i < hexes.length; i++) {
	    //loops through each line in a hexagon
	    for (int j = 0; j < hexes[i].getLineListLength(); j++) {
		addLine(hexes[i].getLine(j));
	    }
	}
    }
    
    public void addLine(Line L) {
	hexTest.add(L);
	repaint();
    }

    public void paintComponent(Graphics g, ArrayList<Line> lines) {
	super.paintComponent(g);
	//loops through an arrayList of lines
	for (int i = 0; i < lines.size(); i++) {
	    g.setColor(Color.black);
	    g.drawLine(lines.get(i).getX1(), lines.get(i).getY1(),
		       lines.get(i).getX2(), lines.get(i).getY2());
	}
    }

    public void paintComponent(Graphics g) {
	paintComponent(g, hexTest);
    }

    public void printHexCoordinates(Hexagon hex) {
	Line line0 = hex.getLine(0);
	Line line1 = hex.getLine(1);
	Line line2 = hex.getLine(2);
	Line line3 = hex.getLine(3);
	Line line4 = hex.getLine(4);
	Line line5 = hex.getLine(5);

	Coordinate C0 = line0.getC1();
	Coordinate C1 = line1.getC1();
	Coordinate C2 = line2.getC1();
	Coordinate C3 = line3.getC1();
	Coordinate C4 = line4.getC1();
	Coordinate C5 = line5.getC1();

	C0.printCor();
	C1.printCor();
	C2.printCor();
	C3.printCor();
	C4.printCor();
	C5.printCor();
    }
    
    public static void main(String[]args) {
	JFrame f = new JFrame();
	f.setTitle("Making a hexagonal grid!!");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(1000, 600);
	f.setVisible(true);
	
	final Temp p = new Temp();
	
	
	//panel for buttons
	JButton makeHex = new JButton("makeHexes");
	makeHex.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    //adds a city at a point
		    //City c = new City(comp.points[1]);
      		    //c.paint();
       		    p.addHexagon();
		}
	    }
	    
	    );
	
	p.add(makeHex);
	f.add(p);
	//comp.putHexNumbers(buttonsPanel, comp);
    }
}

