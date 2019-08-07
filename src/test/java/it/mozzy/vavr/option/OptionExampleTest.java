package it.mozzy.vavr.option;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

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

}
