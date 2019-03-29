import java.util.*;

public class upwards{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			int[] frq = new int[26];

			String word = in.next();
			boolean printed = false;

			//check if letters are distinct by keeping freq array
			for(int j = 0; j < word.length(); j++){
				frq[word.charAt(j) - 'a']++;
				if(frq[word.charAt(j) - 'a'] > 1){
					System.out.println("NO");
					printed = true;
					break;
				}
			}

			//check if in alpha order
			for(int j =1; j < word.length(); j++){
				if(word.charAt(j) - word.charAt(j-1) < 0 && !printed){
					System.out.println("NO");
					printed = true;
					break;
				}
			}

			//if it made it, it passed
			if(!printed)
				System.out.println("YES");
		}
	}
}