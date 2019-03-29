import java.util.*;

public class treesales{
	public static HashMap<String,node> names = new HashMap<String,node>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in numcases and run thru them
		int t = in.nextInt();
		for(int i = 0; i < t; i++){

			//read n, num of operations to compute
			int n = in.nextInt();

			//start output, ignore ADD and ROOT because they are guranteed at the start of each case
			System.out.println("COMPANY " +  (i+1));
			in.next();
			in.next();

			//read root name and init tree, store in hashmap for later lookup
			String name = in.next();
			node company = new node(name);
			names.put(name, company);

			//run thru operations
			for(int j = 1; j < n; j++){
				String action = in.next();
				if(action.compareTo("ADD") == 0){

					//read add input and process
					String parent = in.next();
					String child = in.next();
					add(parent, child, company);
				} else if (action.compareTo("SALE") == 0){

					//read sale input and process
					String parent = in.next();
					int sale = in.nextInt();
					sale(parent, sale, company);
				} else {

					//read query input and process
					String parent = in.next();
					query(parent, company);
				}
			}
		}
	}

	public static void add(String parent, String child, node tree){

		//fetch parent node, make and add child and connect to parent.
		tree = names.get(parent);
		node tmp = new node(child);
		names.put(child, tmp);	
		tree.children.add(tmp);
	}

	public static void sale(String parent, int sale, node tree){

		//update node val
		tree = names.get(parent);
		tree.sales+= sale;
	}

	public static void query(String parent, node tree){

		//get node, recurse for ans
		tree = names.get(parent);
		int tSales = sumSubTree(tree);
		System.out.println(tSales);
	}

	public static int sumSubTree(node tree){
		int sum = 0;

		//leaf, return val
		if(tree.children.size() == 0){
			return tree.sales;
		}

		//add current node val and the vals of all children
		sum += tree.sales;
		for(int i = 0; i < tree.children.size(); i++){
			sum += sumSubTree(tree.children.get(i));
		}

		return sum;
	}


}

class node{
	public ArrayList<node> children = new ArrayList<node>();
	public String name;
	public int sales;

	public node(String n){
		name = n;
		sales = 0;
	}
}