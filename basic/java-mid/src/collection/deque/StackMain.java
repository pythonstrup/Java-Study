package collection.deque;

import java.util.Stack;

// 스택 자료구조는 사용하지 않는 것이 좋다.
// 스택 내부에서는 Vector라는 자료구조를 사용한다. (자바 1.0에서 사용)
// 지금은 사용되지 않고 하위 호환을 위해 존재만 한다.
// 따라서 Deque를 사용하는 것을 권장한다.
public class StackMain {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);

    System.out.println("stack.peek() = " + stack.peek());

    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack = " + stack);
  }
}
