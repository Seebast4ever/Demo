public class Coordinate {
    private int x, y;
    private boolean hasSettlement;
    private boolean hasCity;
	
    public Coordinate() {
	x = 0;
	y = 0;
	hasSettlement = false;
	hasCity = false;
    }

    public Coordinate(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public boolean hasCity() {return hasCity;}
    public boolean hasSettlement() {return hasSettlement;}

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setXY(int x, int y) {this.x = x; this.y = y;}
    public void setSettlement(boolean b) {hasSettlement = b;}
    public void setCity(boolean b) {hasCity = b;}

    public void printCor() {
	System.out.println("["+x+", "+y+"]");
    }
}

