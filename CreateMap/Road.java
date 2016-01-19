public class Road {
    //essentially a rectangle that's a line, with added thickness
    Coordinate c1, c2, c3, c4;

    //offset indicates half of rectangle's thickness
    public Road(Line l, int offset) {
	setCor(l, offset);
    }

    public Road(Line l) {
	setCor(l, 2);
    }

    public void setCor(Line l, int offset) {
	int x1 = l.getX1();
	int y1 = l.getY1();
	int x2 = l.getX2();
	int y2 = l.getY2();
	//if road is a vertical line: |
	if (l.getSlope() == 0) {
	    c1.setXY(x1 - offset, y1);
	    c2.setXY(x1 + offset, y1);
	    c3.setXY(x2 + offset, y2);
	    c4.setXY(x2 - offset, y2);
	    //if road is diagonal: /
	} else if (l.getSlope() == 1) {
	    c1.setXY(x1 - offset, y1 + offset);
	    c2.setXY(x1 + offset, y1 - offset);
	    c3.setXY(x2 + offset, y2 - offset);
	    c4.setXY(x2 - offset, y2 + offset);
	    //if road is diagonal: \
	} else if (l.getSlope() == -1) {
	    c1.setXY(x1 - offset, y1 - offset);
	    c2.setXY(x1 + offset, y1 + offset);
	    c3.setXY(x2 + offset, y2 + offset);
	    c4.setXY(x2 - offset, y2 - offset);
	}
    }
}
