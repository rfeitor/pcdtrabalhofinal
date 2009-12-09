import java.util.HashSet;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest implements Runnable {

	private BlockingQueue<Object> messageQueue;
	private long pause;

	public BlockingQueueTest(BlockingQueue<Object> messageQueue, long pause) {
		this.messageQueue = messageQueue;
		this.pause = pause;
	}

	/**
	 * This method pushes an object onto the end of the queue, and then notifies
	 * one of the waiting threads.
	 * 
	 * @param obj
	 */

	public void push(Object obj) { // TODO possivelmente Crawler em vez de
		synchronized (messageQueue) {
			messageQueue.add(obj);
			messageQueue.notify();
		}
	}

	/**
	 * The pop operation blocks until either an object is returned or the thread
	 * is interrupted, in which case it throws an InterruptedException.
	 * 
	 * @return queue.wait() or queue.removeFirst()
	 * @throws InterruptedException
	 */
	public Object pop() throws InterruptedException {
		synchronized (messageQueue) {
			while (messageQueue.isEmpty())
				messageQueue.wait();
			return messageQueue;
		}
	}

	/**
	 * Return the number of elements currently in the queue.
	 * 
	 * @return queue.size()
	 */
	public int size() {
		return messageQueue.size();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			messageQueue.put(null);
			Thread.sleep(pause);
		} catch (InterruptedException ie) {
			// Ignore
		}
	}
}