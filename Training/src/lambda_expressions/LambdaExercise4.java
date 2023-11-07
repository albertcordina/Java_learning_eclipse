package lambda_expressions;

@FunctionalInterface
interface TemperatureConversion {
	
	String temperature (double temp); // String is the 
}
	public class LambdaExercise4 {

		public static void convertTemperature(TemperatureConversion b) {
			System.out.println(b.temperature(50.00));
		}

		public static void main(String[] args) {
// create object of Interface with the use of the parameter 'double temp' as the 't'
			TemperatureConversion celsiusToFahrenheit = (t) -> {  
				return "The temperature conversion: " + t + " Celsius (°C) = " + ((t * 9 / 5) + 32)
						+ "Fahrenheit (°F)";
			};
			System.out.println(celsiusToFahrenheit.temperature(30.00)); // print out the result with assigning the value(s)
			convertTemperature(celsiusToFahrenheit); // print out the result via the mehtod which is assigning the value(s) 

			
			
// create another object of Interface with the use of the parameter 'double temp' as the 't'
			TemperatureConversion FahrenheitToCelsius = (t) -> {
				return "The temperature conversion: " + t + " Fahrenheit (°F) = " + ((t - 32) * 5 / 9)
						+ " Celsius (°C)";
			};
			System.out.println(FahrenheitToCelsius.temperature(30.00)); // print out the result with assigning the value(s)
			convertTemperature(FahrenheitToCelsius); // print out the result via the mehtod which is assigning the value(s)
	}
}
