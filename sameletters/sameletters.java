import java.util.*;

public class sameletters{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		String s1 = in.next();
		String s2 = in.next();
		int i = 1;
		while(s1.compareTo("END") != 0){
			char[] str1 = s1.toCharArray();
			char[] str2 = s2.toCharArray();

			Arrays.sort(str1);
			Arrays.sort(str2);

			if(str1.length != str2.length){
				System.out.println("Case " + i + ": different");
				i++;
				s1 = in.next();
				s2 = in.next();
				continue;
			}

			s1 = "";
			s2 = "";
			for(int j = 0; j < str1.length; j++){
				s1 = s1 + str1[j];
				s2 = s2 + str2[j];
			}

			if(s1.compareTo(s2) == 0){
				System.out.println("Case " + i + ": same");
			} else {
				System.out.println("Case " + i + ": different");
			}

			i++;
			s1 = in.next();
			s2 = in.next();
		}
	}
}