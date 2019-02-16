import java.util.*;

public class passwords{
	public static int count;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for(int i = 0; i < n; i++){
			int l = in.nextInt();

			int max = 0;
			ArrayList<String> choices = new ArrayList<String>();
			for(int j = 0; j < l; j++){
				choices.add(in.next());
				if(choices.get(j).length() > max){
					max = choices.get(j).length();
				}		
			}

			Boolean[][] used = new Boolean[l][max];
			for(int j = 0; j < l; j++){
				Arrays.fill(used[j],false);
			}

			// ArrayList<Boolean>[] used = new ArrayList[l];
			// // System.out.println(l);
			// for(int j = 0; j < l; j++){
			// 	for(int k = 0; k < choices.size(); k++){
			// 		used[j].add(false);
			// 	}
			// }

			int rank = in.nextInt();	

			char[] pas = new char[l];
			count = 0;
			perm(pas,used,choices,0, rank);
			// perm(choices, used, 0, 0, pas, rank);
		}
	}

	public static void perm(char[] pas, Boolean[][] used, ArrayList<String> choices, int k,  int rank){
		
		if (count >= rank)
			return;

		if (k == pas.length){
			count++;
			// System.out.println(count + " " + rank);
			if(count == rank){
				for(int i = 0; i < pas.length; i++){
					System.out.print(pas[i]);
				}
				System.out.println();
			}
			return;
		}

		for(int i = 0; i < choices.get(k).length(); i++){
			if(!used[k][i]){
				// System.out.println("fak");
				used[k][i] = true;
				pas[k] = choices.get(k).charAt(i);

				perm(pas,used,choices,k+1, rank);
				used[k][i] = false;
			}
		}
	}

	// public static void perm(ArrayList<String> choices, Boolean[][] used, int count, int layer, char[] pas, int rank){
	// 	// if (count >= rank){
	// 	// 	System.out.println(pas);
	// 	// 	return;
	// 	// }

	// 	if (layer >= choices.size()){
	// 		System.out.println("this aint good chief");
	// 		return;
	// 	}


	// 	for(int i = 0; i < choices.get(layer).length(); i++){
	// 		if(!(used[layer][i])){
	// 			used[layer][i] = true;
	// 			pas[layer] = choices.get(layer).charAt(i);
	// 			perm(choices,used,count++,layer++,pas,rank);
	// 			System.out.println(pas);
	// 			used[layer][i] = false;
	// 		}

	// 	}
	// }
}