import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Graph {
	
	//This where variables are declared. 
	private static  int V = 0;
	private int level;
	static HeadNode adjarray[];
	
	//The graph function starts. How this structured is an array list with nodes inside the array list. 
	public Graph(int V){
		this.V = V;
	//This where I assign array to be of nodes. 
		adjarray = new HeadNode[V];
	//This is to set the node at the every point in the arrray. 
		for(int i =0; i<V; ++i){
			adjarray[i] = new HeadNode();
			adjarray[i].Head = null; 
		}
	}
	
	//To add edges it takes most of same values that the node takes. The values are taken in and the assign. 
	public void addEdge(int level,int[][] source, int[][] destination, int fcost, int cCost, ArrayList<int[][]> cpath, String direc ){
		this.level = level;
		Node adn = new Node(level,source, destination,fcost,cCost,cpath,direc);
		
		
		//Added for directed graph 1
		adn.next = adjarray[level].Head;	
		adjarray[level].Head = adn;
	}
	//Made to return the space the graph. 
	public static int V(){
		return V;
	}
	//Made to return the level of the node. 
	public int level(){
		return level;
	}
	//This were it graph the solution of the current node and it's able to print it out. 
	public static void printSol(ArrayList sol){
		boolean flagan = false;
		for(Object i: sol){
		for(int n = 0; n < V(); n++){
			if(Arrays.deepEquals(adjarray[n].Head.source,(Object[]) i)){
				PuzzleCreator.CreatePuzzle(adjarray[n].Head.source);
				System.out.println("Current cost: "+adjarray[n].Head.currentCost);
				System.out.println("Total cost: "+adjarray[n].Head.cost);
				System.out.println("Direction: "+ adjarray[n].Head.dir);
				break;
				
				
		}
		}
		}
	}
	//This is a function to print out the structure of the graph. 
	public void print(Graph DG){
		int vertex = V;
		Node ND;
		
		int count;
		
		for(int i = 0; i < vertex; i++){
			ND = DG.adjarray[i].Head;
			
			if(ND != null){
				System.out.print("\nNodes connected to Vertex " + Arrays.deepToString(ND.source) + " are : \n");
				count = 0;
				while(ND != null){
					//count = count + ND.destination;
					System.out.println(" "+Arrays.deepToString(ND.destination)+"( "+ND.cost+" )");
					ND = ND.next;
				}
			} 
		}  
	} 
	
	//Made for testing ........ Node is after this section. ............

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] squares= {
				{1,2,0},
				{4,5,6},
				{7,8,3}
		};
		int[][] dest = {
				{10,20,00},
				{40,56,6},
				{70,56,98}
		};
		int[][] source ={
				{111,222,330},
				{455,556,689},
				{787,855,356}
		};
		ArrayList<int[][]> slt = new ArrayList<int[][]>() ;
		slt.add(dest);
		slt.add(source);
		
		Graph gph = new Graph(5);
		gph.addEdge(0, squares, dest,4, 5,slt,"right");
		gph.addEdge(0, squares, source,4, 6, slt,"left");
		gph.addEdge(1, dest,squares,4,9,slt,"up");
		gph.print(gph);
		System.out.println();
		gph.adjarray[1].Head.PrintgetSolution();
		
		
	/*	Node y = new Node(squares,source,9,slt);

		System.out.println(y);
		System.out.println();
		y.PrintgetSolution();
		System.out.println(y.bookkeping());*/

	}

}


//This where the node creation starts . 
//This is assigning the node to Head node that will be assign to the beginning of the array. 
class HeadNode{
	Node Head;
}

//The node class start here. 
class Node implements Comparable<Node>{
	//The following are all the variables that the node stores. It stores everything from current level to current node and the edges to the node are as 
	//destination, also stores current count for the move and current count for the node, and also store the solution of the node. 
	//Direction
	String dir;
	//current cost of node
	int currentCost;
	//level
	int level;
	//parent
	int [][] source;
	//children
	int [][] destination;
	//Path to your arrival
	ArrayList solution = new ArrayList<Integer[][]>(); 
	//bookkeping
	 int cost = 0;
	Node next;
	
	// The following nodes were created for different purposes. 
	public Node(int[][] source, int[][] destination,int cost){
		this.cost = cost;
		//this.solution.add(source);
		this.source = source;
		this.destination = destination;
		next = null;
	}
	//This is the one is mostly used within the graph. 
	public Node(int level ,int[][] source, int[][] destination, int cost,int currentC, ArrayList<int[][]> path, String dir){
		this.dir = dir;
		this.currentCost = currentC;
		this.level = level;
		this.cost = cost;
		solution = path;
		this.source= source;
		this.destination=destination;
	}
	public Node(int[][] source, int[][] destination, Node nextt){
		this.source = source;
		this.destination = destination;
		next = nextt;
	}
	public void setNext(Node setNext){
		next = setNext;
	}
	public Node getNext(){
		return next;
	}
	//This where we start setting methods to retrieve some information of the node. 
	public int currentCost(){
		return currentCost;
	}
	public int bookkeping(){
		int y = cost;
		return y;
	}
	public int level(){
		return level;
	}
	public ArrayList getSolution(){
		return solution;
	}
	//This method is created to show the value of the current path of the node.
	public void PrintgetSolution(){
		int counts = 0;
		boolean flag = true;
		//System.out.println(Arrays.deepToString((Object[]) solution.get(1)));
		
		for(Object i: solution){
			System.out.println(Arrays.deepToString((Object[]) i));
		}
	}
//This was created to do comparisons of nodes. 
	public int compareTo(Node other){
		if(this.currentCost == other.currentCost){
			return 0;
		}
		else if(this.currentCost > other.currentCost){
			return 1;
		}
		else{
			return -1;
		}
	}
	public String toString(){
		return Arrays.deepToString(source) +":" + Arrays.deepToString(destination);
	}
}

