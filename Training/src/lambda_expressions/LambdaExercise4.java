package lambda_expressions;

@FunctionalInterface
interface TemperatureConversion {
	
	String temperature (double temp);
}
	public class LambdaExercise4 {

		public static void convertTemperature(TemperatureConversion b) {
			System.out.println(b.temperature(30.00));
		}

		public static void main(String[] args) {

			TemperatureConversion celsiusToFahrenheit = (t) -> {
				return "The temperature conversion: " + t + " Celsius (°C) = " + ((t * 9 / 5) + 32)
						+ "Fahrenheit (°F)";
			};
			System.out.println(celsiusToFahrenheit.temperature(30.00));

			TemperatureConversion FahrenheitToCelsius = (t) -> {
				return "The temperature conversion: " + t + " Fahrenheit (°F) = " + ((t - 32) * 5 / 9)
						+ " Celsius (°C)";
			};
			System.out.println(FahrenheitToCelsius.temperature(30.00));

			convertTemperature(celsiusToFahrenheit);
			convertTemperature(FahrenheitToCelsius);
	}
}
