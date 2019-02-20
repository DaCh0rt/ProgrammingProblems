import java.util.*;

public class balloons{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//read in num teams, balloons in room a, balloons in room b, also assume there is 1 test case
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

		int debug = 0;
		while (n != 0){//if terminating line 0 0 0 not reached (we have another test case)
			
			//read in teams and their needs
			ArrayList<team> teams = new ArrayList<team>();
			for (int i = 0; i < n; i++){
				int k = in.nextInt();
				int dA = in.nextInt();
				int dB = in.nextInt();
				teams.add(new team(k,dA,dB));
			}

			//greedy sort teams
			Collections.sort(teams);
			if(debug > 0){
				System.out.println(n + " " + a + " " + b);
				for(int i = 0; i < teams.size(); i++){
					System.out.println(teams.get(i));
				}
			}

			//run thru all the teams and take the ballons they need
			int distance = 0;
			for(int i = 0; i < teams.size(); i++){
				int numB = teams.get(i).nB;
				int distA = teams.get(i).dA;
				int distB = teams.get(i).dB;

				if(distA <= distB){
					if(a >= numB){
						distance += numB * distA;
						a -= numB;
						if (debug > 0) System.out.println("1took: " + numB + " * " + distA + " = " +  (numB * distA));
					} else {
						distance += a * distA;
						if (debug > 0) System.out.println("2took: " + a + " * " + distA + " = " +  (a * distA));
						numB -= a;
						a = 0;

						distance += numB * distB;
						if (debug > 0) System.out.println("3took: " + numB + " * " + distB + " = " +  (numB * distB));
						b -= numB;
					}
				} else{
					if(b >= numB){
						distance += numB * distB;
						b -= numB;
						if (debug > 0) System.out.println("4took: " + numB + " * " + distB + " = " +  (numB * distB));
					} else {
						distance += b * distB;
						if (debug > 0) System.out.println("5took: " + b + " * " + distB + " = " +  (b * distB));
						numB -= b;
						b = 0;

						distance += numB * distA;
						if (debug > 0) System.out.println("6took: " + numB + " * " + distA + " = " +  (numB * distA));
						a -= numB;
					}
				}
				if(debug > 0) System.out.println("cumulative :" + distance);
			}
			
			//we distributed the balloons, print out the result
			if (debug <= 0) System.out.println(distance);
			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
		}
	}
}

class team implements Comparable<team>{
	public int nB;
	public int dA;
	public int dB;

	public team(int numBalloons, int distA, int distB){
		nB = numBalloons;
		dA = distA;
		dB = distB;
	}

	public String toString(){
		return nB + " " + dA + " " + dB;
	}

	//greedy sort based on smallest difference between the distance of the two rooms for each team.
	public int compareTo(team other){
		return Math.abs(other.dA - other.dB) - Math.abs(this.dA - this.dB);
	}

}
