
public class Main {

	public static void main(String[] args) {
		
		Main main= new Main();
		
		int[] array= {1,10,35,50,24};
		Polynomial p = null;
		main.createAPolynomial(p,array);
		System.out.println();
		
		
	}

	void createAPolynomial(Polynomial p,int[] coefficientsOfPolynomial) {
		boolean flag=Polynomial.CriterionRouthHurwitz(coefficientsOfPolynomial);
		if(flag==true)
			p=new HurwitzPolynomial(flag, coefficientsOfPolynomial);
		else
			p=new Polynomial(flag, coefficientsOfPolynomial);
	}
}
