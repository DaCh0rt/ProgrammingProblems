import java.util.*;

public class violin1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for(int i = 0; i < n; i++){
			int numNotes = in.nextInt();

			ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
			stack.push(0);
			int movements = 0;
			for(int j = 0; j < numNotes; j++){
				int next = in.nextInt();

				if (next == stack.peek())
					continue;

				if (next > stack.peek()){
					movements++;
					stack.push(next);
					continue;
				}

				if (next < stack.peek()){
					while(next < stack.peek()){
						movements++;
						stack.pop();
					}

					if(next > stack.peek()){
						movements++;
						stack.push(next);
						continue;
					}
				}
			}
			System.out.println(movements);
		}
	}
}