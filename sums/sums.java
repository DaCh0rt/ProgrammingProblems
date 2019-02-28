import java.util.*;

public class sums{
	public static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int sum = 0;
			for(int j = 1; j <= n; j++){
				sum += j * tri(j+1);
			}

			System.out.println((i + 1) + " " + n + " " + sum);
		}
	}

	static int tri(int n){
		if(n == 1){
			return 1;
		}

		if(map.containsKey(n)){
			return map.get(n);
		} else {
			map.put(n, n + tri(n-1));
			return map.get(n);
		}
	}
}