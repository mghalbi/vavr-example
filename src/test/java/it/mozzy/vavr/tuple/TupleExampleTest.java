package it.mozzy.vavr.tuple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import io.vavr.Tuple;
import io.vavr.Tuple1;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.collection.Seq;

public class TupleExampleTest {

	@Test
	public void whenCreatesTuple_with_two() {
		final Tuple2<String, String> fullname = Tuple.of("Mohsen", "Ghalbi");
		final String name = fullname._1;
		final String surname = fullname._2();

		assertEquals("Mohsen", name);
		assertEquals("Ghalbi", surname);
	}

	@Test
	public void whenCreatesTuple_with_three() {
		final Tuple3<String, String, Integer> info = Tuple.of("Mohsen", "Ghalbi", 27);
		final String name = info._1;
		final String surname = info._2();
		final Integer age = info._3();

		assertEquals("Mohsen", name);
		assertEquals("Ghalbi", surname);
		assertEquals(new Integer(27), age);
	}

	
	@Test
	public void testTuple1CollectorWithSingleSelectShouldSucceed() {
		final Tuple1<String> person1 = Tuple.of("Mohsen");
		final Tuple1<String> person2 = Tuple.of("Pippo");
		final Tuple1<Seq<String>> result = Tuple.sequence1(Arrays.asList(person1, person2));
		
		assertTrue(result._1().containsAll(Arrays.asList("Mohsen","Pippo")));
	}

	@Test
	public void testCompare() {
		final Tuple3<String, String, Double> thisTuple = Tuple.of("Pippo", "Pluto", 2.0);
		final Tuple3<String, String, Double> thatTuple = Tuple.of("Pippo", "Pluto", 2.0);
		final Tuple3<String, String, Double> notEqualTuple = Tuple.of("Pippo", "Pluto", 2.2);
		
		assertTrue(thisTuple.compareTo(thatTuple)==0);
		assertTrue(thisTuple.compareTo(notEqualTuple)!=0);
	}

}
