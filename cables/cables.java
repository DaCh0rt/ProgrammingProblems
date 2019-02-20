import java.util.*;

public class cables{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//start with at least 1 test case, n is number of points to join, file ends with 0
		int n = in.nextInt();
		while(n > 0){//test case to process?, process
			
			//store the points in parallel array
			int[] px = new int[n];
			int[] py = new int[n];

			ArrayList<edge> list = new ArrayList<edge>();

			//read in all points
			for(int i = 0; i < n; i++){
				px[i] = in.nextInt();
				py[i] = in.nextInt();
			}

			//add all edges that you can draw in the graph using distance formula
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					double dist = Math.sqrt(Math.pow(px[i] - px[j],2) + Math.pow(py[i] - py[j],2));
					list.add(new edge(i,j,dist));
					list.add(new edge(j,i,dist));
				}
			}

			//call kruskals on the fully connected graph to determine the minimum spanning tree.
			System.out.printf("%.2f\n",kruskals.mst(list,n));


			n = in.nextInt();
		}
	}

	static class dset{//disjoint set class to keep track of forrests
		public int[] parent;
		public int[] height;
		public int n;

		public dset(int size){
			parent = new int[size];
			height = new int[size];
			for(int i = 0 ; i < size; i++){
				parent[i] = i;
			}
		}

		public int find(int v){
			if(parent[v]==v) return v;
			parent[v] = find(parent[v]);
			height[v]=1;
			return parent[v];
		}

		public boolean union(int v1, int v2){
			int p1 = find(v1);
			int p2 = find(v2);
			if(p1==p2) return false;

			if(height[p2]<height[p1]) parent[p2] = p1;
			else if (height[p1] < height[p2]) parent[p1] = p2;
			else{
				parent[p2] = p1;
				height[p1]++;
			}
			return true;
		}
	}

	static class edge implements Comparable<edge>{
		public int v1;
		public int v2;
		public double w;

		public edge(int a, int b, double weight){
			v1 = a;
			v2 = b;
			w = weight;
		}

		public int compareTo(edge other){
			return Double.compare(this.w,other.w);
		}
	}

	static class kruskals{
		public static double mst(ArrayList<edge> list, int n){
			Collections.sort(list);

			dset trees = new dset(n);
			int numEdges = 0;
			double res = 0;

			for(int i = 0; i < list.size(); i++){
				boolean merged = trees.union(list.get(i).v1, list.get(i).v2);
				if(!merged) continue;

				numEdges++;
				res += list.get(i).w;
				if (numEdges == n-1) break;
			}

			return numEdges == n-1? res:-1.0;
		}
	}
}
