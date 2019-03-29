import java.util.*;

public class studentsmall{
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

			// int split = (int)Math.ceil((double)s/n);
			if(s%n == 0)
				split = s/n;
			else
				split = s/n + 1;

			int ans = min - split;

			System.out.println(ans);

		}
	}
}