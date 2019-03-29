import java.util.*;

public class triathlon{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();

		for(int i = 0; i < k; i++){
			int c = in.nextInt();

			ArrayList<person> peeps = new ArrayList<person>();

			float[] events = new float[3];
			for(int j = 0; j < 3; j++){
				events[j] = in.nextFloat();
			}

			for(int j = 0; j < c; j++){
				peeps.add(new person(in.next(), in.next(), in.nextInt()));
				for(int z = 0; z < 3; z++){
					peeps.get(peeps.size()-1).time += (events[z] / in.nextFloat());
				}
			}

			Collections.sort(peeps);

			System.out.println("Race " + (i + 1) + ":");
			for(int j = 0; j < peeps.size(); j++){
				System.out.printf("%s %s %.3f\n", peeps.get(j).fName, peeps.get(j).lName, peeps.get(j).time);
			}

			System.out.println();
		}
	}
}

class person implements Comparable<person>{
	public String fName;
	public String lName;
	public float time;
	public int age;

	public person(String fn, String ln, int a){
		fName = fn;
		lName = ln;
		time = 0;
		age = a;
	}

	public int compareTo(person other){
		if(Float.compare(this.time,other.time) != 0){
			return Float.compare(this.time,other.time);
		} else if(this.age != other.age) {
			return this.age - other.age;
		}else if(this.lName.compareTo(other.lName) != 0){
			return this.lName.compareTo(other.lName);
		} else {
			return this.fName.compareTo(other.fName);
		}
	}
}