package it.mozzy.vavr.option;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.vavr.control.Try;

public class TryExampleTest {

	@Test(expected = NullPointerException.class)
	public void testwhenThrowsNullPointerException_without_vavr() {
		final String nullvalue = null;
		nullvalue.length();
	}

	@Test
	public void testwhenNullPointerException_catch_vavr() {
		final String nullvalue = null;
		Try<Integer> result = Try.of(() -> nullvalue.length());
		assertTrue(result.isFailure());
	}

	@Test
	public void testwhenNullPointerException_get_value_vavr() {
		final String nullvalue = null;
		Try<Integer> result = Try.of(() -> nullvalue.length());
		int error = result.getOrElse(-1);
		assertEquals(-1, error);
	}

	@Test(expected = NullPointerException.class)
	public void testwhenNullPointerException_catch_and_throw_vavr() {
		final String nullvalue = null;
		Try<Integer> result = Try.of(() -> nullvalue.length());
		result.getOrElseThrow(throwable -> {
			throw new NullPointerException();
		});
	}
}
