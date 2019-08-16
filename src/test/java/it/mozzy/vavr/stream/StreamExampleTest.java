package it.mozzy.vavr.stream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.vavr.collection.Stream;

public class StreamExampleTest {

	@Test
	public void testStreamIterate() {
		Stream<Integer> intStream = Stream.iterate(0, i -> i * 2).take(10);
		assertEquals(10, intStream.size());
	}

	@Test
	public void testStreamFilter() {
		Stream<Integer> s = Stream.of(1, 2, 3, 4);
		long evenSum = s.filter(i -> i % 2 == 0).sum().longValue();
		assertEquals(6, evenSum);
	}

}
