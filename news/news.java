import java.util.*;

public class news{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//get num cases and run thru them
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			//store nodes in hashmap to save time by jumping to nodes we need
			HashMap<Integer,node> nodes = new HashMap<Integer,node>();

			//init tree
			node root = new node(0);
			nodes.put(0,root);

			//create tree
			int n = in.nextInt();
			for(int j = 0; j < n-1; j++){
				int c = in.nextInt();
				node child = new node(j+1);
				nodes.put((j+1),child);
				nodes.get(c).children.add(child);
			}

			//call rec. method to solve
			System.out.println(traverse(root));
		}
	}

	static int traverse(node root){
		ArrayList<Integer> ans = new ArrayList<Integer>();

		//no one to tell
		if (root.children.size() == 0){
			return 0;
		}

		//see how long all my children take
		for(int i = 0; i < root.children.size(); i++){
			ans.add(traverse(root.children.get(i)));
		}

		//reverse sort
		Collections.sort(ans);
		Collections.reverse(ans);

		//best way to call is to call the most expensive first, then find the limiting factor
		int a = 0;
		for(int i = 0; i < ans.size(); i++){
			a = Math.max(a,(i+1) + ans.get(i));
		}

		//done
		return a;
	}
}

class node{
	public ArrayList<node> children;
	public int e;

	public node(int e){
		children = new ArrayList<node>();
		this.e = e;
	}
}
