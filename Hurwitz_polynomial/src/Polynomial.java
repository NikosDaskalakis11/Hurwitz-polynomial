import java.lang.Math;
import java.security.Signature;
import java.text.DecimalFormat;

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
		this.orderOfPolynomial =coefficients.length-1;
	}

	public int getOrderOfPolynomial() {
		return orderOfPolynomial;
	}

	
	public static boolean checkIfAllCoefficientsIsPositive(int orderOfPolynomial,int[] coefficients) {
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
			return flag;
		}
		else
			System.out.print("Polynomial ");
			for(int i=0;i<=orderOfPolynomial;i++) {
				System.out.print(coefficients[i]);
				if(orderOfPolynomial-i!=0)
					System.out.print("s^"+(orderOfPolynomial-i)+" +");
			}
			System.out.println(" have positive coeffients");	
			return flag;
	}
	
	public static boolean CriterionRouthHurwitz(int[] coefficients){
		boolean flag;
		int orderOfPolynomial =coefficients.length-1;
		flag=checkIfAllCoefficientsIsPositive(orderOfPolynomial,coefficients);
		System.out.println();
		if(flag==true) {
			double[][] b=new double[orderOfPolynomial+1][(int) Math.ceil((orderOfPolynomial+1)/2.0)];
			for(int j=0;j<2;j++) {
				for(int i=0;i<(int)Math.ceil((orderOfPolynomial+1)/2.0);i++) {
					if(i*2+j<=orderOfPolynomial)
						b[j][i]=coefficients[i*2+j];
				}
			}
			
			for(int j=2;j<orderOfPolynomial+1;j++) {
				for(int i=0;i<(int)Math.ceil((orderOfPolynomial+1)/2.0);i++) {
					b[j][i]=b[j-1][0] * (i+1<(int)Math.ceil((orderOfPolynomial+1)/2.0)? b[j-2][i+1] : 0)
							-b[j-2][0] * (i+1<(int)Math.ceil((orderOfPolynomial+1)/2.0) ? b[j-1][i+1] : 0);
					b[j][i]/=b[j-1][0];
						
				}
			}
			
			System.out.println("Routh table is: ");
			for(int i=0;i<orderOfPolynomial+1;i++) {
				System.out.print("   s^"+(orderOfPolynomial-i+"  | "));
				for(int j=0;j<(int)Math.ceil((orderOfPolynomial+1)/2.0);j++) {
					System.out.print(String.format("%,05.2f", b[i][j])+"  ");
				}
				System.out.println();
			}
			boolean stable=true;
			System.out.println();
			for(int i=0;i<orderOfPolynomial-1;i++) {
				if( Math.signum(b[i][0])!=Math.signum(b[i+1][0]))
					stable=false;
			}
			if(stable== false) {
				System.out.println("the system is unstable");
				System.out.println();
				return false;
			}
			else {
				System.out.println("the system is stable and polynomial is Hurwitz");
				System.out.println();
				return true;
			}
		}
		else return false;
	}
	
	
	
}



