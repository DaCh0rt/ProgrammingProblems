import java.util.*;

public class outofsync{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		//run thru cases
		for(int i = 0; i < c; i++){

			//read in n, number, and r, range
			int n = in.nextInt();
			long r = in.nextInt();

			//init ans, prime factorize n, init prime list, init hashmap for bad values
			long ans = 0;
			ArrayList<pair> fact = primeFactorize(n);
			ArrayList<Integer> prime = new ArrayList<Integer>();
			HashMap<Long,Integer> bad = new HashMap<Long,Integer>();
			
			//go thru range
			for(long j = 1; j <= r; j++){
				if(bad.containsKey(j))
					continue;

				//assume valid, go thru prime factors of n
				boolean valid = true;
				for(int k = 0; k < fact.size(); k++){

					//if prime a factor of j
					if(j % fact.get(k).prime == 0){

						//fail, get prime
						valid = false;
						long p = fact.get(k).prime;
						long a = 2;

						//run thru multiples of p that are less than or equal to r
						while(a*p <= r){

							//if not already set to bad, set bad
							if(!bad.containsKey(a*p)){
								bad.put(a*p,0);
							}
							a++;
						}
						break;
					}
				}

				//number in range made it. add to ans.
				if(valid){
					ans++;

				}
			}

			//done, print ans.
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