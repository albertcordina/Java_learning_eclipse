package setters_and_getters;

public class SetGet_example {

	public static void main(String[] args) {

		Television tel = new Television();
		Smartphone smart = new Smartphone();

		tel.setBrand("Samsung");
		tel.setPrice(100);
		tel.setScreenSize(600);
		System.out.println("\nTelevision: \n\nThe brand: " + tel.getBrand() + "\nThe Price: " + tel.getPrice()
				+ "\nThe size of the screen: " + tel.getScreenSize());

		smart.setBrand("Apple");
		smart.setPrice(200);
		smart.setOperatingSystem("IOS");
		System.out.println("\n\nSmartphone: \n\nThe brand: " + smart.getBrand() + "\nThe Price: " + smart.getPrice()
				+ "\nThe operating system: " + smart.getOperatingSystem());

	}
}

class ElectronicDevice {

	protected String brand;
	protected double price;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}


class Television extends ElectronicDevice {
	protected int screenSize;
	
	public void setScreenSize (int screenSize) {
		this.screenSize = screenSize;
	}
	public int getScreenSize () {
		return screenSize;
	}
}


class Smartphone extends ElectronicDevice {
	
	String operatingSystem;
	
	public void setOperatingSystem (String operatingSystem) {
		this.operatingSystem = operatingSystem;
		
	}
	
	public String getOperatingSystem () {
		return operatingSystem;
	}
}