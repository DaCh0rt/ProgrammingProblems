import java.util.*;

public class sameletters{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in two strings.
		String s1 = in.next();
		String s2 = in.next();
		int i = 1;
		
		//go until terminal is reached
		while(s1.compareTo("END") != 0){
			
			//convert to char array and sort
			char[] str1 = s1.toCharArray();
			char[] str2 = s2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);

			//if different lengths, they are different, move on to next case
			if(str1.length != str2.length){
				System.out.println("Case " + i + ": different");
				i++;
				s1 = in.next();
				s2 = in.next();
				continue;
			}

			//converting back to string.
			s1 = "";
			s2 = "";
			for(int j = 0; j < str1.length; j++){
				s1 = s1 + str1[j];
				s2 = s2 + str2[j];
			}

			//seeing if same string
			if(s1.compareTo(s2) == 0){
				System.out.println("Case " + i + ": same");
			} else {
				System.out.println("Case " + i + ": different");
			}

			//prep next case
			i++;
			s1 = in.next();
			s2 = in.next();
		}
	}
}
