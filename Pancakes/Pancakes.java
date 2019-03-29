import java.util.*;

public class Pancakes{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read num cases, run thru them
		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			int n = in.nextInt();

			//run thru the list of pancakes
			ArrayList<plate> plates = new ArrayList<plate>();
			int used = 0;
			for(int j = 0; j < n; j++){

				//get pancake
				int a = in.nextInt();

				//0 marks empty all current plates and start fresh
				if(a == 0){
					plates.clear();
				} else {

					//else sort the plates by the size of the top and put the pancake on the first avail plate
					Collections.sort(plates);
					boolean placed = false;
					for(int k = 0; k < plates.size(); k++){
						if(plates.get(k).stack.peek() > a){
							plates.get(k).stack.push(a);
							placed = true;
							break;
						}
					}

					//cant place, make a new plate and mark
					if(!placed){
						plates.add(new plate(a));
						used++;
					}
				}
			}

			//done, print how many we used
			System.out.println(used);
		}
	}
}

class plate implements Comparable<plate>{
	public ArrayDeque<Integer> stack;

	public plate(int p){
		stack = new ArrayDeque();
		stack.push(p);
	}

	public int compareTo(plate o){
		return this.stack.peek() - o.stack.peek();
	}
}