import java.util.*;

public class puzzle{
	public static int[] dx = {1,-1}, dy = {1,-1};
	public static HashMap<String,Integer> states = new HashMap<String,Integer>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		// int[][] nice = stringToPuzzle("123456780");
		// for(int i = 0; i < 3; i++){
		// 	for(int j = 0; j < 3; j++){
		// 		System.out.print(nice[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println(puzzleToString(nice));

		int n = in.nextInt();

		ArrayDeque<String> q = new ArrayDeque<String>();
		
		int iter = 0;
		states.put("123456780",iter);

		ArrayList<String> toEnque = nextPositions("123456780");
		for(int i = 0; i < toEnque.size(); i++){
				states.put(toEnque.get(i),iter);

				q.offer(toEnque.get(i));
		}
		iter++;

		while(!q.isEmpty()){
			iter++;
			int size = q.size();
			// System.out.println("iter: " +  iter + "\tprospecting " + size + "states");
			for(int i = 0; i < size; i++){
				toEnque = nextPositions(q.poll());

				for(int j = 0; j < toEnque.size(); j++){
					//add new states to hashmap
					states.put(toEnque.get(j),iter);

					//add new states to queue
					q.offer(toEnque.get(j));
				}
			}
		}

		for(int i = 0; i < n; i++){
			String board = "";
			for(int j = 0; j < 9; j++){
				board += in.nextInt();
			}

			System.out.println(states.get(board));
		}
	}

	static int[][] stringToPuzzle(String s){

		int[][] puzzle = new int[3][3];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				puzzle[i][j] = s.charAt(i*3 + j) - '0';
			}
		}

		return puzzle;
	}

	static String puzzleToString(int[][] p){

		String puzzle = "";

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				puzzle += p[i][j];
			}
		}

		return puzzle;
	}

	static ArrayList<String> nextPositions(String s){

		int[][] puzzle = stringToPuzzle(s);
		ArrayList<String> next = new ArrayList<String>();

		//find open slot
		int x = 0, y = 0;
		boolean found = false;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(puzzle[i][j] == 0){
					found = true;
					x = i;
					y = j;
					break;
				}
			}
			if(found){
				break;
			}
		}

		String tmp = "";
		//check 4 possible moves
		for(int i = 0; i < 2; i++){//x's
			if(x + dx[i] >= 0 && x + dx[i] < 3){
				puzzle[x][y] = puzzle[x + dx[i]][y];
				puzzle[x + dx[i]][y] = 0;

				tmp = puzzleToString(puzzle);
				if(!states.containsKey(tmp))
					next.add(puzzleToString(puzzle));

				puzzle[x + dx[i]][y] = puzzle[x][y];
				puzzle[x][y] = 0;
			}
		}

		for(int i = 0; i < 2; i++){//y's
			if(y + dy[i] >= 0 && y + dy[i] < 3){
				puzzle[x][y] = puzzle[x][y + dy[i]];
				puzzle[x][y + dy[i]] = 0;

				tmp = puzzleToString(puzzle);
				if(!states.containsKey(tmp))
					next.add(puzzleToString(puzzle));

				puzzle[x][y + dy[i]] = puzzle[x][y];
				puzzle[x][y] = 0;
			}
		}

		return next;
	}

}