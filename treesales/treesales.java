import java.util.*;

public class treesales{
	public static HashMap<String,node> names = new HashMap<String,node>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int i = 0; i < t; i++){
			int n = in.nextInt();

			System.out.println("COMPANY " +  (i+1));
			in.next();
			in.next();
			String name = in.next();
			node company = new node(name);
			names.put(name, company);
			for(int j = 1; j < n; j++){
				String action = in.next();
				if(action.compareTo("ADD") == 0){
					String parent = in.next();
					String child = in.next();
					add(parent, child, company);
				} else if (action.compareTo("SALE") == 0){
					String parent = in.next();
					int sale = in.nextInt();
					sale(parent, sale, company);
				} else {
					String parent = in.next();
					query(parent, company);
				}
			}
		}
	}

	public static boolean add(String parent, String child, node tree){
		tree = names.get(parent);
		node tmp = new node(child);
		names.put(child, tmp);	
		tree.children.add(tmp);
		// if (tree.name.compareTo(parent) == 0){
		// 	node tmp = new node(child);

		// 	tree.children.add(tmp);

		// 	return true;
		// }

		// for(int i = 0; i < tree.children.size(); i++){
		// 	if(add(parent,child,tree.children.get(i))){
		// 		return true;
		// 	}
		// }

		return false;
	}

	public static boolean sale(String parent, int sale, node tree){
		tree = names.get(parent);
		tree.sales+= sale;
		// if(tree.name.compareTo(parent) == 0){
		// 	tree.sales += sale;
		// 	return true;
		// }

		// for(int i = 0; i < tree.children.size(); i++){
		// 	if(sale(parent,sale,tree.children.get(i))){
		// 		return true;
		// 	}
		// }

		return false;
	}

	public static boolean query(String parent, node tree){
		tree = names.get(parent);
		int tSales = sumSubTree(tree);
		System.out.println(tSales);
		// if(tree.name.compareTo(parent) == 0){
		// 	int tSales = sumSubTree(tree);
		// 	System.out.println(tSales);
		// 	return true;
		// }

		// for(int i = 0; i < tree.children.size(); i++){
		// 	if(query(parent,tree.children.get(i))){
		// 		return true;
		// 	}
		// }

		return false;
	}

	public static int sumSubTree(node tree){
		int sum = 0;

		if(tree.children.size() == 0){
			return tree.sales;
		}

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
		// names.put(n, this);
		name = n;
		sales = 0;
	}
}