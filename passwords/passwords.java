import java.util.*;

public class passwords{
	public static int count;

	public static void main(String[] args){
		
		//read in num cases
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		//run thru cases
		for(int i = 0; i < n; i++){
			
			//get length of pass
			int l = in.nextInt();

			//read in possible chars per slot, finding max len
			int max = 0;
			ArrayList<String> choices = new ArrayList<String>();
			for(int j = 0; j < l; j++){
				choices.add(in.next());
				if(choices.get(j).length() > max){
					max = choices.get(j).length();
				}		
			}

			//init used array
			Boolean[][] used = new Boolean[l][max];
			for(int j = 0; j < l; j++){
				Arrays.fill(used[j],false);
			}

			//rank to print out. aka perm
			int rank = in.nextInt();	

			//pass pas to build and perm
			char[] pas = new char[l];
			count = 0;
			perm(pas,used,choices,0, rank);
		}
	}

	public static void perm(char[] pas, Boolean[][] used, ArrayList<String> choices, int k,  int rank){
		
		//somehow we went too far
		if (count >= rank)
			return;

		//if we filled out a pas
		if (k == pas.length){
			count++;
			// System.out.println(count + " " + rank);
			
			//done, print
			if(count == rank){
				for(int i = 0; i < pas.length; i++){
					System.out.print(pas[i]);
				}
				System.out.println();
			}
			return;
		}

		//permute over the number of choices for the slot.
		for(int i = 0; i < choices.get(k).length(); i++){
			if(!used[k][i]){
				used[k][i] = true;
				pas[k] = choices.get(k).charAt(i);

				perm(pas,used,choices,k+1, rank);
				used[k][i] = false;
			}
		}
	}
}
