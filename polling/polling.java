import java.util.*;

public class polling{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int max = 0;

		HashMap<String, Integer> election = new HashMap<String, Integer>();

		for(int i = 0; i < n; i++){
			String person = in.next();

			if(election.containsKey(person)){
				election.put(person, (election.get(person) + 1));
			} else {
				election.put(person, 1);
			}
		}

		ArrayList<person> result = new ArrayList<person>();
		for(String name: election.keySet()){
			result.add(new person(name, election.get(name)));
		}

		Collections.sort(result);
		int winning = result.get(0).votes;
		for (int i=0; i<result.size(); i++){
			if(result.get(i).votes < winning)
				break;
			System.out.println(result.get(i));
		}

	}
}

class person implements Comparable<person>{
	private String name;
	public int votes;

	public person(String n, int v){
		name = n;
		votes = v;
	}

	public String toString(){
		return name;
	}

	public int compareTo(person other){
		if(this.votes != other.votes){
			return other.votes - this.votes;
		} else {
			return this.name.compareTo(other.name);
		}
	}
}