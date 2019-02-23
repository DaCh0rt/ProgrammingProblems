import java.util.*;

public class profits{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//guranteed 1 test case, find num of days, test cases end with 0
		int n = in.nextInt();
		while(n > 0){
			
			//read in all days
			int[] days = new int[n];
			for(int i = 0; i < n; i++){
				days[i] = in.nextInt();
			}
			
			//calculate maximum subsequence sum
			System.out.println(mcss3(days));

			n = in.nextInt();
		}

	}

	public static int mcss3(int[] vals) {
	
		//need to init max to the first value to deal with the case of all negatives
		int max=vals[0], sum=0, start=0, end=0, i=0;
	
		for (int j=0; j<vals.length; j++) {
			sum += vals[j];
		
			// Update if we get a better max.
			if (sum > max) {
				max = sum;
				start = i;
				end = j;
			}
			
			// If our running sum falls below 0, there's no need to
			// consider it at all, reset the sum to 0.
			else if (sum < 0) {
				i = j+1;
				sum = 0;
			}
		}

		// System.out.println("start: " + start + "\tend: " +  end + "\tmax: " +  max);
		return max;
	}
}
