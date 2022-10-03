package Bombbomb;

import java.util.Random;

public class Bombfield{

	protected int[][] field;
	protected int size = 15;// 추후 조정위에 임시 설정임
	private int bombnum;
	Random random;

	
	public Bombfield() {
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int[][] fieldcreate() {// 빈 필드 생성
		field = new int[size][size];
		return field;
	}
		
	
	
	public int[][] bombfieldcreate(int num) {// 폭탄 필드 생성
		field = fieldcreate();

		bombnum = num;// 임시 설정임, 난이도 따라 다름
		int count = 0;
		
		random = new Random();
		
		while(true) {
		int a = random.nextInt(size);
		int b = random.nextInt(size);
		
		if (field[a][b] == 0) {
			field[a][b] = 9;
			count ++;
			}
		
		if(count == bombnum) {break;}
		}
		
		return field;
	}
	

	public void fieldshow(int[][] field) {
		for(int i = 0; i < size; i++) {
			System.out.println();
			for(int j = 0; j < size; j++) {
				System.out.print(field[i][j]+" ");
			}}
		}
	
	
}
