import java.util.*;

public class board{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();

		//run thru cases
		for(int i = 0; i < c; i++){

			//tree is many-linked so store nodes in hashmap so we can lookup them instead of traversing
			HashMap<Integer,node> nodes = new HashMap<Integer,node>();

			//given number of nodes, pre make nodes for each since connections are not in order
			int n = in.nextInt();
			for(int j = 0; j < n; j++){
				node root = new node(0);
				nodes.put(j,root);
			}

			//fill in root val
			int p = in.nextInt();
			long con = in.nextLong();
			nodes.get(0).con = con;

			//fill in connections and values
			for(int j = 1; j < n; j++){
				p = in.nextInt();
				con = in.nextLong();

				nodes.get(p).children.add(nodes.get(j));
				nodes.get(j).con = con;
			}

			//tree built, recurse for answer
			System.out.println(traverse(nodes.get(0)));
		}
	}

	static long traverse(node root){

		//hit leaf node
		if (root.children.size() == 0){
			return root.con;
		}

		//sum all childern nodes vals
		long ans = 0;
		for(int i = 0; i < root.children.size(); i++){
			ans += traverse(root.children.get(i));
		}

		//take what is bigger, ans or your val
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