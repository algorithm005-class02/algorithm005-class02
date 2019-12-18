/**
 * InnerLeetCode_641_0299
 */
public class LeetCode_641_0299 {

  /**
   * 参考了答案写的。 自己的想法是: 创建两个指针，头部指针和尾部指针， 记录从头部进来的数量和尾部进来的数量。 创建两个数组
   * 一个维护从头部进来的，另一个维护从尾部进来的。 deleteLast 的时候先判断尾指针是否大于0 是的话 从尾部数组里取值； 否则去判断
   * 头部指针是否大于0 是的话 去头部数组里取值。都没有的话返回false
   * 
   * @param args
   */
  public static void main(String[] args) {

    MyCircularDeque myCircularDeque = new MyCircularDeque(10);
    myCircularDeque.insertLast(9);
    myCircularDeque.insertLast(10);
    myCircularDeque.insertFront(1);

    while (myCircularDeque.size > 0) {
      int res = myCircularDeque.getFront();
      System.out.println(res);
      myCircularDeque.deleteFront();
    }
  }

}