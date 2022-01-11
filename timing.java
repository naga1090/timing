public class timing {
	
	private static String string_auto() {
		String temp = "";
		for (int i = 0; i < 100_000; i++) {
			temp += i;
		}
		return temp;
	}
	
	private static String string_auto_SB() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 100_000; i++) {
			stringBuilder.append(i);
		}
		return stringBuilder.toString();
	}

	private static String string_value_of() {
		String temp = "";
		for (int i = 0; i < 100_000; i++) {
			temp += String.valueOf(i);
		}
		return temp;
	}
	
	private static String string_value_of_SB() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 100_000; i++) {
			stringBuilder.append(String.valueOf(i));
		}
		return stringBuilder.toString();
	}

	private static String integer_to_string() {
		String temp = "";
		for (int i = 0; i < 100_000; i++) {
			temp += Integer.toString(i);
		}
		return temp;
	}
	
	private static String integer_to_string_SB() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 100_000; i++) {
			stringBuilder.append(Integer.toString(i));
		}
		return stringBuilder.toString();
	}

	private static String string_format() {
		String temp = "";
		for (int i = 0; i < 100_000; i++) {
			temp += String.format("%s", i);
		}
		return temp;
	}
	
	private static String string_format_SB() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 100_000; i++) {
			stringBuilder.append(String.format("%s", i));
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		
		long startTime_string_auto = System.nanoTime();
		string_auto();
		long endTime_string_auto = System.nanoTime();
		
		long startTime_string_auto_SB = System.nanoTime();
		string_auto_SB();
		long endTime_string_auto_SB = System.nanoTime();

		long startTime_string_value_of = System.nanoTime();
		string_value_of();
		long endTime_string_value_of = System.nanoTime();
		
		long startTime_string_value_of_SB = System.nanoTime();
		string_value_of_SB();
		long endTime_string_value_of_SB = System.nanoTime();

		long startTime_integer_to_string = System.nanoTime();
		integer_to_string();
		long endTime_integer_to_string = System.nanoTime();
		
		long startTime_integer_to_string_SB = System.nanoTime();
		integer_to_string_SB();
		long endTime_integer_to_string_SB = System.nanoTime();

		long startTime_string_format = System.nanoTime();
		string_format();
		long endTime_string_format = System.nanoTime();
		
		long startTime_string_format_SB = System.nanoTime();
		string_format_SB();
		long endTime_string_format_SB = System.nanoTime();
		
		long timeElapsed_string_auto = endTime_string_auto - startTime_string_auto;
		long timeElapsed_string_auto_SB = endTime_string_auto_SB - startTime_string_auto_SB;
		long timeElapsed_string_value_of = endTime_string_value_of - startTime_string_value_of;
		long timeElapsed_string_value_of_SB = endTime_string_value_of_SB - startTime_string_value_of_SB;
		long timeElapsed_integer_to_string = endTime_integer_to_string - startTime_integer_to_string;
		long timeElapsed_integer_to_string_SB = endTime_integer_to_string_SB - startTime_integer_to_string_SB;
		long timeElapsed_string_format = endTime_string_format - startTime_string_format;
		long timeElapsed_string_format_SB = endTime_string_format_SB - startTime_string_format_SB;
		
		System.out.println("String auto: " + timeElapsed_string_auto / 1000000000.);
		System.out.println("String value of: " + timeElapsed_string_value_of / 1000000000.);
		System.out.println("Integer to string: " + timeElapsed_integer_to_string / 1000000000.);
		System.out.println("String format: " + timeElapsed_string_format / 1000000000.);
		System.out.println("String auto SB: " + timeElapsed_string_auto_SB / 1000000000.);
		System.out.println("String valye of SB: " + timeElapsed_string_value_of_SB / 1000000000.);
		System.out.println("Integer to string SB: " + timeElapsed_integer_to_string_SB / 1000000000.);
		System.out.println("String format SB: " + timeElapsed_string_format_SB / 1000000000.);
	}

}
