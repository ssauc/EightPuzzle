import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//The the class for breadth first search. The difference of breadth first search is that it uses a stack. 
public class DepthFirstSearch {
	//declaring variables 
	//for check if answer was found.
	private boolean found = false;
	//Array used to enter values we've gone throug. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//The stack the data structure used for going the values. 
	private Stack <Node> stack = new Stack<>();
	
	//Values used to determine final state. 
	Node current;
	int count;
	int totalcount;
	int currlevel;
	Node fnode;
	
	//Same approach method created to call the main method. 
	public DepthFirstSearch(Graph G, int[][] s){
		dfs(G,s);
	}
	
	//The method takes in the graph and final anser. 
	private void dfs(Graph G, int[][] s){
		//Setting up initial values. 
			stack.add(G.adjarray[0].Head);
			visited.add(G.adjarray[0].Head.source);
			
			//Loop that goes through the stack. Keeping track of the iterations and entering value into the already visited.  
			outerloop:
			while(!stack.isEmpty()){
				count+=1;
				current = stack.pop();
				
				if(check(current.source)== false){
					visited.add(current.source);
				}
				
			//Loop that goes through the node. This is also where we verify if we found our answer.
			while(current != null){
				if(Arrays.deepEquals(current.source,s)){
					fnode = current;
					found = true;
					break outerloop;
				}
				//if we haven't arrived at our answer than we add the next node in the array to the list. 
				else{
					
					if(stack.size()== 0){
						while(check(G.adjarray[current.level+currlevel].Head.source) == true){
							currlevel+=1;
						}
						if(check(G.adjarray[current.level+currlevel].Head.source)== false){
							//System.out.println(count+=1);
							totalcount+=1;
							stack.add(G.adjarray[current.level+currlevel].Head);
						
					}
					}
					else{
				//Old code left off of different approach to checking visited. 
					for(Node l : stack){
						if(l.source != current.source){
							boolean flag = true;
							break;
						}
					}
					}
				//we move the next node. 
					currlevel=0;
					current = current.next;
					}
				}
			
			}
			
		}
	
	//Method for checking if node has been visited. 		
	public boolean check ( int[][] cs){
		boolean fl= false;
		for(int i=0; i<visited.size();i++){
			if(Arrays.deepEquals(visited.get(i),cs)){
				fl= true;
				break;
				}
				}
					return fl;
			}
	//The times we iterated through. 	
	public int times(){
		return count;
	}
	//Total count into the data structure.
	public int totaltimes(){
		return totalcount; 
	}
	//Method to check if the answer was found. 
	public boolean found(){
		return found;
	}
	//Returns final node. 
	public Node finalresult(){
		return fnode;
	}
	
	//Prints. out the solution in the queue. Also prints out the nodes in visited. 
	public void print(){
		System.out.println("Size of queue "+stack.size());
		for(Node s : stack) { 
			  System.out.println(s.toString()); 
		}
		System.out.println("Arrays visited");
		for(int i=0; i<visited.size();i++){
			System.out.println(Arrays.deepToString(visited.get(i)));
		}}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

