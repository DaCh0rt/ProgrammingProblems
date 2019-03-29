import java.util.*;

public class outofsyncsmall{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		for(int i = 0; i < c; i++){
			int n = in.nextInt();
			int r = in.nextInt();

			int ans = 0;
			for (int j = 1; j <= r; j++){
				if(gcd(n,j) == 1)
					ans++;
			}

			System.out.println(ans);
		}
	}

	public static long gcd(long a, long b) {
		return b == 0? a: gcd(b,a%b);
	}
}