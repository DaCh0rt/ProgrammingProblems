import java.util.*;

public class routes{
	final public static int MAX = (int)1e9;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			//read in vertexes, edges, and number of shortest paths to source to check.
			int v = in.nextInt();
			int e = in.nextInt();
			int q = in.nextInt();

			//all edges are 2 way
			edge[] eList = new edge[e*2];

			//read in all edges
			for(int j = 0; j < e; j++){
				int s = in.nextInt() - 1;
				int d = in.nextInt() - 1;
				int w = in.nextInt();

				eList[2*j] = new edge(s,d,w);
				eList[2*j + 1] = new edge(d,s,w);
			}

			//run bellman ford
			int[] sol = bellmanford(eList, v, 0);

			//distance from source to dest is the same as dest to source in a 2 way graph
			for(int j = 0; j < q; j++){
				int dest = in.nextInt() -1;

				//print out distance from dest to source
				System.out.println(sol[dest]);
			}


		}
	}

	public static int[] bellmanford(edge[] eList, int numVerticies, int source){
		int[] estimates = new int[numVerticies];

		Arrays.fill(estimates,MAX);

		estimates[source] = 0;

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
