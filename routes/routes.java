import java.util.*;

public class routes{
	final public static int MAX = (int)1e9;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			int v = in.nextInt();
			int e = in.nextInt();
			int q = in.nextInt();

			edge[] eList = new edge[e*2];

			for(int j = 0; j < e; j++){
				int s = in.nextInt() - 1;
				int d = in.nextInt() - 1;
				int w = in.nextInt();

				eList[2*j] = new edge(s,d,w);
				eList[2*j + 1] = new edge(d,s,w);
			}

			int[] sol = bellmanford(eList, v, 0);

			for(int j = 0; j < q; j++){
				int dest = in.nextInt() -1;

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
