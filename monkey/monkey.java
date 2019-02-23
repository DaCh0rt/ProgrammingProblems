import java.util.*;

public class monkey{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//get num cases and get rid of '\n' 
		int n = in.nextInt();
		in.nextLine();

		//run thru cases
		for(int i = 0; i < n; i++){
			//store string tree
			String s = in.nextLine();
			int tmp = 0;
			int max = 0;
			//loop thru tree and find max depth
			for(int j = 0; j < s.length(); j++){
				if(s.charAt(j) == '[')
					tmp++;
				else
					tmp--;

				if(tmp > max)
					max = tmp;
			}

			//finished you need 2 ^ max depth monkeys
			System.out.println((i + 1) + " " + (int)Math.pow(2,max));
		}
	}
}
