import java.util.ArrayList;

public class Hexagon {
    private ArrayList<Line> lineList;

    public Hexagon(ArrayList<Line> lineList) {
	this.lineList = lineList;
    }
    
    public Hexagon(Line L1, Line L2, Line L3, Line L4, Line L5, Line L6) {
	lineList = new ArrayList<Line>(6);
	lineList.add(L1);
	lineList.add(L2);
	lineList.add(L3);
	lineList.add(L4);
	lineList.add(L5);
	lineList.add(L6);
    }

    public Hexagon(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4, Coordinate c5, Coordinate c6) {
	this(new Line(c1, c2), new Line(c2, c3), new Line(c3, c4),
	     new Line(c4, c5), new Line(c5, c6), new Line(c6, c1));
    }

    public Hexagon(int x1, int y1, int x2, int y2, int x3, int y3,
		   int x4, int y4, int x5, int y5, int x6, int y6) {
	this(new Coordinate(x1, y1), new Coordinate(x2, y2), new Coordinate(x3, y3), new Coordinate(x4, y4), new Coordinate(x5, y5), new Coordinate(x6, y6));
    }

    public ArrayList<Line> getLineList() {
	return lineList;
    }

    public Line getLine(int i) {
	return lineList.get(i);
    }

    public int getLineListLength() {
	return lineList.size();
    }


    //Helps get each hex's production number
    public Coordinate getMiddleCoordinate() {
	int sumx = 0;
	int sumy = 0;
	for (int i = 0; i < lineList.size(); i++) {
	    sumx += lineList.get(i).getX1();
	    sumy += lineList.get(i).getY1();
	}
	return new Coordinate(sumx/6, sumy/6);
    }

    public int getMiddleX() {
	int sumx = 0;
	for (int i = 0; i < lineList.size(); i++) {
	    sumx += lineList.get(i).getX1();
	}
	return sumx/6;
    }

    public int getMiddleY() {
	int sumy = 0;
	for (int i = 0; i < lineList.size(); i++) {
	    sumy += lineList.get(i).getY1();
	}
	return sumy/6;
    }
}


