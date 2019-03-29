import java.util.*;

public class trip{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases and run thru them
		int n = in.nextInt();
		for(int i = 0; i < n; i++){

			//read a, adult ticket price, c, child ticket price, and number of each
			float a = in.nextFloat();
			float c = in.nextFloat();
			int na = in.nextInt();
			int nc = in.nextInt();

			//print out weighted sum of a and c
			System.out.println(String.format("%.2f",(a * na) + (c * nc)));
		}
	}
}