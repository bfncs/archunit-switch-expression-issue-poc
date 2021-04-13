package us.byteb.archunit.app;

import us.byteb.archunit.lib.ExampleEnum;

public class Example {

	public static String failingExample1(final ExampleEnum exampleEnum) {
		return switch (exampleEnum) {
			case FOO -> "foo";
			case BAR -> "bar";
		};
	}

	public static String failingExample2(final ExampleEnum exampleEnum) {
		switch (exampleEnum) {
			case FOO:
				return "foo";
			case BAR:
				return "bar";
			default:
				throw new IllegalArgumentException();
		}
	}

	public static String workingExample(final ExampleEnum exampleEnum) {
		if (exampleEnum == ExampleEnum.FOO) {
			return "foo";
		} else if (exampleEnum == ExampleEnum.BAR) {
			return "bar";
		}
		throw new IllegalArgumentException();
	}

}
