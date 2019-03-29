import java.util.*;

public class outofsync{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		for(int i = 0; i < c; i++){
			int n = in.nextInt();
			long r = in.nextInt();
			HashMap<Long,Integer> bad = new HashMap<Long,Integer>();

			long ans = 0;
			ArrayList<pair> fact = primeFactorize(n);
			ArrayList<Integer> prime = new ArrayList<Integer>();

			// long mult = 1;
			// int num = 2;
			// while(mult <= r){
			// 	boolean doit = true;

				

			// 	if(doit){
			// 		for(int j = 0; j < fact.size(); j++){
			// 			if (fact.get(j).prime == num){
			// 				doit = false;
			// 				break;
			// 			}
			// 		}
			// 	}

			// 	num++;
			// }
			
			for(long j = 1; j <= r; j++){
				if(bad.containsKey(j))
					continue;

				boolean valid = true;
				for(int k = 0; k < fact.size(); k++){
					if(j % fact.get(k).prime == 0){
						valid = false;
						long p = fact.get(k).prime;
						long a = 2;
						while(a*p <= r){
							if(!bad.containsKey(a*p)){
								bad.put(a*p,0);
							}
							a++;
						}
						break;
					}
				}
				if(valid){
					ans++;

				}
			}

			System.out.println(ans);
		}
	}

	public static long gcd(long a, long b) {
		return b == 0? a: gcd(b,a%b);
	}

	public static ArrayList<pair> primeFactorize(int n){
		ArrayList<pair> res = new ArrayList<pair>();

		int div = 2;

		while(div*div <= n){
			int exp = 0;
			while(n%div == 0){
				n/= div;
				exp++;
			}

			if(exp > 0)
				res.add(new pair(div,exp));
			div++;
		}

		if(n>1) res.add(new pair(n,1));

		return res;
	}
}

class pair{
	public int prime;
	public int exp;

	public pair(int p, int e){
		prime = p;
		exp = e;
	}
}