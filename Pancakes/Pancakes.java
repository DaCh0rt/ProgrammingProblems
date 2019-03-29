import java.util.*;

public class Pancakes{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int c = in.nextInt();

		for(int i = 0; i < c; i++){
			int n = in.nextInt();

			ArrayList<plate> plates = new ArrayList<plate>();
			int used = 0;
			for(int j = 0; j < n; j++){
				int a = in.nextInt();

				if(a == 0){
					plates.clear();
				} else {
					Collections.sort(plates);
					boolean placed = false;
					for(int k = 0; k < plates.size(); k++){
						if(plates.get(k).stack.peek() > a){
							plates.get(k).stack.push(a);
							placed = true;
							break;
						}
					}
					if(!placed){
						plates.add(new plate(a));
						used++;
					}
				}
			}

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