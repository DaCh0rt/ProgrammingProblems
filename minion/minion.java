import java.util.*;

public class minion{
	private static int n;
	private static boolean[][] adjMat;
	private static String[][] adjMatT;
	private static String[] bad;
	private static boolean solved;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int m = in.nextInt();
		for(int i = 0; i < m; i++){
			
			//read in all the trials the ninja can't do
			int t = in.nextInt();
			bad = new String[t];
			for(int j = 0; j < t; j++){
				bad[j] = in.next();
			}

			//read in edges and nodes
			n = in.nextInt();
			int e = in.nextInt();

			//adjmat and parallel array to store trials on edges
			adjMat = new boolean[n][n];
			adjMatT = new String[n][n];

			//init
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					adjMatT[j][k] = "";
				}
			}

			//read
			for(int j = 0; j < e; j++){
				int x = in.nextInt();
				int y = in.nextInt();

				String s = in.next();
				adjMat[x][y] = true;
				adjMatT[x][y] = s;
				adjMat[y][x] = true;
				adjMatT[y][x] = s;
			}

			//assume not possible and dfs
			solved = false;
			DFS();
		}
	}

	static void DFS() {//wrapper
		boolean[] v = new boolean[n];

		DFS(0,v);

		if(solved){
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void DFS(int at, boolean[] v){
		// System.out.printf("at node %d in the DFS%n",at);

		v[at] = true;
		
		//we made it to the end
		if(at == (n - 1)){
			solved = true;
			return;
		}

		//go thru nodes
		for(int i = 0; i<n; i++){
			
			//see if there is an unsurmountable challenge
			boolean good = true;
			for(int j = 0; j < bad.length; j++){
				if(bad[j].compareTo(adjMatT[at][i]) == 0){
					good = false;
					break;
				}
			}
			
			//looks ok
			if(adjMat[at][i] && !v[i] && good){
				// System.out.printf("Going to node %d...", i);
				DFS(i,v);
			}
		}
		// System.out.printf("done processing node %d%n",at);
	}
}
