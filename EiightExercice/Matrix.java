package EiightExercice;


import FirstExercice.QUnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Matrix {
    private final int[][] Matrix;

    public Matrix(int N){
        Matrix = new int[N][N];
        int cont = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j < N; j++){
                Matrix[i][j] = cont;
                cont++;
            }
        }
    }

    public List<Integer>findAround(int[][] matrix, List<List<Integer>> open, List<Integer> coordenates){

        List<Integer> result = new ArrayList<>();
        List<Integer> aux1 = new ArrayList<>(Arrays.asList(coordenates.get(0) + 1, coordenates.get(1)));
        List<Integer> aux2 = new ArrayList<>(Arrays.asList(coordenates.get(0) - 1, coordenates.get(1)));
        List<Integer> aux3 = new ArrayList<>(Arrays.asList(coordenates.get(0), coordenates.get(1) - 1));
        List<Integer> aux4 = new ArrayList<>(Arrays.asList(coordenates.get(0), coordenates.get(1) + 1));

        if(open.contains(aux1)){
            result.add(matrix[aux1.get(0)][aux1.get(1)]);
        }
        if (open.contains(aux2)) {
            result.add(matrix[aux2.get(0)][aux2.get(1)]);
        }
        if (open.contains(aux3)) {
            result.add(matrix[aux3.get(0)][aux3.get(1)]);
        }
        if (open.contains(aux4)) {
            result.add(matrix[aux4.get(0)][aux4.get(1)]);
        }

        return result;

    }
    public boolean Percolate(QUnionFindEight connections, int Rows){

        for(int i = 0; i < Rows; i++){
            for(int j = connections.getList().length - Rows; j < connections.getList().length; j++){
                if(connections.connected(connections.getList()[i],connections.getList()[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Matrix m = new Matrix(5);
        QUnionFindEight connections = new QUnionFindEight(m.Matrix.length * m.Matrix.length);
        List<List<Integer>> openSquares = new ArrayList<>();
        int Num1;
        int Num2;
        float average = 0;
        Random nrand = new Random();

        for (int x=0; x < m.Matrix.length; x++) {
            System.out.print("|");
            for (int y=0; y < m.Matrix[x].length; y++) {
                System.out.print (m.Matrix[x][y]);
                if (y != m.Matrix[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }

        for(int i = 0; i < 100; i++){
            while(!m.Percolate(connections,m.Matrix.length)){
                Num1 = nrand.nextInt(m.Matrix.length);
                Num2 = nrand.nextInt(m.Matrix.length);
                List<Integer> aux = new ArrayList<>(Arrays.asList(Num1, Num2));

                if(!openSquares.contains(aux)){
                    openSquares.add(aux);
                    List<Integer> connects = m.findAround(m.Matrix,openSquares,aux);
                    for(int coordenates : connects){
                        connections.union(m.Matrix[Num1][Num2],coordenates);
                    }
                }

            }

            average += (float)openSquares.size()/(float)(m.Matrix.length * m.Matrix.length);
        }

        System.out.println(average/100.0);
    }
}
