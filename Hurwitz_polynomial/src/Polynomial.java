import java.lang.Math;

public class Polynomial {
	boolean hurwitzFlag;
	int[] coefficients;
	int orderOfPolynomial;
	Polynomial commonFactor;
	
	public Polynomial(boolean hurwitzFlag, int[] coefficients) {
		this.hurwitzFlag = hurwitzFlag;
		this.coefficients = new int[orderOfPolynomial];
		this.coefficients = coefficients;
		this.orderOfPolynomial =coefficients.length-1;
		commonFactor=null;
	}

	public Polynomial getCommonFactor() {
		return commonFactor;
	}

	public void setCommonFactor(Polynomial commonFactor) {
		this.commonFactor = commonFactor;
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
	
	public void checkIfAllCoefficientsIsPositive() {
		boolean flag=true;
		for(int i=0;i<=orderOfPolynomial;i++) {
			if(!(coefficients[i]>0)) {
				flag=false;
				break;
			}
		}
		if(flag==false) {
			System.out.print("Polynomial ");
			for(int i=0;i<=orderOfPolynomial;i++) {
				System.out.print(coefficients[i]);
				if(orderOfPolynomial-i!=0)
					System.out.print("s^"+(orderOfPolynomial-i)+" +");
			}
			System.out.println(" isn't a hurwitz Polynomial");
		}
		else
			System.out.print("Polynomial ");
			for(int i=0;i<=orderOfPolynomial;i++) {
				System.out.print(coefficients[i]);
				if(orderOfPolynomial-i!=0)
					System.out.print("s^"+(orderOfPolynomial-i)+" +");
			}
			System.out.println(" have positive coeffients");
	
	}
	
	public void CriterionRouthHurwitz(){
		int x,y,z,u;
		double[][] b=new double[orderOfPolynomial+1][(int) Math.ceil((orderOfPolynomial+1)/2.0)];
		for(int j=0;j<2;j++) {
			for(int i=0;i<(int)Math.ceil((orderOfPolynomial+1)/2.0);i++) {
				if(i*2+j<=orderOfPolynomial)
					b[j][i]=coefficients[i*2+j];
			}
		}
		/*
		for(int j=2;j<orderOfPolynomial+1;j++) {
			for(int i=0;i<(int)Math.ceil(orderOfPolynomial/2.0);i++) {
				x=coefficients[1];
				y=(2*(i+1))<orderOfPolynomial+1 ? coefficients[2*(i+1)] : 0;
				z=coefficients[0];
				u=((1+2*(i+1)<orderOfPolynomial+1) ? coefficients[1+2*(i+1)] : 0);
				b[i]=coefficients[1]*((2*(i+1))<orderOfPolynomial+1? coefficients[2*(i+1)] : 0)
						-coefficients[0]*((1+2*(i+1)<orderOfPolynomial+1) ? coefficients[1+2*(i+1)] : 0);
				b[i]/=coefficients[1];
					
			}
		}
		*/
	}
	
	
}
