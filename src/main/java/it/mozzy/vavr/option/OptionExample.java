package it.mozzy.vavr.option;

import io.vavr.control.Option;

public class OptionExample {
	
	public String legacyNullCheck(String nullableValue) {
		if (nullableValue != null) {
			return nullableValue.toLowerCase();
		}
		return nullableValue;
	}

	// do it the functional way
	public String vavrNullCheck(String nullableValue) {
		return Option.of(nullableValue).map(String::toLowerCase).getOrElse(nullableValue);
	}

}
