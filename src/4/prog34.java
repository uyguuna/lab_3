import java.util.Scanner;
class Number {
    int value;
    Number next;
    int index;
    public Number(int value, Number next, int index) {
        this.value = value;
        this.next = next;
        this.index = index;
    }
    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", next=" + next +
                ", index=" + index +
                '}';
    }
}
public class prog34 {
    static Scanner sc;
    public static double findSum(Number head) {
        double sum = 0;
        Number ref = head;
        while (ref.next != null) {
            if (ref.value % 3 == 0) {
                sum = sum + ref.value;
            }
            ref = ref.next;
        }
        if (ref.value % 3 == 0) {
            sum = sum + ref.value;
        }
        return sum;
    }
    public static double findCount(Number head) {
        double count = 0;
        Number ref = head;
        while (ref.next != null) {
            if (ref.value % 3 == 0) {
                count++;
            }
            ref = ref.next;
        }
        if (ref.value % 3 == 0) {
            count++;
        }
        return count;
    }
    public static int[] findMax(Number head, int n){
        Number ref = head;
        int indexmax = ref.index;
        int max = ref.value;
        while (ref != null){
            if(ref.value % 3 == 0 && ref.value > 0){
                if(ref.value > max) {
                    max = ref.value;
                    indexmax = ref.index;
                }
            }
            ref = ref.next;
        }
        return new int[]{indexmax,max};
    }
    public static int[] findMin(Number head, int n){
        Number ref = head;
        int indexmin = ref.index;
        int min = ref.value;
        while (ref != null){
            if(ref.value % 3 == 0 && ref.value > 0){
                if(ref.value < min) {
                    min = ref.value;
                    indexmin = ref.index;
                }
            }
            ref = ref.next;
        }
        return new int[]{indexmin,min};
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Input array size");
        System.out.print(">>");
        int n = sc.nextInt();
        Number head = null;
        System.out.println("Input array args");
        for (int i = 0; i < n; i++){
            int value = sc.nextInt();
            head = new Number(value, head, i);
        }
        System.out.println(head);
        double sum = findSum(head);
        System.out.println("sum = " + sum);
        double count = findCount(head);
        System.out.println("count = " + count);
        System.out.println("avg = " + (double)sum/count);

        int max = findMax(head,n)[1];
        int indexmax = findMax(head,n)[0];
        System.out.println("indexmax = " + (indexmax+1) +" "+ max);

        int min = findMin(head,n)[1];
        int indexmin = findMin(head,n)[0];
        System.out.println("indexmin = " + (indexmin+1) +" "+ min);
    }
}