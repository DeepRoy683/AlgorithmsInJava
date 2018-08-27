package backtrackingAlgorithmsInJava;

import java.util.ArrayList;

public class Davis_Staircase {
	/*
	 * stores the number of steps to be taken 
	 */
	int[] stairsMatrix;
	/*
	 * stores the steps pattern 
	 */
	ArrayList<Integer> patternSteps;
	
	/*
	 * indexes the patternSteps ArrayList
	 */
	int index=-1;
	void stepsPerm(int n) {
		
		
		for(int i : stairsMatrix) {
			if(n<i) {
				return;
			}
			if(n == i)
			{	index++;
				patternSteps.add(i);
				System.out.println(patternSteps);
				patternSteps.remove(index);
				index--;
			return;
			}
			if(n>i) {
				index++;
				patternSteps.add(i);
				stepsPerm(n-i);
				
			}
			patternSteps.remove(index);
			index--;
		}
	}
	public static void main(String[] args) {
		Davis_Staircase n = new Davis_Staircase();
		n.stairsMatrix = new int[] {1, 2, 3};
		n.patternSteps = new ArrayList<Integer>();
		n.stepsPerm(7);
	}

}
