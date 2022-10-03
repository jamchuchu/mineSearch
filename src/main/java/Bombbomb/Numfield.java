package Bombbomb;

public class Numfield extends Bombfield{

	// 해당 클래스에서 int[][] F 는 생성된 폭탄 필드
	private int[][] numfield;
	
	
	public Numfield() {
		// TODO Auto-generated constructor stub
	}
	
	public int num(int[][] F,int a, int b) {
		
	
		int num = F[a][b];
		
		return num;
	}
	
	public int calculselfnum(int[][] F, int a , int b) {
	
		int self = 0;
		
		if( a -1 >= 0 && b - 1 >= 0) {self = self+ num(F,a-1,b-1);}
		if( a -1 >= 0) {self = self+ num(F,a-1,b);}
		if( a -1 >= 0 && b + 1 < size) {self = self+ num(F,a-1,b+1);}
		if( b -1 >= 0) {self = self+ num(F,a,b-1);}
		if( b + 1 < size) {self = self+ num(F,a,b+1);}
		if( a + 1 < size && b - 1 >= 0) {self = self+ num(F,a+1,b-1);}
		if( a + 1 < size ) {self = self+ num(F,a+1,b);}
		if( a + 1 < size && b + 1 < size) {self = self+ num(F,a+1,b+1);}
		
		int num = 0;
		if (self == 0)
		{num = 0;
		}else {num = self/9;}
		
		return num;
		
	}
	
	public int[][] numfieldcreate(int[][] F) {
		
		numfield = fieldcreate();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(num(F,i,j) != 9){
					numfield[i][j] = calculselfnum(F, i, j);
					}else {numfield[i][j] = 9;}
			}
		}
		
		 
		
		return numfield;
		
		}
}
