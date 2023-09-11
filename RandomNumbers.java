import FirstExercice.QUnionFind;

import java.util.Arrays;
import java.util.Random;

public class RandomNumbers {

    private final int[] list;

    RandomNumbers(int N){
        list = new int[N];
        int i = 0, n;
        Random Rand = new Random();
        while(i<list.length){
            n = Rand.nextInt(N);
            if(!Search(list,i,n)){
                list[i] = n;
                i++;
            }
        }

        for(int k = 0; k<list.length;k++){
            System.out.println(list[k]);
        }
    }



    public boolean Search(int [] list, int i, int n) {

        for (int j = 0; j < i; j++) {
            if (n == list[j]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    RandomNumbers num = new RandomNumbers(8);



    }
}
