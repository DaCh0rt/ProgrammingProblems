import java.util.*;

public class triathlon{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		//read in numcases, run thru them
		int k = in.nextInt();
		for(int i = 0; i < k; i++){

			//read in num competitors
			int c = in.nextInt();

			//init arraylist of people
			ArrayList<person> peeps = new ArrayList<person>();

			//read in distance for the 3 events
			float[] events = new float[3];
			for(int j = 0; j < 3; j++){
				events[j] = in.nextFloat();
			}

			//read in all people
			for(int j = 0; j < c; j++){

				//add their first and last name and age
				peeps.add(new person(in.next(), in.next(), in.nextInt()));

				//read in their rates for each event and add the calculated time to complete each event
				for(int z = 0; z < 3; z++){
					peeps.get(peeps.size()-1).time += (events[z] / in.nextFloat());
				}
			}

			//sort peeps based on time then age then last then first
			Collections.sort(peeps);

			//print out scoreboard
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