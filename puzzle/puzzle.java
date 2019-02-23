import java.util.*;

public class puzzle{
	//dy dx to find possible state branches, states to hold answers for boards
	public static int[] dx = {1,-1}, dy = {1,-1};
	public static HashMap<String,Integer> states = new HashMap<String,Integer>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases
		int n = in.nextInt();
		
		/* n can be very large. because of this we dont want to re compute things
		 * we already know. solution: start from finished board and find all states
		 * reachable from that board and record the distance. symmetry between start
		 * and end state.
		 */
		
		//stack for bfs
		ArrayDeque<String> q = new ArrayDeque<String>();
		
		//put solved state in hashmap
		int iter = 0;
		states.put("123456780",iter);

		//find the next states from start and add
		ArrayList<String> toEnque = nextPositions("123456780");
		for(int i = 0; i < toEnque.size(); i++){
				states.put(toEnque.get(i),iter);

				q.offer(toEnque.get(i));
		}
		iter++;

		//while still having nodes to bfs
		while(!q.isEmpty()){
			iter++;
			int size = q.size();
			// System.out.println("iter: " +  iter + "\tprospecting " + size + "states");
			
			//run thru the current queue and enque the next layer
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

		//lookup every answer
		for(int i = 0; i < n; i++){
			String board = "";
			for(int j = 0; j < 9; j++){
				board += in.nextInt();
			}

			System.out.println(states.get(board));
		}
	}

	//converts string of numbers to 2d int array
	static int[][] stringToPuzzle(String s){

		int[][] puzzle = new int[3][3];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				puzzle[i][j] = s.charAt(i*3 + j) - '0';
			}
		}

		return puzzle;
	}

	//converts 2d int array to string of numbers
	static String puzzleToString(int[][] p){

		String puzzle = "";

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				puzzle += p[i][j];
			}
		}

		return puzzle;
	}

	//returns an arraylist of strings representing the next reachable states
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
