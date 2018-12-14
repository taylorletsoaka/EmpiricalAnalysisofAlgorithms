
public class Timer {

	long startTime, endTime;

	/**
	 * Begins timer
	 */
	public void start(){
		startTime = System.nanoTime()/1000000;
	}

	/**
	 * Stops timer
	 */
	public void stop(){
		endTime = System.nanoTime()/1000000;
	}

	/**
	 *
	 * @return elapsed, time difference between start and end time
	 */
	public long getTime(){
		long elapsed = endTime-startTime;
		return elapsed;
	}

}