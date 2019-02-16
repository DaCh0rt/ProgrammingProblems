import java.util.*;

public class fruit{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nC = in.nextInt();
		boolean solved;

		for(int i = 0; i < nC; i++){
			int n = in.nextInt();
			int[] days = new int[n];
			for(int j = 0; j < n; j++){
				days[j] = in.nextInt();
			}

			solved = false;
			for(int j = 0;; j++){
				int total = 0;
				int max = 0;
				for(int k = 0; k < n; k++){
					total += j;
					if(total - days[k] < 0)
						break;

					total -= days[k];
					max = Math.max(total, max);

					if(k == n -1)
						solved = true;
				}

				if(solved){
					System.out.println(j + " " + max);
					break;
				}			
			}
		}
	}
}