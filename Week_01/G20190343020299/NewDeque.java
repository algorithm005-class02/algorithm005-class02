import java.util.Deque;
import java.util.LinkedList;

/**
 * NewDeque 用add first或add last这套新的API改写Deque的代码
 */
public class NewDeque {

  public static void main(String[] args) {

    Deque<String> deque = new LinkedList<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addLast("z");
    System.out.println(deque);

    String first = deque.peekFirst();
    String last = deque.peekLast();
    System.out.println(String.format("first:%s last:%s", first, last));

    while (deque.size() > 0) {
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
  }
}