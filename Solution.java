import java.util.*;


class Solution {


    public static void main(String[] args) {
        int x = 3;
        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(1, 2, 3, 1, 1, 2, 4, 1, 3, 4));

        findMin(list, x);


    }

    private static void findMin(List<Integer> list, int x) {

        int min = Integer.MAX_VALUE;
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        for (i = 0; i < x; i++) {

            while (!queue.isEmpty() && list.get(i) <= list.get(queue.peekLast()))
                queue.removeLast();
            queue.addLast(i);

        }

        int size = list.size();
        for (; i < size; i++) {
            System.out.print(list.get(queue.peek()) + " ");
            min = Math.min(min, list.get(queue.peek()));
            while ((!queue.isEmpty()) && queue.peek() <= i - x)
                queue.removeFirst();

            while ((!queue.isEmpty()) && list.get(i) <= list.get(queue.peekLast()))
                queue.removeLast();

            // Add current element at the rear of Qi
            queue.addLast(i);
        }
        min = Math.min(min, list.get(queue.peek()));
        System.out.println(min);


    }

}