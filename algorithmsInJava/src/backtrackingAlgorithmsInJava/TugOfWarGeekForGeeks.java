package backtrackingAlgorithmsInJava;
import java.util.*;
public class TugOfWarGeekForGeeks {

	public static int diff = Integer.MAX_VALUE;
    public static Stack<Integer> solution = new  Stack<Integer>();
    
    public static void main(String args[]) {
      int[] A = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}; 
      
      Stack<Integer> set = new  Stack<Integer>();
      minDiffSubset(A, set, A.length);
      ArrayList<Integer> parentList = new ArrayList<Integer>();
      Arrays.stream(A).forEach(n -> parentList.add(n));
      ArrayList<Integer> set1 = new ArrayList<Integer>(Arrays.asList(solution.toArray(new Integer[0])));
      System.out.print("The first set is: ");
      set1.stream().forEach(n -> System.out.print(n+" , "));
      System.out.println();
      set1.stream().forEach(n -> parentList.remove(n));
      System.out.print("The second  set is: ");
      parentList.stream().forEach(n -> System.out.print(n+" , "));
                    
    }
    
    public static void minDiffSubset(int[] A, Stack<Integer> set, int N){
        
        if(N == 0){
            return;
        }
        
        if(set.size() == A.length/2){
           
            int sumOfElementsInStack = set.stream().mapToInt(num -> num).sum();
            int sumOfElementsInArray = Arrays.stream(A).sum();
            if(Math.abs(2*sumOfElementsInStack - sumOfElementsInArray) < diff){
                 solution = (Stack<Integer>)set.clone();
                 diff = Math.abs(2*sumOfElementsInStack - sumOfElementsInArray);
                 return;
            }
        }
        
        set.push(A[N-1]);
        minDiffSubset(A, set, N-1);
        set.pop();
        minDiffSubset(A, set, N-1);
        
    }
}
