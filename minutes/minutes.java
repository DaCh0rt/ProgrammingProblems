import java.util.*;

public class minutes{
	public static void main(String[] args){
		//num cases, days, hours, minutes
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d,h,m,total;

		//go thru all cases
		for(int i = 0; i < n; i++){
			d = in.nextInt();
			h = in.nextInt();
			m = in.nextInt();

			//quik mafs
			total = m + h*60 + d*60*24;
			System.out.println(total);
		}
	}
}
