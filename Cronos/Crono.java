package Cronos;

import java.util.function.Function;
import java.util.function.Supplier;

public class Crono {
    private double StartTime;
    private double FinalTime;


    public void StartTimer(){
        StartTime = System.nanoTime();
    }
    public void StopTimer(){
        FinalTime = System.nanoTime();
    }
    public double TimeInNano(){
        return (FinalTime-StartTime);
    }

    public double TimeInSecond(){
        return ((FinalTime-StartTime)/1e9);

    }

    public double TimeInMiliseconds(){
        return ((FinalTime-StartTime)/1000000);
    }

/*
    public static <T, R> long Timering(Supplier<T> instanceSupplier, Function<T, R> function){

        long startTime = System.currentTimeMillis();
        T instance = instanceSupplier.get();
        R result = function.apply(instance);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        return elapsedTime;
    }
    */

}
