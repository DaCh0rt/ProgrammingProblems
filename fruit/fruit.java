import java.util.*;

public class fruit{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//read in num cases
		int nC = in.nextInt();
		boolean solved;

		//solve all cases
		for(int i = 0; i < nC; i++){
			//read in sales for the n days
			int n = in.nextInt();
			int[] days = new int[n];
			for(int j = 0; j < n; j++){
				days[j] = in.nextInt();
			}

			//this looks greedy, it is not. brute force is the way.
			solved = false;
			for(int j = 0;; j++){//j is how much fruit we buy each day
				int total = 0;
				int max = 0;
				for(int k = 0; k < n; k++){//run a simulation with buying j fruit each day
					total += j;
					if(total - days[k] < 0)//we failed
						break;

					total -= days[k];
					max = Math.max(total, max);

					if(k == n -1)//we made it
						solved = true;
				}

				if(solved){//print the amt of fruit to buy each day and the max we had in store
					System.out.println(j + " " + max);
					break;
				}			
			}
		}
	}
}
