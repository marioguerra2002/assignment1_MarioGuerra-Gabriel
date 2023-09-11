package ThirdExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreeSum {
    private final int[] list;

    ThreeSum(int N) {
        list = new int[N];
        int i = 0, n;
        Random Rand = new Random();
        while(i<list.length){
            n = Rand.nextInt(N*2)-N;
            if(!Search(list,i,n)){
                list[i] = n;
                i++;
            }
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



    public static void main(String args[]){


    }

};
