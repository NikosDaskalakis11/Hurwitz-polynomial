
public class Polynomial {
	boolean hurwitzFlag;
	int[] coefficients;
	int orderOfPolynomial;
	
	public Polynomial(boolean hurwitzFlag, int[] coefficients, int orderOfPolynomial) {
		this.hurwitzFlag = hurwitzFlag;
		this.coefficients = new int[orderOfPolynomial];
		this.coefficients = coefficients;
		this.orderOfPolynomial = orderOfPolynomial;
	}

	public boolean isHurwitzFlag() {
		return hurwitzFlag;
	}

	public void setHurwitzFlag(boolean hurwitzFlag) {
		this.hurwitzFlag = hurwitzFlag;
	}

	public int[] getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(int[] coefficients) {
		this.coefficients = coefficients;
	}

	public int getOrderOfPolynomial() {
		return orderOfPolynomial;
	}

	public void setOrderOfPolynomial(int orderOfPolynomial) {
		this.orderOfPolynomial = orderOfPolynomial;
	}
	
	
	
	
}
