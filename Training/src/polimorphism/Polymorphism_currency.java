package polimorphism;
class USD {
	
	public static double convertToUSD(double amount) {
		return amount;
	}

}
class EUR {
	
	public static double convertToUSD(double amount) {
		return amount * 1.18;
	}
	
}
class GBP {
	
	public static double convertToUSD(double amount) {
		return amount * 1.39;
		
	}
	
}
class Polymorphism_currency {
	
	public static void main(String[] args) {
	
	double [] currency = new double [3];
	currency [0] = USD.convertToUSD(100);
	currency [1] = EUR.convertToUSD(100);
	currency [2] = GBP.convertToUSD(100);
	
	System.out.println("Convertion to USD:\nUSD: " + currency [0] + "\nEUR: " + currency [1] + "\nGBP: " + currency [2]);
		
	}
}



