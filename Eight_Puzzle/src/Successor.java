import java.util.*;

public class Successor {
	
	//Creating the variable that will be used within the function.
	//The levels that will increased until the an answer is found.
	public static int levels;
	//These are the variable that will keep track of the each iterations current level
	static int inlevel;
	//This is where the graph of nodes will be stored. 
	public static ArrayList<int[][]> ingraph = new ArrayList<>();
	//This is where the current path of the answer will live. 
	public static ArrayList<int[][]> sol = new ArrayList<int[][]>() ;
	//public static  Graph gph = new Graph(levels);
	
	
	// This is the main function that will be ran for the successor. 
	public static void Successors(int[][] state, int count, int inlevel, int levelselect, Graph gph){
		//This is where I assign the values coming from the function.
		//This is the one that will keep track of the current depth of the graph.
		levels = levelselect;
		//This is the list for the queue to know the current position of where we are in the graph. 
		Queue <int[][]> q = new LinkedList<int[][]>();
		//This to know what values goes with the current position of the graph. 
		Queue <Integer> c = new LinkedList<Integer>();
		//This where I keep track of the current solution. 
		Queue <ArrayList>al = new LinkedList<ArrayList>();
		
		//This where I set my first set of values to start the insert into my table. 
		q.add(state);
		c.add(count);
		al.add(sol);
		
		//This is the queue that I check that currently holds the values to be inserted in the graph. 
		while(!q.isEmpty()){
			state = q.remove();
			int csofar = c.remove();
			sol = new ArrayList<int[][]>(al.remove());
			sol.add(state);
	
		//This the part that break off when we reach the limit of our graph. 
		if(inlevel == levels){
			break;
		}
		else{
		
		//In the next section is where I go through the possibilities that the current state has. I also add levels,count,current count, current path. 
		// and the current direction of the how we got there. 
		int[][] destination = copyArray(state);
		PuzzleCreator.RIGHT(destination);
		if(!Arrays.deepEquals(state, destination)){
			
			int csofar1= PuzzleCreator.count + csofar;
			ArrayList<int[][]> sol1 = sol;
			gph.addEdge(inlevel, state, destination, csofar1,csofar,sol1, "RIGHT");
			al.add(sol1);
			q.add(destination);
			c.add(csofar1);
			//System.out.println("Right");
		}
		int[][] destination2 = copyArray(state);
		PuzzleCreator.LEFT(destination2);
		if(!Arrays.deepEquals(state, destination2)){
			int csofar2= PuzzleCreator.count + csofar;
			ArrayList<int[][]> sol2 = sol;
			gph.addEdge(inlevel, state, destination2, csofar2,csofar,sol2,"LEFT");
			al.add(sol2);
			q.add(destination2);
			c.add(csofar2);
			//System.out.println("Left");
		}
		int[][] destination3 = copyArray(state);
		PuzzleCreator.DOWN(destination3);
		if(!Arrays.deepEquals(state, destination3)){
			int csofar3= PuzzleCreator.count + csofar;
			ArrayList<int[][]> sol3 = sol;
			gph.addEdge(inlevel, state, destination3, csofar3,csofar,sol3, "DOWN");
			al.add(sol3);
			q.add(destination3);
			c.add(csofar3);
			//System.out.println("Down");
		}
		int[][] destination4 = copyArray(state);
		PuzzleCreator.UP(destination4);
		if(!Arrays.deepEquals(state, destination4)){
			int csofar4= PuzzleCreator.count + csofar;
			ArrayList<int[][]> sol4 = sol;
			gph.addEdge(inlevel, state, destination4, csofar4,csofar,sol4, "UP");
			al.add(sol4);
			q.add(destination4);
			c.add(csofar4);
			//System.out.println("UP");
			
		}
		}
		
		inlevel = inlevel+1;
		}
	}
	
	//This function was created to check if the current graph didn't contain the value. 
	public static boolean checkg ( int[][] cs){
		boolean fl= false;
			for(int i=0; i<ingraph.size();i++){
				if(Arrays.deepEquals(ingraph.get(i),cs)){
					fl= true;
					break;
			}
				}
			return fl;
	}
	
	//This function was created to copy one array into another. 
	public static int[][] copyArray(int[][] arr){
		int[][] narr = new int[arr.length][arr[0].length] ;
		for (int i = 0; i < arr.length; i++) {
			for(int j=0; j< arr[i].length; j++){
				narr[i][j] = arr[i][j];
			}
		}
		return narr;
	}
	//This function was created to print the solution. 
	public static void printSolutions(ArrayList psl){
		for(Object i: psl){
			System.out.println(Arrays.deepToString((Object[]) i));
		}
	}
//This section was used for testing. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] easy= {
				{1,3,4},
				{8,6,2},
				{7,0,5}
		};
		int[][] medium= {
				{2,8,1},
				{0,4,3},
				{7,6,5}
		};
		int[][] hard= {
				{5,6,7},
				{4,0,8},
				{3,2,1}
		};
		
		int[][] goal ={
				{1,2,3},
				{8,0,4},
				{7,6,5}
		};
		//Successor sc = new Successor(squares,5,0);
		//Queue <ArrayList>qal = new LinkedList<ArrayList>();
		//ArrayList<int[][]> slo = new ArrayList<int[][]>() ;
		
		//ArrayList<int[][]> slow = new ArrayList<int[][]>() ;
		/*slow.add(source);
		//slow.add(squares);
		//printSolution(slow);
		slo.add(squares);
		//qal.add(slo);
		//slow = slo;
		slow.add(squares);
		//qal.add(slow);
		System.out.println(slow.size());
		printSolutions(slo);
		//printSolutions(slow);
		System.out.println();
		
		slow = new ArrayList<int[][]>(slo);
		slow.add(source);*/
		
		//slow = new ArrayList<int[][]>(slo);
		//printSolutions(slow);
		//printSolution(qal.remove());
		//Successors(squares,0,0);
		System.out.println();
		//ArrayList<int[][]> slo = new ArrayList<int[][]>() ;
		//slo = gph.adjarray[4].Head.getSolution();
		//printSolutions(slo);
		Graph gphs = new Graph(90000);
		Successors(medium,0,0,90000, gphs);
		//gph.printsol();
		//System.out.println();
		//BreadthFirstSearch b = new BreadthFirstSearch(gphs,goal);
		//DepthFirstSearch b = new DepthFirstSearch(gph,goal);
		//UniformCostSearch b = new UniformCostSearch(gph,goal);
		//BestFirstSearch b = new BestFirstSearch(gph,goal);
		//AstarSearch b = new AstarSearch(gphs,goal);
		AstarSTwo b = new AstarSTwo(gphs,goal);
		//gph.printSol(b.finalresult().getSolution());
		b.print();
		System.out.println(b.found());
		System.out.println(b.times());
		
	//	b.print();
		
		//System.out.println(Arrays.deepEquals(squares,source));
		//b.print();
		
	}
	


}
