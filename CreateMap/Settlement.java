public class Settlement {
    private Coordinate[] points = new Coordinate[5];
    
    public Settlement(int initx, int inity) {
	points = makePentagon(initx, inity);
    }

    public Coordinate[] makePentagon(int initx, int inity) {
	Coordinate[] points = new Coordinate[5];
	points[0].setXY(initx, inity);
	points[1].setXY(initx+2, inity);
	points[2].setXY(initx+2, inity+2);
	points[3].setXY(initx+1, inity+3);
	points[4].setXY(initx, inity+2);
	return points;
    }

    
}
