public class Line {
    private Coordinate c1;
    private Coordinate c2;

    public Line(Coordinate c1, Coordinate c2) {
	this.c1 = c1;
	this.c2 = c2;
    }

    public Line(int x1, int y1, int x2, int y2) {
	c1.setXY(x1, y1);
	c2.setXY(x2, y2);		
    }

    public Coordinate getC1() {
	return c1;
    }

    public Coordinate getC2() {
	return c2;
    }

    public int getX1() {return c1.getX();}
    public int getX2() {return c2.getX();}
    public int getY1() {return c1.getY();}
    public int getY2() {return c2.getY();}

    public int getSlope() {
	if (getX1() - getX2() == 0) {
	    return 0;
	} else {
	    return (getY1() - getY2()) / (getX1() - getX2());
	}
    }

    public String seeLine() {
	return "("+getX1()+", "+getY1()+") - ("+getX2()+", "+getY2()+")";
    }
}
