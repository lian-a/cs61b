import  org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

    @Test
    public void testArray() {
        while (true) {
            int i = StdRandom.uniform(10);
            double flag = StdRandom.uniform();

            if (flag < 0.5 && !student.isEmpty()) {
                if (flag < 0.25) {
                    Integer x = student.removeFirst();
                    Integer y = solution.removeFirst();
                    assertEquals("removeFirst()\n", x, y);
                    System.out.println("removeFirst()");
                } else {
                    Integer x = student.removeLast();
                    Integer y = solution.removeLast();
                    assertEquals("removeLast\n", x, y);
                    System.out.println("removeLast()");
                }
            } else if (flag >= 0.5) {
                if (flag < 0.75) {
                    student.addFirst(i);
                    solution.addFirst(i);
                    System.out.println("addFirst(" + i + ")");
                } else {
                    student.addLast(i);
                    solution.addLast(i);
                    System.out.println("addLast(" + i + ")");
                }
            }
        }
    }
}
