import java.util.*;

public class longpath{

	final public static int MAX = (int)1e9;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		for(int i = 0; i < c; i++){

			int n = in.nextInt();
			int e = in.nextInt();

			edge[] eList = new edge[e];

			for(int j = 0; j < e; j++){
				int s = in.nextInt();
				int d = in.nextInt();
				int w = in.nextInt();

				eList[j] = new edge(s,d,w);
			}

			int[] shortestPath = bellmanford(eList,n,0);

			for(edge edj: eList){
				edj.negate();
			}

			int[] longestPath = bellmanford(eList,n,0);

			System.out.println(shortestPath[n-1] + " " + (-longestPath[n-1]));

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