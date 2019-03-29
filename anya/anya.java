// problem for the class that was meant to be a easy warm up to get used to the online judge.
// cannot find pdf or test data for it

import java.util.*;

public class anya{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in num cases
		int n = in.nextInt();
		in.nextLine();

		//run thru cases
		for(int i=0; i<n; i++){
			int pals = 0;

			//read and split line into words
			String s = in.nextLine();
			String[] w = s.split(" ");

			//run thru words
			for(int j=0; j<w.length; j++){

				//only could pals of length 3 or more so if less, skip this word.
				if(w[j].length() < 3)
					continue;

				//check the word
				boolean pal = true;
				for(int k = 0; k < w[j].length()/2; k++){
					//check both ends
					if(w[j].charAt(k) != w[j].charAt(w[j].length()-(1 + k))){
						pal = false;
						break;
					}
				}

				//count it
				if(pal)
					pals++;
			}

			//check if the whole sentence is a pal
			boolean charPal = true;
			s = s.replaceAll("\\s", "");
			for(int k = 0; k < s.length()/2; k++){

				//check both ends
				if(s.charAt(k) != s.charAt(s.length()-(1 + k))){
					charPal = false;
					break;
				}
			}

			//done processing, print
			System.out.println(pals >= 2 || charPal? "Ay" : "Nap");
		}


	}

}