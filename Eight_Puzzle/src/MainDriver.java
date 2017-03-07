
public class MainDriver {

	//created to drive the puzzle and the algorithms that are called. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//These are all the different states for the assignment. 
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
		
		//Values to check when to stop and increasing the graph size. 
		boolean flag = false;
		int levels = 0; 
		
		//loop to drive everything. 
		while(flag == false){
			
		
		//Try for errors when looping. 
		try {
			//System.out.println(levels);
			levels+=1000;
			Graph gphs = new Graph(levels);
			Successor.Successors(easy,0,0,levels, gphs);
			
			//These are all the algorithms available for try. 
			//BreadthFirstSearch b = new BreadthFirstSearch(gphs,goal);
			//DepthFirstSearch b = new DepthFirstSearch(gphs,goal);
			//UniformCostSearch b = new UniformCostSearch(gphs,goal);
			//BestFirstSearch b = new BestFirstSearch(gphs,goal);
			//AstarSearch b = new AstarSearch(gphs,goal);
			AstarSTwo b = new AstarSTwo(gphs,goal);
			//prints out final values of end product. 
			if(b.found() == true){
			b.print();
			gphs.printSol(b.finalresult().getSolution());
			System.out.println(b.found());
			System.out.println("Times of iterations " +b.times());
			//System.out.println("Total times "+ b.totaltimes());
			//System.out.println("Total times "+ b.nodecost());
			
			flag = true;
			break;
			}
			else{
				System.out.println("The solution to the problem turn out: "+b.found());
				flag = false;
				break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		}
		

	//}

}}
