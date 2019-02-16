import java.util.*;

public class minion{
	private static int n;
	private static boolean[][] adjMat;
	private static String[][] adjMatT;
	private static String[] bad;
	private static boolean solved;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int m = in.nextInt();

		for(int i = 0; i < m; i++){
			int t = in.nextInt();
			bad = new String[t];
			for(int j = 0; j < t; j++){
				bad[j] = in.next();
			}

			n = in.nextInt();
			int e = in.nextInt();

			adjMat = new boolean[n][n];
			adjMatT = new String[n][n];

			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					adjMatT[j][k] = "";
				}
			}


			for(int j = 0; j < e; j++){
				int x = in.nextInt();
				int y = in.nextInt();

				String s = in.next();
				adjMat[x][y] = true;
				adjMatT[x][y] = s;
				adjMat[y][x] = true;
				adjMatT[y][x] = s;
			}

			solved = false;
			DFS();
		}
	}

	static void DFS() {
		boolean[] v = new boolean[n];
		int numComponents = 0;

		// for(int i = 0; i < n; i++){
		// 	if(!v[i]){
		// 		++numComponents;
		// 		// System.out.printf("DFS for component %d starting at node %d%n", numComponents,i);
		// 		DFS(i,v);
		// 	}
		// }
		DFS(0,v);

		// boolean solved = true;
		// for(int i = 0; i < v.length; i++){
		// 	if(v[i] == false)
		// 		solved = false;
		// }

		if(solved){
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void DFS(int at, boolean[] v){
		// System.out.printf("at node %d in the DFS%n",at);

		v[at] = true;

		if(at == (n - 1)){
			solved = true;
			return;
		}

		for(int i = 0; i<n; i++){
			boolean good = true;
			for(int j = 0; j < bad.length; j++){
				if(bad[j].compareTo(adjMatT[at][i]) == 0){
					good = false;
					break;
				}
			}
			// System.out.println("maybe");
			if(adjMat[at][i] && !v[i] && good){
				// System.out.printf("Going to node %d...", i);
				DFS(i,v);
			}
		}
		// System.out.printf("done processing node %d%n",at);
	}
}