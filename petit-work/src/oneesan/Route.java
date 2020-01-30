package oneesan;

import java.util.ArrayList;

class Route implements Cloneable {

	private int len;

	private int goal;

	private ArrayList<Integer> route;

	private int location;

	Route(int len) {
		this.len = len + 1;
		this.route = new ArrayList<>();
		route.add(0);
		this.goal = (len + 1) * (len + 1) - 1;
		this.location = 0;
	}

	public boolean contains(int point) {
		return route.contains(point);
	}

	public boolean canGoUp() {
		int newLocation = location - len;
		if (newLocation < 0 || contains(newLocation)) {
			return false;
		}
		return true;
	}

	public void goUp() {
		int newLocation = location - len;
		if (!canGoUp()) {
			return;
		}
		move(newLocation);
	}

	public boolean canGoDown() {
		int newLocation = location + len;
		if (newLocation > goal || contains(newLocation)) {
			return false;
		}
		return true;
	}

	public void goDown() {
		int newLocation = location + len;
		if (!canGoDown()) {
			return;
		}
		move(newLocation);
	}

	public boolean canGoRight() {
		int newLocation = location + 1;
		if (newLocation % len == 0 || contains(newLocation)) {
			return false;
		}
		return true;
	}

	public void goRight() {
		int newLocation = location + 1;
		if (!canGoRight()) {
			return;
		}
		move(newLocation);
	}

	public boolean canGoLeft() {
		int newLocation = location - 1;
		if (location % len == 0 || contains(newLocation)) {
			return false;
		}
		return true;
	}

	public void goLeft() {
		int newLocation = location - 1;
		if (!canGoLeft()) {
			return;
		}
		move(newLocation);
	}

	private void move(int newLocation) {
		location = newLocation;
		route.add(newLocation);
	}

	public boolean isGoal() {
		return location == goal;
	}

	public void printRoute() {
		System.out.println(route.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Route clone() {
		Route clone = null;
		try {
			clone = (Route) super.clone();
			clone.route = (ArrayList<Integer>) this.route.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clone;
	}
}
