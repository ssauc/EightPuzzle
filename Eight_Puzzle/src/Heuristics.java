import java.util.ArrayList;
import java.lang.Math.*;

//Heuristics used through out the program are all in this class. 
public class Heuristics {
	//Set up variable for starting target. 
	public ArrayList<Integer> StartNode = new ArrayList<Integer>();
	
	//Main methd for heuristic class. 
	public Heuristics(){
		
	}
	
	//Heuristics for the manhattan distance. 
	// The main idea is to check each value how far away it is from it's original goal. 
	public int ManhattanDist(int[][] state, int[][] goal){
		//Create temps to store values.
		int total = 0;
		int temp = 0;
		boolean flag = false;
		//we go through the arrays
		for(int x =0; x < state.length; x++){
			for(int y=0; y< state.length; y++){
				//for each value we find out where it exists within the goal and do some comparisons. 
					int[] tempval = distOne(goal, state[x][y]);
					//first we find out the distance from each other. 
					int imove =tempval[0] - x;
					int jmove =tempval[1] - y;
					//Then grab the absolute value and add them. 
					temp = Math.abs(imove) + Math.abs(jmove);
					//We then multiply that distance from the value. 
					total += state[x][y] * temp;
					//System.out.println(imove + ":"+ imove);
					
			}
			
		}
		//Return that value
		return total;
	}	
	//This method is the one used in the manhattan distance for the finding coordinates of the goal. We send them as arrays. 
	public int[] distOne(int[][] array, int goal){
		int[] coord ={0,0};
		for(int x =0; x < array.length; x++){
			for(int y=0; y< array.length; y++){
				if(array[x][y] == goal){
				coord[0] = x;
				coord[1] = y;
				}
			}
			}
		return coord;
	}
		
		
//Heuristics for the amount of tiles not in the correct position. 
	public ArrayList tilesNotInCorrect(int[][] state, int[][] goal){
		//Go through each value and finding out how many are out of order. 
		for(int i =0; i < state.length; i++){
			for(int j=0; j< state.length; j++){
				if(state[i][j] != goal[i][j]){
					StartNode.add(state[i][j]);
				}
				else{continue;}
			}
			
		}
		return StartNode;
	}
	
	
	//returns the amount of tile not in correct position. 
	public int countTilesNotInCorrect(){
		return StartNode.size();
	}

	//Used for testing purposes. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] hard= {
				{1,2,3},
				{4,5,6},
				{7,8,0}
		};
		
		int[][] goal ={
				{4,5,7},
				{1,2,8},
				{3,6,0}
				};
				
				Heuristics arl = new Heuristics();
			/*	System.out.println(arl.tilesNotInCorrect(hard,goal));
				System.out.println(arl.countTilesNotInCorrect());*/
				System.out.println(arl.ManhattanDist(hard, goal));
	}

}
