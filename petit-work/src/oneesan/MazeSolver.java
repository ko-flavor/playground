package oneesan;

import java.util.Scanner;
import java.util.Stack;

public class MazeSolver {

	private static long count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.close();

		long start = System.nanoTime();
		Stack<Route> stack = new Stack<>();

		stack.add(new Route(len));

		while (stack.size() > 0) {
			Route route = stack.pop();
			if (route.canGoDown()) {
				Route clone = route.clone();
				clone.goDown();
				postMoveProcess(stack, clone);
			}
			if (route.canGoUp()) {
				Route clone = route.clone();
				clone.goUp();
				postMoveProcess(stack, clone);
			}
			if (route.canGoRight()) {
				Route clone = route.clone();
				clone.goRight();
				postMoveProcess(stack, clone);
			}
			if (route.canGoLeft()) {
				Route clone = route.clone();
				clone.goLeft();
				postMoveProcess(stack, clone);
			}
		}
		System.out.println(count + "通り");
		System.out.println(((System.nanoTime() - start) / 1000000) + "ms");
	}

	private static void postMoveProcess(Stack<Route> stack, Route route) {
		if (route.isGoal()) {
			route.printRoute();
			count++;
			return;
		}
		stack.add(route);
	}

}
