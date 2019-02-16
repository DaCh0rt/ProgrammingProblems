import java.util.*;

public class sorting{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for(int i = 0; i < n; i++){
			int g = in.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			for(int j = 0; j < g; j++){
				pq.add(in.nextInt());
			}

			int sum = 0;
			while(pq.size() > 1){
				int num1 = pq.poll();
				int num2 = pq.poll();
				int tmp = num1 + num2;
				sum += tmp;
				pq.add(tmp);
			}


			System.out.println(sum);
		}
	}
}