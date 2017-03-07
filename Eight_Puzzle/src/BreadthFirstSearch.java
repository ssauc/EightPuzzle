import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//The the class for breadth first search. The difference of breadth first search is that it uses a queue. 
public class BreadthFirstSearch {
	//Track if the solution was found. 
	private boolean found = false;
	//Used to keep track of visited nodes. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//This the data structure used to make breadth first search possible. 
	private Queue <Node> q = new LinkedList<>();
	
	//used to return the final result. 
	Node current;
	int count;
	int currlevel;
	Node fnode;
	int totalcount;
	int nodepath;
	
	//The method is use to call the main method that actually does the calculations . 
	public BreadthFirstSearch(Graph G, int[][] s){
		bfs(G,s);
	}
	
	//The search only takes in a graph and the depth of the graph. 
	private void bfs(Graph G, int[][] s){
			
		//Setting up initial values. 
			q.add(G.adjarray[0].Head);
			visited.add(G.adjarray[0].Head.source);
		
		//The loop of the queue. At this point we add the times it gone through and remove from the queue, and also to the repeated values.
			outerloop:
			while(!q.isEmpty()){
				count+=1;
				current = q.remove();
				nodepath+=current.currentCost;
				if(check(current.source)== false){
					visited.add(current.source);
				}
				
		//The loop of the node. 
			while(current != null){
				
		//This is the point where it check to see if we found a solution. 
				if(Arrays.deepEquals(current.source,s)){
					fnode = current;
					found = true;
					break outerloop;
				}
		//Else it goes through check of checking if we visited the loop or to add the next node in line. 
				else{
					boolean flag = false;
					if(q.size()== 0){
						while(check(G.adjarray[current.level+currlevel].Head.source) == true){
							currlevel+=1;
						}
		//This where we check of the duplicate values to avoid them. 
						if(check(G.adjarray[current.level+currlevel].Head.source)== false){
							q.add(G.adjarray[current.level+currlevel].Head);
							totalcount+=1;
						}			
						}
					
					else{
		//This old code that was left when taking a different approach of checking for duplicates. 	
					for(Node l : q){
						if(l.source != current.source){
							flag = true;
							break;
						}
					}
					}
			//Moving to the next node in the linked list. 
					currlevel=0;
					current = current.next;
					}
				}
			
			}
			
		}
	//This is the method that returns the count of the iteratios. 
	public int times(){
		return count;
	}
	public int totaltimes(){
		return totalcount;
	}
	public int nodecost(){
		return nodepath;
	}
	//This is method that tells us if the solution was found. 
	public boolean found(){
		return found;
	}
	//This is the method that returns final node that had the value we were looking. 
	public Node finalresult(){
		return fnode;
	}
	
	
	//This method used to check of the duplicate states. 
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

	
	//Made for testing. ---------------------------------------------
	public void print(){
	//	System.out.println("Size of queue "+q.size());
	//	for(Node s : q) { 
	//		  System.out.println(s.toString()); 
	//	}
		System.out.println("Arrays visited");
		for(int i=0; i<visited.size();i++){
			System.out.println(Arrays.deepToString(visited.get(i)));//+":"+ visited.get(i).currentCost);
		}}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

