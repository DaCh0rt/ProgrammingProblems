import java.util.*;

public class longpath{

	//we need a big value to initiate bellman ford
	final public static int MAX = (int)1e9;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases
		int c = in.nextInt();

		//run thru cases
		for(int i = 0; i < c; i++){

			//num nodes, num edges
			int n = in.nextInt();
			int e = in.nextInt();

			edge[] eList = new edge[e];

			//read in all edges and add to edge list
			for(int j = 0; j < e; j++){
				int s = in.nextInt();
				int d = in.nextInt();
				int w = in.nextInt();

				eList[j] = new edge(s,d,w);
			}

			//call bellmanford on the graph
			int[] shortestPath = bellmanford(eList,n,0);

			//reverse edge weights so we can find the max path
			for(edge edj: eList){
				edj.negate();
			}

			//find -maxpath
			int[] longestPath = bellmanford(eList,n,0);

			//computed, print out answers
			System.out.println(shortestPath[n-1] + " " + (-longestPath[n-1]));

		}
	}

	public static int[] bellmanford(edge[] eList, int numVerticies, int source){
		int[] estimates = new int[numVerticies];

		//init
		Arrays.fill(estimates,MAX);

		//dist from source is 0
		estimates[source] = 0;

		//run algorithm
		for(int i = 0; i < numVerticies-1; i++){
			for(edge e:eList){
				if(estimates[e.v1] + e.w < estimates[e.v2]){
					estimates[e.v2] = estimates[e.v1] + e.w;
				}
			}
		}

		return estimates;
	}
}

class edge{
	public int v1;
	public int v2;
	public int w;

	public edge(int a, int b, int c){
		v1 = a;
		v2 = b;
		w = c;
	}

	public void negate(){
		w = -w;
	}
}
