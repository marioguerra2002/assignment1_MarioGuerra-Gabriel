package SecondExercice;
import Cronos.Crono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickUnionFind {

    private final int [] list;

    //si se generan numeros aleatorios, el root no va, ya que va asociado con el índice.
    public QuickUnionFind(int N){
        list = new int[N];
        for(int i = 0; i < N;++i){
            list[i] = i;
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
    // if they are already connected, it doesn't do again the union (avoid bucles)
    public boolean connected(int a, int b){
        return root(a) == root (b);
    }

    public void union(int a, int b){
        int ra = root(a);
        int rb = root(b);
        list[ra] = rb;
    }
    public int root(int a){  // look for the root
        while(a != list[a]){
            a = list[a];
        }
        return a;
    }

    public static void main(String args[]){

        // this is exponential because it has to run over the list each time longer, given that you see
        // the father and his first child, so for example if we have 10 elements, that would be something like
        // 1->2->3.... So if the algorithm wants to connect 3 with 6, it has to go over first child of 3, that's
        // connected to another irst child...
        Random rand = new Random();
        int Num1;
        int Num2;
        double avg = 0;
        ArrayList<Double> ListAvg = new ArrayList<>();
        Crono Average = new Crono();


        for(int i = 0; i < 100000;i+= 20000) { // make the x number of union
            avg = 0;
            QuickUnionFind First = new QuickUnionFind(100000);
            for (int j = 0; j < i; j++) {

                Num1 = rand.nextInt(First.list.length);
                Num2 = rand.nextInt(First.list.length);

                if (Num1 != Num2) {
                    if (!First.connected(Num1, Num2)) { // if they are already connected, skip
                        Average.StartTimer(); // calculate the time of process the union
                        First.union(Num1, Num2);
                        Average.StopTimer();
                        avg += Average.TimeInMiliseconds();
                    }
                }
                else{
                    i -= 1;
                }
            }
            ListAvg.add(avg); // when already cover j iteration, save avg with the item of x.
        }


        for(double average : ListAvg){
            System.out.println(average);
        }



    }

}


