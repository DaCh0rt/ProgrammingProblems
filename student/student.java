import java.util.*;

public class student{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in cases and run thru them
		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			//read in n, num contest locations and s, num students
			int n = in.nextInt();
			int s = in.nextInt();

			//read in caps of all the rooms, find min cap
			int[] caps = new int[n];
			int min = (int)2e9;
			for(int j = 0; j < n; j++){
				caps[j] = in.nextInt();
				if (caps[j] < min)
					min = caps[j];
			}

			//even out the capacity in all rooms relative to the min capacity
			for(int j = 0; j < n; j++){
				int dif = (caps[j] - min);
				caps[j] -= dif;
				s -= dif;
			}

			//if students left to distribute
			int split,ans;
			if(s > 0){
				//if even split num, else account for odd
				if(s%n == 0)
					split = s/n;
				else
					split = s/n + 1;
				ans = min - split;
			} else
				ans = min;

			System.out.println(ans);

		}
	}
}