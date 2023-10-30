package electronic;

public class Student {

	static int Id;
	static byte age;
	static String name;
	static byte children;

	public static void main(String[] args) {

		Graduated grad = new Graduated();
		NotGraduated nGrad = new NotGraduated();

		grad.setPastYearsAfterGraduation(12);
		System.out.println(grad.getPastYearsAfterGraduation());
		;

		nGrad.setRemainYearsToGraduation(23);
		System.out.println(nGrad.getRemainYearsToGraduation());

	}
}

class Graduated extends Student {

	private int PastYearsAfterGraduation;

	public String getPastYearsAfterGraduation() {
		return ("The past years after graduation " + PastYearsAfterGraduation);
	}

	public void setPastYearsAfterGraduation(int PastYearsAfterGraduation) {
		this.PastYearsAfterGraduation = PastYearsAfterGraduation;
	}
}

class NotGraduated extends Student {

	private int RemainYearsToGraduation;

	public String getRemainYearsToGraduation() {
		return ("The remaining years to graduation " + RemainYearsToGraduation);
	}

	public void setRemainYearsToGraduation(int RemainYearsToGraduation) {
		this.RemainYearsToGraduation = RemainYearsToGraduation;
	}
}