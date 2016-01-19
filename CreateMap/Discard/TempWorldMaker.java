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


/*
  Will create only the 10 hexagons in the middle
*/

public class TempWorldMaker extends JComponent{

    //already prepared hex array
    public static Hexagon[] hexArray = MakeTiles.makeHexagon(MakeTiles.points(MakeTiles.pointGrid()));
    public static ArrayList<Line> lineList = new ArrayList<Line>(6);
    
    public void setLineList(Hexagon hex) {
	for (int i = 0; i < hex.getLineList().size(); i++) {
	    lineList.add(hex.getLineList().get(i));
	    repaint();
	}
	lineList.clear();
    }

    public void printArrayList(ArrayList ary) {
	String printtt = "[";
	for (int i = 0; i < ary.size(); i++) {
	    printtt += ary.get(i)+", ";
	}
	System.out.println(printtt+"]");
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	for (int i = 0; i < lineList.size(); i++) {
	    Line lines = lineList.get(i);
	    g.setColor(Color.black);
	    g.drawLine(lines.getC1().getX(), lines.getC1().getY(), lines.getC2().getX(), lines.getC2().getY());
	}
    }

    
    public static void main(String[]args) {
	JFrame testFrame = new JFrame();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	final TempWorldMaker comp = new TempWorldMaker();
	comp.setPreferredSize(new Dimension(800, 500));
	testFrame.getContentPane().add(comp, BorderLayout.CENTER);

	//panel for buttons
	JPanel buttonsPanel = new JPanel();
	JButton newLineButton = new JButton("Create!");
	buttonsPanel.add(newLineButton);
	testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	newLineButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    for (int i = 0; i < hexArray.length; i++) {
			comp.addHexagon(10, 20, 20);
			comp.addHexagon(100, 250, 250);
			comp.addLine(0, 0, 100, 0);
			comp.addLine(0, 100, 0, 0);
			
			comp.setLineList(hexArray[i]);
		    }
		}
	    }
	    
	    );
	testFrame.pack();
	testFrame.setVisible(true);
    }
    public void addLine(int x1, int y1, int x2, int y2) {
	lineList.add(new Line(x1, y1, x2, y2));
	repaint();
    }
    
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
}
