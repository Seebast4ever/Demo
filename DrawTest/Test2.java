import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
  1. Create line object that holds starting, ending, and color
  2. Create a container that holds all lines (use arrayList Lines)
  3. In AddLine put one more line in the arrayList, and repaint
    3a. in repaint, call paintComponent (overridden) that loops through linked list and creates each one

notes: can use arrayList size 6, make a class hexagon with arrayList, 
arrayList of hexagons????
*/


public class Test2 extends JComponent{

    
    //creates a Line class
    //has starting point, ending point, and a color.
    private static class Line{
	final int x1; 
	final int y1;
	final int x2;
	final int y2;   
	final Color color;

	public Line(int x1, int y1, int x2, int y2, Color color) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	    this.color = color;
	}               
    }

    //A linked list of lines
    private final LinkedList<Line> lines = new LinkedList<Line>();

    //repaints
    public void addLine(int x1, int x2, int x3, int x4) {
	addLine(x1, x2, x3, x4, Color.black);
    }

    //calls repaint
    public void addLine(int x1, int x2, int x3, int x4, Color color) {
       	lines.add(new Line(x1,x2,x3,x4, color));        
	repaint();
    }

    public void clearLines() {
       	lines.clear();
	repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	for (Line line : lines) {
	    g.setColor(line.color);
	    g.drawLine(line.x1, line.y1, line.x2, line.y2);
	}
    }

    public static void main(String[] args) {
	JFrame testFrame = new JFrame();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	final Test2 comp = new Test2();
	comp.setPreferredSize(new Dimension(320, 200));
	testFrame.getContentPane().add(comp, BorderLayout.CENTER);
	JPanel buttonsPanel = new JPanel();
	JButton newLineButton = new JButton("New Line");
	JButton clearButton = new JButton("Clear");
	buttonsPanel.add(newLineButton);
	buttonsPanel.add(clearButton);
	testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	newLineButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    int x1 = (int) (Math.random()*320);
		    int x2 = (int) (Math.random()*320);
		    int y1 = (int) (Math.random()*200);
		    int y2 = (int) (Math.random()*200);
		    Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
		    comp.addLine(x1, y1, x2, y2, randomColor);
		}
	    });
	clearButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    comp.clearLines();
		}
	    });
	testFrame.pack();
	testFrame.setVisible(true);
    }

}
