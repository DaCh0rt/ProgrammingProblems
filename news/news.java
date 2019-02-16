import java.util.*;

public class news{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for(int i = 0; i < t; i++){
			HashMap<Integer,node> nodes = new HashMap<Integer,node>();

			node root = new node(0);
			nodes.put(0,root);

			int n = in.nextInt();
			for(int j = 0; j < n-1; j++){
				int c = in.nextInt();
				node child = new node(j+1);
				nodes.put((j+1),child);
				nodes.get(c).children.add(child);
			}

			System.out.println(traverse(root));
		}
	}

	static int traverse(node root){
		ArrayList<Integer> ans = new ArrayList<Integer>();

		if (root.children.size() == 0){
			return 0;
		}

		for(int i = 0; i < root.children.size(); i++){
			ans.add(traverse(root.children.get(i)));
		}

		Collections.sort(ans);
		Collections.reverse(ans);

		int a = 0;
		for(int i = 0; i < ans.size(); i++){
			a = Math.max(a,(i+1) + ans.get(i));
		}

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