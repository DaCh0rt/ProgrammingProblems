import java.util.*;

public class hexagon{
	public static int[][] hexagons = new int[7][6];
	public static boolean printed = false;

	public static void main(String[] args){
		//read in num cases
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();

		//run thru cases
		for(int i = 0; i<n;i++){
			
			//read in the tiles for each puzzle
			for(int j = 0; j < 7; j++){
				for(int k = 0; k < 6; k++){
					hexagons[j][k] = fin.nextInt();
				}
			}
			
			//start output
			System.out.print("Case " + (i+1) + ": ");

			// print(hexagons[0]);
			// rotate(0,1);
			// print(hexagons[0]);
			// rotate(0,1);
			// print(hexagons[0]);

			printed = false;
			//call perms to permute all possilbe arrangement of tiles and solve in there
			perms(new int[7], new boolean[7], 0);

			if(!printed)
				System.out.println("No solution");	

		}
	}

	public static void rotate(int hexagon, int rotateAmount){
		//rotate hexagon by shifting the numbers in the array right and backfilling
		int[] tmp = new int[6];
		for(int i = 0; i < hexagons[hexagon].length; i++){
			tmp[i] = hexagons[hexagon][i];
		}

		int j = 0;
		for(int i = rotateAmount; i < hexagons[hexagon].length; i++){
			hexagons[hexagon][i] = tmp[j];
			j++;
		}

		for(int i = 0; i < rotateAmount; i++){
			hexagons[hexagon][i] = tmp[j];
			j++;
		}
	}

	public static int findIndex(int[] hexagon, int num){
		//find the index of a number in a hexagon
		for(int i = 0; i < hexagon.length; i++){
			if(hexagon[i] == num)
				return i;
		}
		return -1;
	}

	public static void perms(int[] perm, boolean[] used, int k) {
    		if(printed)
    			return;

    		// Filled out a permutation.
    		if (k == perm.length){
			// check if we can solve the puzzle with this arrangement
    			if(checkPerm(perm)){
    				print(perm);
    				printed = true;
   	 		}
    		}
	
		// Try each unused item in slot k.
    		for (int i=0; i<perm.length; i++) {
        		if (!used[i]) {
        		
        			// Mark it and put it in.
            			used[i] = true;
           			perm[k] = i;
           		
           			// Recurse.
           		 	perms(perm, used, k+1);
            	
            			// Must unmark...
            			used[i] = false;
        		}
    		}
	}

	public static boolean checkPerm(int[] perm){
		//start with middle piece and rotate to have 0 on top
		rotate(perm[0], (6 - findIndex(hexagons[perm[0]], 1))%6);

		//put top piece on and rotate to match 0's
		rotate(perm[1], ((9 - findIndex(hexagons[perm[1]], hexagons[perm[0]][0]))%6));

		//put next piece down going clockwise. match the edge it has with previous, check edge it has with center
		rotate(perm[2], ((11 - findIndex(hexagons[perm[2]], hexagons[perm[1]][2]))%6));
		if(hexagons[perm[0]][1] != hexagons[perm[2]][4]){
			// System.out.print("failed rot 2\t");
			// print(perm);
			return false;
		}

		//put next piece down going clockwise. match the edge it has with previous, check edge it has with center
		rotate(perm[3], ((6 - findIndex(hexagons[perm[3]], hexagons[perm[2]][3]))%6));
		if(hexagons[perm[0]][2] != hexagons[perm[3]][5]){
			// System.out.print("failed rot 3\t");
			// print(perm);
			return false;
		}

		//put next piece down going clockwise. match the edge it has with previous, check edge it has with center
		rotate(perm[4], ((7 - findIndex(hexagons[perm[4]], hexagons[perm[3]][4]))%6));
		if(hexagons[perm[0]][3] != hexagons[perm[4]][0]){
			// System.out.print("failed rot 4\t");
			// print(perm);
			return false;
		}

		//put next piece down going clockwise. match the edge it has with previous, check edge it has with center
		rotate(perm[5], ((8 - findIndex(hexagons[perm[5]], hexagons[perm[4]][5]))%6));
		if(hexagons[perm[0]][4] != hexagons[perm[5]][1]){
			// System.out.print("failed rot 5\t");
			// print(perm);
			return false;
		}

		//put next piece down going clockwise. match the edge it has with previous, check edge it has with center
		rotate(perm[6], ((9 - findIndex(hexagons[perm[6]], hexagons[perm[5]][0]))%6));
		if(hexagons[perm[0]][5] != hexagons[perm[6]][2]){
			// System.out.print("failed rot 6\t");
			// print(perm);
			return false;
		}
		//check the edge the last piece shares with the topmost
		if(hexagons[perm[6]][1] != hexagons[perm[1]][4]){
			// System.out.print("failed final\t");
			// print(perm);
			return false;
		}

		return true;			
	}

	public static void print(int[] perm){
		for(int i = 0; i < perm.length; i++){
   			System.out.print(perm[i] + " ");
   			}
   		System.out.println();
	}
}
