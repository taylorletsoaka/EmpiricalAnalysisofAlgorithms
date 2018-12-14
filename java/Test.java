import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(500000000);
        list.add(5);
        System.out.println(list.get(0));
    }
}
