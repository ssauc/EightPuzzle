import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//A* serch implementation with heuristics tiles not in the correct position. 
public class AstarSearch {
	//contains visited arrays. 
	private ArrayList<int[][]> visited = new ArrayList<>();
	//hold the values for the final values. 
	 Node fnode;
	 boolean found = false;
	 int count;
	 int totalcount;
	 int nodecost;
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
  //MAin function for a*search takes a graph and the goal. 
     public AstarSearch(Graph G, int[][] s){
 		astars(G,s);
 	}
 //a* search main function. 
 	@SuppressWarnings("static-access")
	private void astars(Graph G, int[][] s){
 
 //Adding to the queue initial values
     q.add(G.adjarray[0].Head);
     
    
 //Going through the queue    
     outerloop:
     while(!q.isEmpty()){
    	 count+=1;
    	 Node current = q.poll();
    	 nodecost+=current.currentCost;
    	 if(check(current.source)== false){
				visited.add(current.source);
			}
    	 
    	 if(Arrays.deepEquals(current.source,s)){
				fnode = current;
				found = true;
				break outerloop;
			}
//iterating through the node.    	 
    	 while(current != null){
    		 
    		 Heuristics sarr = new Heuristics();
    		 Heuristics darr = new Heuristics();
  //Heuristic implementations tiles not in the correct position.   		 
    		 ArrayList sd = sarr.tilesNotInCorrect(current.source, s);
    		 ArrayList da = darr.tilesNotInCorrect(current.destination, s);
    		 
    		 int cost = sd.size();
             int costch = da.size();
             
  //Checking for if the cost is less of the children or not.            
             if( check(current.destination)== true && costch >= cost){
                 current = current.next;
            	 continue;
             }
         //IF not we move to the next one in the array. 
             else{
            	 int currlevel = 0;
            	 while(check(G.adjarray[current.level+currlevel].Head.source) == true){
            		 currlevel+=1;
					}
            //Check for repeated values. Move to next node.	 
            	 if(check(G.adjarray[current.level+currlevel].Head.source) == false){
            		 q.add(G.adjarray[current.level+currlevel].Head);
            		 totalcount+=1;
            		 visited.add(G.adjarray[current.level+currlevel].Head.source);
            		 current = current.next;
            	 }
            	 
					
            		 }
             
    	 }
    	 
     }
     
 	}
 
 //Check if we have our node in the table already
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
 //Retrieving values of final answer. 
 	public int times(){
		return count;
	}
 	public int totaltimes(){
 		return totalcount;
}
 	public int nodecost(){
 		return nodecost;
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



