import java.util.*;

public class profits{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		while(n > 0){
			int[] days = new int[n];
			for(int i = 0; i < n; i++){
				days[i] = in.nextInt();
			}
			System.out.println(mcss3(days));

			n = in.nextInt();
		}

	}



	public static int mcss(int[] vals) {
		
		int max=(int) -1e9, start=0, end=0, sum=0;
		
		// All starting values.
		for (int i=0; i<vals.length; i++) {
			
			// All ending values.
			for (int j=i; j<vals.length; j++) {
			
				sum =0;
				// Add up everything in between.
				for (int k=i; k<=j; k++)
					sum += vals[k];
			
				// Update if we find something better.
				if (sum > max) {
					max = sum;
					start = i;
					end = j;
				
				}
			}
		}
		return max;
	}

	public static int mcss2(int[] vals) {
		
		int max=(int)-1e9, start=0, end=0, sum=0;
		
		// Loop through all start points.
		for (int i=0; i<vals.length; i++) {
			sum = 0;
			
			// And all end points.
			for (int j=i; j<vals.length; j++) {
				
				// Just add the current value to the running sum to obtain
				// this new sum.
				sum += vals[j];
			
				// Update if we get a better max.
				if (sum > max) {
					max = sum;
					start = i;
					end = j;
				
				}
			}
		}
		return max;
	}

	public static int mcss3(int[] vals) {
	
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