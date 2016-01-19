public class Hexagon{
    private int ID; //in 3-4-3 format, ID = 0 top left, 2 top right, 7 bottom left, 9 bottom right
    private int productionNum; //number for production
    private String produce; //item that gets produced
    private int[] numGivePlayers; //number of items to give player -- index 0 = player 1
    //may want 2 arrays, one to keep track of vertex, one to keep track of sides
    public Hexagon(int identity, int prodNum, String prod, int numPlayers) {
	ID = identity;
	productionNum = prodNum;
	produce = prod;
	numGivePlayers = new int[numPlayers];
    }
    
    public Hexagon() {
	this(-1, 0, "", 10);
    }

    public int getID(){
	return ID;
    }

    public int getProductionNum(){
	return productionNum;
    }

    public String getProduce(){
	return produce;
    }

    public int[] getArray(){
	return numGivePlayers;
    }

    public int[] getNumGivePlayers(){
	return getArray();
    }

    //player 1 = index 0
    public void addSettlement(int player) {
	numGivePlayers[player-1] += 1;
    }
    public void addCity(int player) {
	numGivePlayers[player-1] += 2;
    }
}
