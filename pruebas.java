import java.util.ArrayList;
import java.util.Arrays;

public class pruebas {
  public static void main (String[] args) {
    ArrayList<Integer> prueba = new ArrayList<>();
    prueba.add(-4);
    prueba.add(3);
    prueba.add(1);
    prueba.add(2);
    for (int i = 0; i < prueba.size(); i++) {
      System.out.println(prueba.get(i));
    }
    System.out.println("////");
    for (int i = 0; i < prueba.size(); i++) {
      for (int j = i; j < prueba.size(); j++) {
        for (int k = j; k < prueba.size(); k++) {
          if (i !=j && i != k && j != k) {
            if (prueba.get(i) + prueba.get(j) + prueba.get(k) == 0) {
              System.out.println(prueba.get(i) + " " + prueba.get(j) + " " + prueba.get(k));
            }
          }
        }
      }
    }
  }
}
