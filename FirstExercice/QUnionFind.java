package FirstExercice;

import Cronos.Crono;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


//authors: Mario Guerra
//authors: Gabriel Franco

public class QUnionFind {
    private final int [] list;

    public QUnionFind(int N){

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
    }

    public boolean Search(int [] list, int i, int n) {
        for (int j = 0; j < i; j++) {
            if (n == list[j]) {
                return true;
            }
        }
        return false;
    }

    public boolean connected(int a, int b){
        return list[a] == list[b];
    }

    public void union(int a, int b){
        int a_id = list[a];
        int b_id = list[b];

        for(int i = 0; i<list.length;i++){
            if (list[i] == a_id){
                list[i] = b_id;
            }
        }
    }

    public static void main(String[] args) {


        Random rand = new Random();
        int Num1;
        int Num2;
        ArrayList<Double> ListAvg = new ArrayList<>();
        Crono Average = new Crono();
        //preguntar sobre si las comprobaciones pueden afectar al tiempo de ejecución de forma significativa

        for(int i = 0;i<100;i = i+10) {
            double avg = 0;
            QUnionFind First = new QUnionFind(1000); // list of x random numbers
            for (int j = 0; j < i; j++) {
                Num1 = rand.nextInt(First.list.length); //random positions inside array
                Num2 = rand.nextInt(First.list.length);

                if (Num1 != Num2) {
                    if(!First.connected(Num1,Num2)){
                        Average.StartTimer();
                        First.union(Num1, Num2);
                        Average.StopTimer();
                        avg += Average.TimeInSecond();
                    }
                }
                else{
                    i = i-1;
                }
            }
            ListAvg.add(avg);
        }

        for(double average : ListAvg){
            System.out.println(average);
        }

    }
}
