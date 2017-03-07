import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//This was created to test the creation of the table. This is made to use for oneself. 
public class Eight_Puzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//Initial state. 
		int[][] squares= {
				{1,2,0},
				{4,5,6},
				{7,8,3}
		};
		
	//String to check when to stop
		String stop = "cont";
	//Loop for continuing or stopping. 
		while(!stop.equals("quit")){
			System.out.println("Original puzzle");
			PuzzleCreator.CreatePuzzle(squares);
			System.out.println(PuzzleCreator.count);
			//System.out.println(Arrays.toString(squares));
			System.out.println(Arrays.deepToString(squares));
			System.out.println("What would like to do next: UP, DOWN, LEFT, RIGHT");
			System.out.println("You can type Quit to exit.");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
	//Read the movement that was entered into the console. 		
			if(input.equals("RIGHT")){
				PuzzleCreator.RIGHT(squares);
				//CreatePuzzle(squares);
			}
			else if(input.equals("LEFT")){
				PuzzleCreator.LEFT(squares);
			}
			else if(input.equals("DOWN")){
				PuzzleCreator.DOWN(squares);
			}
			else if(input.equals("UP")){
				PuzzleCreator.UP(squares);
			}
			stop = input.toLowerCase();
			
		}

	}
	
	
}
