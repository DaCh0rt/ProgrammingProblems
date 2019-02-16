import java.util.*;

public class fact{
	public static boolean[] isPrime;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int nC = in.nextInt();

		primeSieve(7920);

		for(int i = 0; i < nC; i++){
			int n = in.nextInt();

			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int j = 2; j <= n; j++){
				if(isPrime[j]){
					int exp = 0;
					int pow = 1;

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

