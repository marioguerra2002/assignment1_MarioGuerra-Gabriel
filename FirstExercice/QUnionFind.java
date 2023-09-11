package FirstExercice;
import Cronos.Crono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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

        QUnionFind First = new QUnionFind(10000);
        Random rand = new Random();
        double avg = 0;
        ArrayList<Double> ListAvg = new ArrayList<>();
        Crono Average = new Crono();
        //preguntar sobre si las comprobaciones pueden afectar al tiempo de ejecución de forma significativa


        for(int j = 0;j<5000;j = j+100) {
            for (int i = 0; i < j; i++) {
                int Num1 = rand.nextInt(First.list.length); //random positions inside array
                int Num2 = rand.nextInt(First.list.length);
                if (Num1 != Num2) {
                    Average.StartTimer();
                    First.union(Num1, Num2);
                    Average.StopTimer();
                    avg += Average.TimeInSecond();
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
