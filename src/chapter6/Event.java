package chapter6;

public class Event implements Comparable<Event> {
	private int thread;
	private int priority;
	
	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}
	
	

	public int getThread() {
		return thread;
	}



	public int getPriority() {
		return priority;
	}



	@Override
	public int compareTo(Event e) {
		if(this.getPriority() > e.getPriority()) {
			return -1;
		}else if(this.getPriority() < e.getPriority()) {
			return 1;
		}else {
			return (this.getThread() - e.getThread());
		}
		
	}

}
