import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exercise4 {
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
    result = SumOf3(list);
    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
    }
    scan.close();
    
  }
  public static ArrayList<ArrayList<Integer>> SumOf3 (ArrayList<Integer> list) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    // ArrayList<Integer> auxiliar = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      for (int j = i; j < list.size(); j++) {
        for (int k = j; k < list.size(); k++) {
          if (i != j && i != k && j != k) {
            if (list.get(i) + list.get(j) + list.get(k) == 0) {
              // System.out.println(list.get(i) + " " + list.get(j) + " " + list.get(k));
              ArrayList<Integer> auxiliar = new ArrayList<>(); // hay que optimizar esto porque no puede ser que haya que tener que declarar todo el rato un arraylist
              auxiliar.add(list.get(i));
              auxiliar.add(list.get(j));
              auxiliar.add(list.get(k));
              result.add(auxiliar); // add the arraylist to the arraylist of arraylists
              // auxiliar.clear(); // esto es lo que hace que no funcione
            }
          }
        }
      }
    }
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