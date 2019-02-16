import java.util.*;

public class anya{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		boolean pal, charPal;

		for(int i=0; i<n; i++){
			int pals = 0;
			String s = in.nextLine();
			String[] w = s.split(" ");

			for(int j=0; j<w.length; j++){
				//System.out.println(w[j]);
				if(w[j].length() < 3)
					continue;

				pal = true;
				for(int k = 0; k < w[j].length(); k++){
					if(w[j].charAt(k) != w[j].charAt(w[j].length()-(1 + k))){
						pal = false;
						break;
					}
				}

				if(pal)
					pals++;
			}

			charPal = true;
			s = s.replaceAll("\\s", "");
			for(int k = 0; k < s.length(); k++){
				if(s.charAt(k) != s.charAt(s.length()-(1 + k))){
					charPal = false;
					break;
				}
			}


			System.out.println(pals >= 2 || charPal? "Ay" : "Nap");
		}


	}

}