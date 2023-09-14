package FifthExercice;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Collections;


public class ThreeSum {

    private final int[] list;

    public ThreeSum(int N){
        list = new int[N];
        int i = 0, n;
        Random Rand = new Random();
        while(i<list.length){
            n = Rand.nextInt(2*N)-N;
            if(!Search(list,i,n)){
                list[i] = n;
                i++;
            }
        }
        // -5 4 1 10 3 -7 3 -9
    }
    public boolean Search(int [] list, int i, int n) {
        for (int j = 0; j < i; j++) {
            if (n == list[j]) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> SumOf3 (int[] list) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                for (int k = j; k < list.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (list[i] + list[j] + list[k] == 0) {
                            result.add(Arrays.asList(list[i], list[j], list[k]));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ThreeSum NewTry = new ThreeSum(10);
        List<List<Integer>> Result = new ArrayList<>();
        Result = SumOf3(NewTry.list);
        for(int i=0; i< NewTry.list.length;i++){
            System.out.println(NewTry.list[i]);
        }
        System.out.println("//////");
        for (int i = 0; i < Result.size(); i++) {
            System.out.println(Result.get(i));
        }
    }

}
