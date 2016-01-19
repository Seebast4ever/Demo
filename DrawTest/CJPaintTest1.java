import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CJPaintTest1 extends JComponent {
    
    public static class Line{
	private int x1, y1, x2, y2;
	private Color color;

	public Line(int x1, int y1, int x2, int y2, Color color) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	    this.color = color;
	}
	
    }

    ArrayList<Line> hexTest = new ArrayList<Line>(6);
    
    public void addLine(int x1, int y1, int x2, int y2) {
	hexTest.add(new Line(x1, y1, x2, y2, Color.black));
	repaint();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	for (int i = 0; i < hexTest.size(); i++) {
	    g.setColor(hexTest.get(i).color);
	    g.drawLine(hexTest.get(i).x1, hexTest.get(i).y1,
		       hexTest.get(i).x2, hexTest.get(i).y2);
	}
    }

    //creates a hexagon with vertex 1 at (p1x, p1y) and sides of ratio
    public void addHexagon(int ratio, int p1x, int p1y) {
	int x1 = ratio * 0 + p1x;
	int y1 = ratio * 0 + p1y;

	int x2 = ratio * 0 + p1x;
	int y2 = ratio * 1 + p1y;

	int x3 = ratio * 1 + p1x;
	int y3 = ratio * 2 + p1y;

	int x4 = ratio * 2 + p1x;
	int y4 = ratio * 1 + p1y;

	int x5 = ratio * 2 + p1x;
	int y5 = ratio * 0 + p1y;

	int x6 = ratio * 1 + p1x;
	int y6 = ratio * -1 + p1y;
	
	addLine(x1, y1, x2, y2);
	addLine(x2, y2, x3, y3);
	addLine(x3, y3, x4, y4);
	addLine(x4, y4, x5, y5);
	addLine(x5, y5, x6, y6);
	addLine(x6, y6, x1, y1);
    }

    public static void main(String[]args) {
	JFrame testFrame = new JFrame();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	final CJPaintTest1 comp = new CJPaintTest1();
	comp.setPreferredSize(new Dimension(800, 500));
	testFrame.getContentPane().add(comp, BorderLayout.CENTER);

	//panel for buttons
	JPanel buttonsPanel = new JPanel();
	JButton newLineButton = new JButton("New Line");
	buttonsPanel.add(newLineButton);
	testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	newLineButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    comp.addHexagon(10, 20, 20);
		    comp.addHexagon(100, 250, 250);
		    comp.addLine(0, 0, 100, 0);
		    comp.addLine(0, 100, 0, 0);
		}
	    }
	    
	    );
	testFrame.pack();
	testFrame.setVisible(true);
    }
}

