import java.util.*;

public class violin1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read num cases and go thru them
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			int numNotes = in.nextInt();

			//init stack to simulate fingers being held down. 0 represents open hand to start, init movements
			ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
			stack.push(0);
			int movements = 0;

			//go thru the notes to be played
			for(int j = 0; j < numNotes; j++){
				int next = in.nextInt();

				//if note the same dont move your hand and move on
				if (next == stack.peek())
					continue;

				//if note greater put the finger down to play it, counts as movement
				if (next > stack.peek()){
					movements++;
					stack.push(next);
					continue;
				}

				//if lesser pop the stack until it is not, each pop counts as movement
				if (next < stack.peek()){
					while(next < stack.peek()){
						movements++;
						stack.pop();
					}

					//if greater put finger down to play, counts as movement
					if(next > stack.peek()){
						movements++;
						stack.push(next);
						continue;
					}

					//otherwise it was the same so ignore.
				}
			}

			//done, print
			System.out.println(movements);
		}
	}
}