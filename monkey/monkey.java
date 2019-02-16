import java.util.*;

public class monkey{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		for(int i = 0; i < n; i++){
			String s = in.nextLine();
			int tmp = 0;
			int max = 0;
			for(int j = 0; j < s.length(); j++){
				if(s.charAt(j) == '[')
					tmp++;
				else
					tmp--;

				if(tmp > max)
					max = tmp;
			}

			System.out.println((i + 1) + " " + (int)Math.pow(2,max));
		}
	}
}