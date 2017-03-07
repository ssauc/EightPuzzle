//THis class was created to create the table display and dictate how you can move within that board. 
public class PuzzleCreator {
	public static int count;
	public static int total;
	
	//This where the table gets created and populated. 
	public static void CreatePuzzle(int[][] quad){
		System.out.println();
		System.out.println("  "+quad[0][0]+"  |  "+quad[0][1]+"    |  "+quad[0][2]);
		System.out.println("-----|-------|-----");
		System.out.println("  "+quad[1][0]+"  |  "+quad[1][1]+"    |  "+quad[1][2]);
		System.out.println("-----|-------|-----");
		System.out.println("  "+quad[2][0]+"  |  "+quad[2][1]+"    |  "+quad[2][2]);
		System.out.println("-----|-------|-----");
	}
	
	//The following are the moves allowed within the board. 
	public static void RIGHT(int [][] state){
		outerloop:
		for(int i= 0; i < state.length; i++){
			for(int j=0; j< state.length; j++){
				//System.out.println(squares[i][j]);
				if(state[i][j] == state[0][2] && state[0][1] == 0  ){
					count = state[0][2];
					total += state[0][2];
					
					state[0][1] = state[0][2];
					state[0][2] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[0][1] && state[0][0] == 0){
					count = state[0][1];
					total += state[0][1];
					state[0][0] = state[0][1];
					state[0][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][1] && state[1][0] == 0){
					count = state[1][1];
					total += state[1][1];
					state[1][0] = state[1][1];
					state[1][1] = 0;
					break outerloop;
 				}
				else if(state[i][j] == state [1][2] && state[1][1] == 0){
					count = state[1][2];
					total += state[1][2];
					state[1][1] = state[1][2];
					state[1][2] = 0;
					break outerloop;
				}else if(state[i][j] == state[2][1] && state[2][0] == 0){
					count = state[2][1];
					count += state[2][1];
					state[2][0] = state[2][1];
					state[2][1] = 0;
					break outerloop;
 				}
				else if(state[i][j] == state [2][2] && state[2][1] == 0){
					total += state[2][2];
					count = state[2][2];
					state[2][1] = state[2][2];
					state[2][2] = 0;
					break outerloop;
				}
				
			}
			}
	
	}

	public static void LEFT (int [][] state){
		outerloop:
		for(int i= 0; i < state.length; i++){
			for(int j=0; j< state.length; j++){
				//System.out.println(squares[i][j]);
				if(state[i][j] == state[0][1] && state[0][2] == 0  ){
					count = state[0][1];
					total += state[0][1];
					state[0][2] = state[0][1];
					state[0][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[0][0] && state[0][1] == 0){
					count = state[0][0];
					total += state[0][0];
					state[0][1] = state[0][0];
					state[0][0] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][0] && state[1][1] == 0){
					count = state[1][0];
					total += state[1][0];
					state[1][1] = state[1][0];
					state[1][0] = 0;
					break outerloop;
 				}
				else if(state[i][j] == state [1][1] && state[1][2] == 0){
					count = state[1][1];
					total += state[1][1];
					state[1][2] = state[1][1];
					state[1][1] = 0;
					break outerloop;
				}else if(state[i][j] == state[2][0] && state[2][1] == 0){
					count = state[2][0];
					total += state[2][0];
					state[2][1] = state[2][0];
					state[2][0] = 0;
					break outerloop;
 				}
				else if(state[i][j] == state [2][1] && state[2][2] == 0){
					count = state[2][1];
					total += state[2][1];
					state[2][2] = state[2][1];
					state[2][1] = 0;
					break outerloop;
				}
				
			}
			}
	}
	
	public static void UP (int [][] state){
		outerloop:
		for(int i= 0; i < state.length; i++){
			for(int j=0; j< state.length; j++){
				if(state[i][j] == state[0][0] && state [1][0] == 0){
					count = state[0][0];
					total += state[0][0];
					state[1][0] = state[0][0];
					state[0][0] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][0] && state[2][0] == 0){
					count = state[1][0];
					total += state[1][0];
					state[2][0] = state[1][0];
					state[1][0] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[0][1] && state [1][1] == 0){
					count = state[0][1];
					total += state[0][1];
					state[1][1] = state[0][1];
					state[0][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][1] && state [2][1] == 0){
					count = state[1][1];
					total += state[1][1];
					state[2][1] = state[1][1];
					state[1][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[0][2] && state [1][2] == 0){
					count = state[0][2];
					total += state[0][2];
					state[1][2] = state[0][2];
					state[0][2] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][2] && state [2][2] == 0){
					count = state[1][2];
					total += state[1][2];
					state[2][2] = state[1][2];
					state[1][2] = 0;
					break outerloop;
				}
			}
	}}
	
	//DOESN'T BREAK OUT OF THE LOOP---PROBLEM
	public static void DOWN (int [][] state){
		outerloop:
		for(int i= 0; i < state.length; i++){
			for(int j=0; j< state.length; j++){
				if(state[i][j] == state[1][0] && state[0][0] == 0){
					count = state[1][0];
					total += state[1][0];
					state[0][0] = state[1][0];
					state[1][0] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[2][0] && state[1][0] == 0){
					count = state[2][0];
					total += state[2][0];
					state[1][0] = state[2][0];
					state[2][0] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][1] && state[0][1] == 0){
					count = state[1][1];
					total += state[1][1];
					state[0][1] = state[1][1];
					state[1][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[2][1] && state[1][1] == 0){
					count = state[2][1];
					total += state[2][1];
					state[1][1] = state[2][1];
					state[2][1] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[1][2] && state[0][2] == 0){
					count = state[1][2];
					total += state[1][2];
					state[0][2] = state[1][2];
					state[1][2] = 0;
					break outerloop;
				}
				else if(state[i][j] == state[2][2] && state[1][2] == 0){
					count = state[2][2];
					total += state[2][2];
					state[1][2] = state[2][2];
					state[2][2] = 0;
					break outerloop;
				}
			}
	}
	}
	
	//These are created to return the new state after the move was made. 
	public static int[][] returnright(int[][] state){
			RIGHT(state);
		return state;
	}
	public static int[][] returnleft(int[][] state){
		LEFT(state);
	return state;
}
	public static int[][] returnup(int[][] state){
		UP(state);
	return state;
}
	public static int[][] returndown(int[][] state){
		DOWN(state);
	return state;
}
	public static int returncount(){
		return count;
	}

}
