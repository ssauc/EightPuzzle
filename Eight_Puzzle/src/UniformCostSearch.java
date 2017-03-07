import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//The uniform cost search is implemented through use of the priority queue. 
public class UniformCostSearch {
	//Used to find out if the solution was  found. 
	private boolean found = false;
	//Used to store visited arrays. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//priority Queue used for the data structure.
	//Implement a priority queue, with it's comparator. 
    PriorityQueue<Node> q = new PriorityQueue<Node>(
    new Comparator<Node>(){
//override compare method
     public int compare(Node i, Node j){
        if(i.currentCost > j.currentCost){
            return 1;
        }

        else if (i.currentCost < j.currentCost){
            return -1;
        }

        else{
            return 0;
        }
     }
    });
	//Used to retrieve a solution. 
	Node current;
	int count;
	Node fnode;
	int currlevel;
	
	//Used for calling the Main function that does the work.
	public UniformCostSearch(Graph G, int[][] s){
		ufs(G,s);
	}
	//The search algorithm takes in a graph and the goal . 
	private void ufs(Graph G, int[][] s){
		//Adding
			
			q.add(G.adjarray[0].Head);
			visited.add(G.adjarray[0].Head.source);
			
			//Going throug the queue. 
			outerloop:
			while(!q.isEmpty()){
				count+= 1;
				
				//Removing the from the queue is the biggest difference from others.
				current = q.poll();
				//Inserting into the visited. 
				if(check(current.source)== false){
					visited.add(current.source);
				}
				
			//Going through the node. 	
			while(current != null){
				//check to sse if we found it. 
				if(Arrays.deepEquals(current.source,s)){
					fnode = current;
					found = true;
					break outerloop;
				}
				//else check if the queue is empty and adding to it. 
				else{
					if(q.size()== 0){
						//Checking if the node in the arrays has already been added. 
						while(check(G.adjarray[current.level+currlevel].Head.source) == true){
							currlevel+=1;
						}
						//Final check to see if we are adding it to the queue.
						if(check(G.adjarray[current.level+currlevel].Head.source)== false){
							//System.out.println(count+=1);
							q.add(G.adjarray[current.level+currlevel].Head);
						
					}
					}
					else{
				//Old code left off of different approach to checking visited. 
					for(Node l : q){
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
			
//Times of iteration		
	public int times(){
		return count;
	}
//If we found our answer. 
	public boolean found(){
		return found;
	}
//Returning node of the final answer
	public Node finalresult(){
		return fnode;
	}
//Checking to see if the node has been visited. 
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
	
//Print the queue and the answer. 
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

