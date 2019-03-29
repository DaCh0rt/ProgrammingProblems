import java.util.*;

public class companyboardsmall{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();

		for(int i = 0; i < c; i++){
			HashMap<Integer,node> nodes = new HashMap<Integer,node>();

			int n = in.nextInt();
			for(int j = 0; j < n; j++){
				node root = new node(0);
				nodes.put(j,root);
			}

			int p = in.nextInt();
			long con = in.nextLong();
			nodes.get(0).con = con;

			for(int j = 1; j < n; j++){
				p = in.nextInt();
				con = in.nextLong();

				nodes.get(p).children.add(child);
				nodes.get(j).con = con;
			}

			System.out.println(traverse(root));
		}
	}

	static long traverse(node root){
		if (root.children.size() == 0){
			return root.con;
		}

		long ans = 0;
		for(int i = 0; i < root.children.size(); i++){
			ans += traverse(root.children.get(i));
		}

		if(ans > root.con)
			return ans;
		else return root.con;
	}
}

class node{
	public ArrayList<node> children;
	public long con;

	public node(long con){
		children = new ArrayList<node>();
		this.con = con;
	}
}