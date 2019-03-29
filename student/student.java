import java.util.*;

public class student{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		for(int i = 0; i < c; i++){
			int n = in.nextInt();
			int s = in.nextInt();

			int[] caps = new int[n];
			int min = (int)2e9;
			for(int j = 0; j < n; j++){
				caps[j] = in.nextInt();
				if (caps[j] < min)
					min = caps[j];
			}

			for(int j = 0; j < n; j++){
				int dif = (caps[j] - min);
				caps[j] -= dif;
				s -= dif;
			}

			int split,ans;
			if(s > 0){
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