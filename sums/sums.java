import java.util.*;

public class sums{
	//storing answers for trianges in hashmap
	public static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

	public static void main(String[] args){
		
		//read in num cases and run thru them
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int i = 0; i < t; i++){
			
			//add up triangles using given formula
			int n = in.nextInt();
			int sum = 0;
			for(int j = 1; j <= n; j++){
				//start at base and figure out how big the next tri is. (subsequent runs we will know)
				sum += j * tri(j+1);
			}

			System.out.println((i + 1) + " " + n + " " + sum);
		}
	}

	static int tri(int n){
		//one dot is one, b.c.
		if(n == 1){
			return 1;
		}

		//if we have already done this one answer
		if(map.containsKey(n)){
			return map.get(n);
		} else {
			//otherwise recurse to a smaller triangle plus the new layer and that is the answer
			map.put(n, n + tri(n-1));
			return map.get(n);
		}
	}
}
