import java.util.*;

public class fact{
	public static boolean[] isPrime;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//read in num cases
		int nC = in.nextInt();
		
		//compute all the primes up to 7920 so we know them while running all the test cases
		primeSieve(7920);

		//solve each case
		for(int i = 0; i < nC; i++){
			//read in n which is n!
			int n = in.nextInt();

			//store ans as array list of prime factorization exponents
			ArrayList<Integer> ans = new ArrayList<Integer>();
			
			//iterate thru all prime numbers <= n
			for(int j = 2; j <= n; j++){
				if(isPrime[j]){
					int exp = 0;
					int pow = 1;

					//find how many numbers from the prime we are at to n the prime divides evenly into
					//and also all the powers of the prime up to n, essentially calculating all at once what the
					//prime exponent is in the final factorization.
					while((int)Math.pow(j,pow) <= n){
						int tot = 0;
						int div = (int)Math.pow(j,pow);
						for(int k = div; k <= n; k++){
							if(k%div == 0){
								tot++;
							}
						}
						// System.out.println("for j = " +  j + " and exp = " + exp + "there are " + tot + "nums divisible");
						pow++;
						exp += tot;
					}

					ans.add(exp);
				}
			}

			//we are done. print out the answer
			for(int j = 0; j < ans.size(); j++){
				System.out.print(ans.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void primeSieve(int n){
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime,true);
		isPrime[0] = false;
		isPrime[1] = false;

		for(int i = 2; i*i<=n; i++){
			for(int j = 2*i; j <= n; j+=i)
				isPrime[j] = false;
		}
	}
}

