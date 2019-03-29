import java.util.*;

public class trip{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// System.out.println("what");

		for(int i = 0; i < n; i++){
			float a = in.nextFloat();
			float c = in.nextFloat();
			int na = in.nextInt();
			int nc = in.nextInt();

			System.out.println(String.format("%.2f",(a * na) + (c * nc)));
		}
	}
}