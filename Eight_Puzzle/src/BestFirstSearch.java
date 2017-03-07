import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//This is the best first search algorithm. This algorithm is implemented with the priority queue.
public class BestFirstSearch {
	//variable to see if we found our answer
	private boolean found = false;
	//insertion of visited arrays. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//Data structure used priority queue.	
	//Implement a priority queue, with it's comparator. 
    PriorityQueue<Node> pq = new PriorityQueue<Node>(
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
	
	
	
	//Variables returned for final answer
	Node current;
	int count;
	int currlevel;
	Node fnode;
	
	//search algorithm calls the main function for the job. 
	public BestFirstSearch(Graph G, int[][] s){
		bestfs(G,s);
	}
	
	//Main function takes in the graph and final goal
	private void bestfs(Graph G, int[][] s){
		//setting up initial the values. 
			pq.add(G.adjarray[0].Head);
			
			//Whether it was visited or not. 
			visited.add(G.adjarray[0].Head.source);
			
			//iteration of the queue
			outerloop:
			while(!pq.isEmpty()){
				count+= 1;
				
				//Removal of the queue into node.
				current = pq.poll();
				
				//adding node to visited.
				if(check(current.source)== false){
					visited.add(current.source);
				}
				
			//Going through the node. 
			while(current != null){
				//Checking to see if we found our answer. 
				if(Arrays.deepEquals(current.source,s)){
					fnode = current;
					found = true;
					break outerloop;
				}
				//Else we check if the priority queue is empty. 
				else{
				boolean flag = false;
				
				//If priority queue empty than we run our heuristics and find our next value to insert. 
				if(pq.size()== 0){		
							int levs = 0;
							hloop:
							for(int x =0; x < G.V(); x++){
								Heuristics hs = new Heuristics();
							if(hs.tilesNotInCorrect(G.adjarray[current.level+x].Head.source, s).size() < 
								hs.tilesNotInCorrect(current.source,s).size()){
								levs = current.level+x;
								//Once value found we check to see if we gone through it and add it to the priority queue
								if(check(G.adjarray[levs+1].Head.source) == false){
								pq.add(G.adjarray[levs+1].Head);
								break hloop;
								}
							}
							}
							
					
							
					//	}
					}
					else{
				//Old code for checking duplicates. 
					for(Node l : pq){
						if(l.source != current.source){
							flag = true;
							break;
						}
					}
					}
						
					}
				//We move the next node.
					current = current.next;
					}
				}
			
			}
		//	}
	
//methods for calling final answer.
	public int times(){
		return count;
	}
	public boolean found(){
		return found;
	}
	public Node finalresult(){
		return fnode;
	}
//Checking if we visited a node. 
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
//printing queue and visited arrays. 
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
