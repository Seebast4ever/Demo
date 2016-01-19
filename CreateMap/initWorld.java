import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class initWorld extends JPanel implements ActionListener, MouseListener{
    //removes serial warning
    private static final long serialVersionUID = 123;

    int[][] gridPoint = MakeTiles.pointGrid(51);
    Coordinate[] points = MakeTiles.points(gridPoint, 500, 75);
    Hexagon[] hexes = MakeTiles.makeHexagon(points);

    
    public void paintComponent(Graphics g) {
	System.out.println("painted!");
	g.setColor(Color.BLACK);
	for (int h = 0; h < hexes.length; h++) {
	    for (int l = 0; l < 6; l++) {
		Line line = hexes[h].getLine(l); 
		g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	    }
	}

	for (int i = 0; i < points.length; i++) {
	    //the color scheme needs to be fixed (players need to know whose settlement is whose
	    //may instead use filled rectangles in filled rectangles to indicate cities/settlements

	    /*
	    tests
	    points[i].setSettlement(true);
	    points[i].setCity(true);
	    */
	    
	    //settlement = red rectangle
	    if (points[i].hasSettlement()) {
		g.setColor(Color.RED);
		g.fillRect(points[i].getX()-10, points[i].getY()-10, 20, 20);
	    }
	    //city = blue
	    if (points[i].hasCity()) {
		g.setColor(Color.BLUE);
		g.fillRect(points[i].getX()-10, points[i].getY()-10, 20, 20);
	    }
	}
    }

    //mouse actions
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {
	
    }

    
    //Creates buttons, world, etc.

    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == buy) {
	    System.out.println("pressed buy!");
	    String thingToBuy = (String)buyBox.getSelectedItem();
	    if (thingToBuy.equals("Road")) {
	        buyMessage.setText("You bought a road!");
	    } else if (thingToBuy.equals("Settlement")) {
		buyMessage.setText("You bought a settlement!");
	    } else if (thingToBuy.equals("City")) {
		buyMessage.setText("You bought a city!");
	    } else {
		buyMessage.setText("");
	    }
	}
	if (e.getSource() == endTurn) {
	    //end the player's turn
	}
    }
    
    JButton endTurn = new JButton("End turn?");
    
    String[] choices = {"Road", "Settlement", "City"};
    JComboBox<String> buyBox = new JComboBox<String>(choices);
    JButton buy = new JButton("Buy!");
    JLabel buyMessage = new JLabel();

    public initWorld() {
	buyBox.addActionListener(this);
	buy.addActionListener(this);

	endTurn.addActionListener(this);

	this.add(buyBox, BorderLayout.LINE_START);

	this.add(buy, BorderLayout.CENTER);

	this.add(buyMessage, BorderLayout.LINE_START);

	this.add(endTurn, BorderLayout.LINE_START);
	System.out.println("added buttons!");

	addMouseListener(this);
    }

    
    public static void main(String[]args) {
      	initWorld p = new initWorld();

	JFrame f = new JFrame();
	f.setVisible(true);
	f.setTitle("Play Settlers of Gui!!");
	f.add(p);
	f.setSize(1000, 600);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
