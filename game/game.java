import java.util.*;

public class game{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();

		for(int i = 0; i < n; i++){
			int max = 0;
			int cur = 0;
			String input = in.nextLine();

			for(int j = 0; j < input.length(); j++){
				if(input.charAt(j) == 'v')
					cur++;
				else if(input.charAt(j) == '^')
					cur--;

				if(cur > max)
					max = cur;
			}

			System.out.println(max);
		}
	}
}