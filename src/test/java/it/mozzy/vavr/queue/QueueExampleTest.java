package it.mozzy.vavr.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Queue;

public class QueueExampleTest {

	@Test
	public void testEnqueue() {
		Queue<Integer> queue = Queue.of(1, 2);
		Queue<Integer> secondQueue = queue.enqueueAll(List.of(3,4));

		assertEquals(2, queue.size());
		assertEquals(4, secondQueue.size());
	}

	@Test
	public void testDequeue() {
		Queue<Integer> queue = Queue.of(1, 2);
		Queue<Integer> secondQueue = queue.enqueueAll(List.of(3,4));

		Tuple2<Integer, Queue<Integer>> result = secondQueue.dequeue();
		assertEquals(Integer.valueOf(1), result._1());

		Queue<Integer> tailQueue = result._2;
		assertFalse(tailQueue.contains(secondQueue.get(0)));
	}

}
