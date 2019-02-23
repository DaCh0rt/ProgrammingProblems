import java.util.*;

public class paper{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//read in num cases and run thru them
		int nC = in.nextInt();
		for(int i = 0; i < nC; i++){
			
			//read in num tests and calc cost for each.
			int n = in.nextInt();
			int tCost = 0;
			for(int j = 0; j < n; j++){
				int students = in.nextInt();
				int pages = in.nextInt();

				//booklet can hold 4 pages of content, find booklets per test * students
				if(pages % 4 != 0){
					tCost += ((pages/4) + 1) * students;
				} else {
					tCost += (pages/4) * students;
				}
			}

			//done
			System.out.println(tCost);
		}
	}
}
