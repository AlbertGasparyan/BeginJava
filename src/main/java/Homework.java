package main;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;

public class Homework {

    // Выбросить случайное целое число и сохранить в i
    public static int RandomNum (int min,int max) {
        int nums = (int) (Math.random() * ((max - min) + 1)) + min;
        return nums;
    }

    // Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    public static int SenBit(int i) {
        int LenBin = Integer.toBinaryString(i).length();
        return LenBin;
    }

    // Найти все кратные n числа большие i и сохранить в массив m1
    public static ArrayList<Integer> ArrayMult(int i,int n,int max){
        ArrayList<Integer> m1 = new ArrayList<Integer>();
        for (int j = i+1; j <= max; j++) {
            if(j%n==0){
                m1.add(j);
            }
        }
        return m1;
    }

    // Найти все некратные n числа меньшие i и сохранить в массив m2
    public static ArrayList<Integer> ArrayMult2 (int i,int n, int min){
        ArrayList<Integer> m2 = new ArrayList<Integer>();
        for (int j = i-1; j >=min ; j--) {
            if(j%n!=0){
                m2.add(j);
            }
        }
        return m2;
    }


    //Сохранить оба массива в файлы с именами m1 и m2 соответственно.
    public static void getArray(ArrayList<Integer> arr,String filename) {
        try{
            FileWriter writer = new FileWriter(filename);
            for (Integer c: arr){
                writer.write(c+"\t");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int min =1,max= 1000;
        int i = RandomNum(min,max);
        System.out.println(min+" and "+max+": i = "+i);
        int n = SenBit(i);
        System.out.println("n = "+ n);
        ArrayList<Integer> m1 = ArrayMult(i,n,max);
        ArrayList<Integer> m2 = ArrayMult2(i,n,min);
        getArray(m1,"m1.txt");
        getArray(m2,"m2.txt");

    }
}
