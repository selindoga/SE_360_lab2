import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Program{
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        LinkedList<Integer> B = new LinkedList<Integer>();

        Random rand = new Random();

        for (int i = 0; i < 100000; i++) {
            A.add(rand.nextInt(9999));
            B.add(rand.nextInt(9999));
        }

        Collections.sort(A);
        Collections.sort(B);

        long startTime_ArrayList = System.nanoTime();
        Collections.binarySearch(A, -1);
        long endTime_ArrayList = System.nanoTime();
        System.out.println("ArrayList search time: " + (endTime_ArrayList - startTime_ArrayList));

        long startTime_LinkedList = System.nanoTime();
        Collections.binarySearch(B, -1);
        long endTime_LinkedList = System.nanoTime();
        System.out.println("LinkedList search time: " + (endTime_LinkedList - startTime_LinkedList));

        /* bu ilk bu şekilde yazmıştım, siz okey dediniz ama binary search kullanmam gerektiğini söyleyince alta binary search'li olanını yazdım

        ArrayList<Integer> AB = new ArrayList<Integer>();
        AB.addAll(A);
        AB.removeAll(B);

        ArrayList<Integer> BA = new ArrayList<Integer>();
        BA.addAll(B);
        BA.removeAll(A);

        ArrayList<Integer> ABA = new ArrayList<Integer>();
        ABA.addAll(A);
        ABA.removeAll(AB);
*/

        ArrayList<Integer> AB = new ArrayList<Integer>();
        for(int a : A){
            if(Collections.binarySearch(B,a) < 0){ // eğer varsa 0dan büyük döndürüyor o yüzden, eğer A'dakiler B'de yoksa demiş olyyorum
                AB.add(a);
            }
        }
        System.out.println(AB);

        ArrayList<Integer> BA = new ArrayList<Integer>();
        for(int b : B){
            if(Collections.binarySearch(A,b) < 0){
                BA.add(b);
            }
        }
        System.out.println(BA);

        ArrayList<Integer> ABA = new ArrayList<Integer>();
        for(int a : A){
            if(Collections.binarySearch(B,a) >= 0){
                ABA.add(a); // A ile B nin ortak elementlerini koymuş oluyorum
            }
        }
        System.out.println(ABA);

    }
}
