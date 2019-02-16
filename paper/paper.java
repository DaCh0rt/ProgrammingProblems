import java.util.*;

public class paper{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nC = in.nextInt();

		for(int i = 0; i < nC; i++){
			int n = in.nextInt();

			int tCost = 0;
			for(int j = 0; j < n; j++){
				int students = in.nextInt();
				int pages = in.nextInt();

				if(pages % 4 != 0){
					tCost += ((pages/4) + 1) * students;
				} else {
					tCost += (pages/4) * students;
				}
			}

			System.out.println(tCost);
		}
	}
}