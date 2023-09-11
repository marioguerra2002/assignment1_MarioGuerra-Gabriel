package SecondExercice;
import Cronos.Crono;
import java.util.Arrays;
import java.util.Random;


public class QuickUnionFind {

    private final int [] list;

    //si se generan numeros aleatorios, el root no va, ya que va asociado con el índice.
    public QuickUnionFind(int N){
        /*
        list = new int[n];
        for(int i = 0; i < n;++i){
            list[i] = i;
        }
        */

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
        return root(a) == root (b);
    }

    public void union(int a, int b){
            int ra = root(a);
            int rb = root(b);
            list[ra] = rb;
    }

    public int root(int a){

        while(a != list[a]){
            a = list[a];
        }
        return a;
    }

    public static void main(String args[]){

        QuickUnionFind First = new QuickUnionFind(10);
        Crono timo = new Crono();
    }

}


