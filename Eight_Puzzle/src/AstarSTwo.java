import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//A* search 2 with manhattan distance heuristic implementation. 
public class AstarSTwo {
	//Visited arrays tracking. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//Values for final result. 
	Node fnode;
	 boolean found = false;
	 int count;
	 
//data structure used priority queue. 
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
     
     //function begins here 
     public AstarSTwo(Graph G, int[][] s){
 		astars(G,s);
 	}
 	
     //Main function takes in graph and final result. 
 	@SuppressWarnings("static-access")
	private void astars(Graph G, int[][] s){
     
 	//initiate values to begin. 
     q.add(G.adjarray[0].Head);
     
     //Loop for queue
     outerloop:
     while(!q.isEmpty()){
    	 count+=1;
    	 Node current = q.poll();
    	 if(check(current.source)== false){
				visited.add(current.source);
			}
    	 
    	 if(Arrays.deepEquals(current.source,s)){
				fnode = current;
				found = true;
				break outerloop;
			}
    	//loop for node.  
    	 while(current != null){
    		 
    		 Heuristics sarr = new Heuristics();
    		 Heuristics darr = new Heuristics();
    	//Heuristic implementation of manhattan distance. 	 
    		 int cost = sarr.ManhattanDist(current.source, s);
             int costch = darr.ManhattanDist(current.destination, s);
         //check to see if we something smaller. 
             if( check(current.destination)== true && costch >= cost){
                 current = current.next;
            	 continue;
             }
            //if not we add to queue.
             else{
            	 int currlevel = 0;
            	 while(check(G.adjarray[current.level+currlevel].Head.source) == true){
            		 currlevel+=1;
            		 //System.out.println("Made it here "+ check(G.adjarray[current.level+currlevel].Head.source)); 
					}
            	 
            	 if(check(G.adjarray[current.level+currlevel].Head.source) == false){
            		 q.add(G.adjarray[current.level+currlevel].Head);
            		 visited.add(G.adjarray[current.level+currlevel].Head.source);
            		 current = current.next;
            	 }
            	 
					
            		 }
             
    	 }
    	 
     }
     
 	}
 	
 	//check if it's been visited method. 
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
 //Retrieving final values here. 
 	public int times(){
		return count;
	}
	public boolean found(){
		return found;
	}
	
	public Node finalresult(){
		return fnode;
	}
     
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



