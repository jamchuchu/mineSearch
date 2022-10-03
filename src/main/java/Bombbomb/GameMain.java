package Bombbomb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameMain {

	// initUI == main
	static JPanel panelNorth;
	static JPanel panelCenter;
	static JLabel labelMassge;
	static JButton btnBack;
	static JButton[] btn;
	static int size = 15;
	static String bombimage = "bomb.png";
	static JLabel labelBombnum;
	static JLabel labelBomb;
	static int bombnum;
	static int count;
	
	
	
	static class Myframe extends JFrame implements ActionListener{
		
		Bombfield bombfield =  new Bombfield();
		Numfield numfield =  new Numfield();
		int[][] crebombfield;// 폭탄 숫자 고정 해둠
		int[][] crenumfield;
		
		
		public Myframe(String title) {
			super(title);
			this.setLayout(new BorderLayout());
			this.setSize(630, 690);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			crebombfield = bombfield.bombfieldcreate(bombnum);
			crenumfield = numfield.numfieldcreate(crebombfield);

			initUI(this);
			this.pack();
			
		}
		

//		 메인 게임 버튼 작동
		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			JButton bttn = (JButton)e.getSource();
			int index = getButtonIndex(bttn);
			int row = index/size;// 가로
			int col = index%size;// 세로
			int num = crenumfield[row][col];
			
			if (num == 9) {
				bttn.setIcon(changeImage("bomb.png",35,35));
				for (int i = 0; i<size; i++) {
					for (int j = 0; j<size; j++) {
						if(crenumfield[i][j] == 9)
						btn[i*size+j].setIcon(changeImage(bombimage, 35, 35));
					}
				}
				int result = JOptionPane.showConfirmDialog(null, "펑퍼러펑펑!! \n 다시하시겠습니까?", "실패!!",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == 0) {
					dispose();
					new Myframe("지뢰찾기");
					}else {System.exit(0);}
			}else {
			String numtext = String.valueOf(num);
			bttn.setText(numtext);
			bttn.setFont(new Font("font", Font.CENTER_BASELINE, 15));
			}
			if (count == size*size-bombnum) {
				int endresult = JOptionPane.showConfirmDialog(null, "축하합니다!! 성공하셨습니다!! \n 다시하시겠습니까?", "성공!!",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(endresult == 0) {
					dispose();
					new Myframe("지뢰찾기");
					}else {System.exit(0);}
			}
		}
		
		public int getButtonIndex(JButton bttn) {
			int index = 0;
			for (int i=0 ; i<size*size ;  i++) {
				if(btn[i] == bttn) {
					index = i;
				}
			}
		return index;
		}
	

	
}
	
	static void initUI(Myframe myFrame) {// 메인 ui
		
		
		panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(630,60));
		panelNorth.setBackground(new Color(74,177,44));
		btnBack = new JButton();
		btnBack.setPreferredSize(new Dimension(45,45));
		btnBack.setIcon(changeImage("back.png", 42, 42));
		btnBack.setBackground(null);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StartUI startUI = new StartUI("start");
				myFrame.dispose();
			}
		});
		panelNorth.add(btnBack);
		labelMassge = new JLabel("폭탄을 찾으세요!!");
		labelMassge.setPreferredSize(new Dimension(400,60));
		labelMassge.setForeground(Color.white);
		labelMassge.setFont(new Font("font",Font.BOLD,40));
		labelMassge.setHorizontalAlignment(JLabel.CENTER);
		panelNorth.add(labelMassge);
		labelBomb =  new JLabel();
		labelBomb.setPreferredSize(new Dimension(40,40));
		labelBomb.setIcon(changeImage(bombimage,40,40));
		panelNorth.add(labelBomb);
		labelBombnum =  new JLabel();
		String bombnumtext = String.valueOf(bombnum);
		labelBombnum.setText(bombnumtext);
		labelBombnum.setFont(new Font("font",Font.BOLD,40));
		panelNorth.add(labelBombnum);
		myFrame.add("North",panelNorth);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(size,size));
		panelCenter.setPreferredSize(new Dimension(630,630));
		count = 0;
		btn = new JButton[size*size];
		for (int i=0; i<size*size; i++) {
			btn[i] = new JButton();
			if(i%2 == 0) {btn[i].setBackground(new Color(167,217,72));}
			else{btn[i].setBackground(new Color(142,204,57));}
			btn[i].setPreferredSize(new Dimension(42,42));			
			btn[i].addActionListener(myFrame);//______________________________________버튼 클릭 이벤트
			panelCenter.add(btn[i]);
		}
		myFrame.add("Center",panelCenter);
		
		
	}
	
	static ImageIcon changeImage(String Filename, int width, int high) {// 파일 크기 변경 후 적용
		ImageIcon icon = new ImageIcon("./"+ Filename);
		Image originImage = icon.getImage();
		Image chagedImage = originImage.getScaledInstance(width, high, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(chagedImage);
		
		return icon_new;
	}

	
	
	public static void main(String[] args) {
		
		StartUI startUI = new StartUI("start");
		
	}
}
	

