import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sum3_upperbound {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in); // Create a Scanner object
    String entry_individual; // Read user input
    ArrayList<String> all_numbers = new ArrayList<>();
    System.out.println("Introduce the numbers");
    while (true) {
      entry_individual = scan.nextLine(); // Read user input
      if (entry_individual.isEmpty()) { // If the user input is empty (no more numbers), stop
        break;
      }
      all_numbers.add(entry_individual);
    }
    ArrayList<Integer> list = new ArrayList<>();
    list = convertToInt(all_numbers); // Convert the array of strings to an array of integers
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    result = Sum3UpperBound(list);
    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
    }
    scan.close();
  }
  public static ArrayList<ArrayList<Integer>> Sum3UpperBound (ArrayList<Integer> list) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    return result;
  }
  public static ArrayList<Integer> convertToInt (ArrayList<String> all_numbers) {
    ArrayList<Integer> list = new ArrayList<>();
    for (String numbers : all_numbers) {  // other way to do a for
      list.add(Integer.parseInt(numbers));
    }
    return list;
  }
}