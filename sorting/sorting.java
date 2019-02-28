import java.util.*;

public class sorting{
	public static void main(String[] args){
		
		//read in num cases
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		//run thru cases
		for(int i = 0; i < n; i++){
			
			//read in num sessions
			int g = in.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int j = 0; j < g; j++){
				pq.add(in.nextInt());
			}

			//greedy sol is to always take the two smallest stacks of papers to merge
			int sum = 0;
			while(pq.size() > 1){
				int num1 = pq.poll();
				int num2 = pq.poll();
				int tmp = num1 + num2;
				sum += tmp;
				pq.add(tmp);
			}

			//merged everything, print out sol
			System.out.println(sum);
		}
	}
}
