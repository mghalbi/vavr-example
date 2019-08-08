package it.mozzy.vavr.option;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import io.vavr.control.Option;

public class OptionExampleTest {

	private OptionExample examples;

	@Before
	public void setUp() throws Exception {
		this.examples = new OptionExample();
	}

	@Test
	public void should_return_lower_case_jdk8() {
		assertEquals("mohsenghalbi", this.examples.legacyNullCheck("MohsenGhalbi"));
	}

	@Test
	public void should_return_lower_case_optional() {
		assertEquals("mohsenghalbi", this.examples.vavrNullCheck("MohsenGhalbi"));
	}

	@Test
	public void should_return_empity_jdk8() {
		assertNull(this.examples.legacyNullCheck(null));
	}

	@Test
	public void should_return_empity_optional() {
		assertNull(this.examples.vavrNullCheck(null));
	}

	@Test
	public void typicalUse() {
		// Option without anything inside
		Option.none();
		Option<String> dogMaybe = Option.of("dog");
		Optional<String> javaOptional = Optional.of("dog");
		dogMaybe = Option.ofOptional(javaOptional);
		assertEquals("DOG", dogMaybe.peek(System.out::println).map(String::toUpperCase).getOrElse(""));
	}
}
