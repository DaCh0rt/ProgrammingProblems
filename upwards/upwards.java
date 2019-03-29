import java.util.*;

public class upwards{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean printed = false;

		for(int i = 0; i < n; i++){
			int[] frq = new int[26];

			String word = in.next();
			printed = false;
			//System.out.println(word);
			for(int j = 0; j < word.length(); j++){
				frq[word.charAt(j) - 'a']++;
				if(frq[word.charAt(j) - 'a'] > 1){
					System.out.println("NO");
					printed = true;
					break;
				}
			}

			for(int j =1; j < word.length(); j++){
				if(word.charAt(j) - word.charAt(j-1) < 0 && !printed){
					System.out.println("NO");
					printed = true;
					break;
				}
			}

			if(!printed)
				System.out.println("YES");
		}
	}
}