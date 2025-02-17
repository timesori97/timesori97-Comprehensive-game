package main;

import java.util.Scanner;

public class BattleGame {
	static Scanner scanner = new Scanner(System.in);
	static int p1 = 1;
	static int p2 = 2;
	static int g = 3;
	static int p1hp = 24;
	static int p2hp = 24;
	static int ghp = 4;
//----------------------------------------------------------
	static int p1_row = 4; // p1�� �ʱ� �� ��ġ
	static int p1_col = 0; // p1�� �ʱ� �� ��ġ
	static int p2_row = 0; // p2�� �ʱ� �� ��ġ
	static int p2_col = 4; // p2�� �ʱ� �� ��ġ
	static int[][] map = { { 0, 0, 0, 0, p2 }, 
						   { 0, 0, 0, 0, 0 }, 
			               { 0, 0, 0, 0, 0 }, 
			               { 0, 0, 0, 0, 0 },
		 	               { p1, 0, 0, 0, 0} };
	

	public static void main(String[] args) {
		System.out.println("�̵��� ������ �밢�� �ܷ̿� ����� �� �ֽ��ϴ�");
		System.out.println("�̵��� ��ĭ���� �����մϴ�");
		System.out.println("���������� 4�������̰� ���� �ٷ� ��ó�� ������ �����մϴ�");
		System.out.println("���Ÿ� ������ 2�������̰� ���� �� ĭ ���̷� ������ �����մϴ�");
		System.out.println("�÷��̾��� ü���� �Ѵ� 40���� �����Դϴ�.");
		System.out.println();
		System.out.println();
		
		
		String button = "";
		for(int i = 0; i <1000; i++) {
			if(i%2 == 0 || p1hp >= 0) {
				
					System.out.println("�÷��̾�1�� ���Դϴ�");
					System.out.println("1�� ������ �̵� 2�� ������ �������� 3�� ������ ���Ÿ�����");
					button = scanner.nextLine();
					if(button.equals("1")) {
						game_p1_movement();
					}
					if(button.equals("2")) {
						game_p1_melee_acttack();
					}
					if(button.equals("3")) {
						game_p1_ranged_attack();
					}
				
				
			}else {
				System.out.println("�÷��̾�1�� �׾����ϴ� ������ �����մϴ�.");
				break;
			}
			if(i%2 != 0 || p2hp >= 0) {
				System.out.println("�÷��̾�2�� ���Դϴ�");
				System.out.println("1�� ������ �̵� 2�� ������ �������� 3�� ������ ���Ÿ�����");
				button = scanner.nextLine();
				if(button.equals("1")) {
					game_p2_movement();
				}
				if(button.equals("2")) {
				 game_p2_melee_acttack();
				}
				if(button.equals("3")) {
					game_p2_ranged_attack();
				}
			}else {
				System.out.println("�÷��̾�2�� �׾����ϴ� ������ �����մϴ�.");
				break;
			}
		}
		
		
		
	}
	
	public static void game_p1_movement() {
		printMap();
        System.out.println("�÷��̾� 1 �̵� (w:��, s:�Ʒ�, a:����, d:������): ");
		String move = scanner.nextLine();
		boolean moved = false;
		switch(move) {
		case"w":
			if(p1_row > 0) {
				p1_movement_up();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"s":
			if(p1_row < 4) {
				p1_movement_down();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"a":
			if(p1_col > 0) {
				p1_movement_left();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"d":
			if(p1_col < 4) {
				p1_movement_right();
				moved =true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� w,s,a,d�߿��� �Է��Ͻʽÿ�");
		}
		if (moved) {
            System.out.println("�÷��̾� 1�� �̵��߽��ϴ�.");
        }
	}
	public static void game_p2_movement() {
        System.out.println("�÷��̾� 2 �̵� (w:��, s:�Ʒ�, a:����, d:������): ");
        String move = scanner.nextLine();
		boolean moved = false;
        switch(move) {
		case"w":
			if(p2_row > 0) {
				p2_movement_up();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"s":
			if(p2_row < 4) {
				p2_movement_down();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"a":
			if(p2_col > 0) {
				p2_movement_left();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case"d":
			if(p2_col < 4) {
				p2_movement_right();
				moved = true;
				printMap();
			}else {
				System.out.println("������ ������ϴ�");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� w,s,a,d�߿��� �Է��Ͻʽÿ�");
		}
		if (moved) {
            System.out.println("�÷��̾� 2�� �̵��߽��ϴ�.");
        }
	}
	
	
	public static void game_p1_melee_acttack() {
		printMap();
        System.out.println("�÷��̾� 1 ���� (i:�� ��������, k:�Ʒ� ��������, j:���� ��������, l:������ ��������): ");
		String attack = scanner.nextLine();
		boolean attacked = false;
		switch(attack) {
		case"i":
			if(p1_row == p2_row+1 && p1_col == p2_col && p1_row > 0 ) {
				p1_melee_acttack_up();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"k":
			if(p1_row == p2_row - 1 &&p1_col == p2_col && p1_row < 4) {
				p1_melee_acttack_down();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"j":
			if(p1_row == p2_row && p1_col == p2_col+1 && p1_col > 0) {
				p1_melee_acttack_left();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"l":
			if(p1_row == p2_row && p1_col == p2_col-1 && p1_col < 4 ) {
				p1_melee_acttack_right();
				attacked =true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}
		
	}
	public static void game_p2_melee_acttack() {
		printMap();
        System.out.println("�÷��̾� 2 ���� (i:�� ��������, k:�Ʒ� ��������, j:���� ��������, l:������ ��������): ");
		String attack = scanner.nextLine();
		boolean attacked = false;
		switch(attack) {
		case"i":
			if(p2_row == p1_row+1 && p2_col == p1_col && p2_row >0) {
				p2_melee_acttack_up();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"k":
			if(p2_row == p1_row - 1 &&p2_col == p1_col && p2_row < 4) {
				p2_melee_acttack_down();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"j":
			if(p2_row == p1_row && p2_col == p1_col+1 &&p2_col > 0) {
				p2_melee_acttack_left();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"l":
			if(p2_row == p1_row && p2_col == p1_col-1 && p2_col < 4) {
				p2_melee_acttack_right();
				attacked =true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ� ");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}
	}
	public static void game_p1_ranged_attack() {
		printMap();
        System.out.println("�÷��̾� 1 ���� (i:�� ���Ÿ�����, k:�Ʒ� ���Ÿ�����, j:���� ���Ÿ�����, l:������ ���Ÿ�����): ");
		String attack = scanner.nextLine();
		boolean attacked = false;
		switch(attack) {
		case"i":
			if(p1_row == p2_row+2 && p1_col == p2_col && p1_row > 0 ) {
				p1_ranged_attack_up();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"k":
			if(p1_row == p2_row - 2 &&p1_col == p2_col && p1_row < 4) {
				p1_ranged_attack_down();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"j":
			if(p1_row == p2_row && p1_col == p2_col+2 && p1_col > 0) {
				p1_ranged_attack_left();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"l":
			if(p1_row == p2_row && p1_col == p2_col-2 && p1_col < 4 ) {
				p1_ranged_attack_right();
				attacked =true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}
		
	}
	public static void game_p2_ranged_attack() {
		printMap();
        System.out.println("�÷��̾� 2 ���� (i:�� ���Ÿ�����, k:�Ʒ� ���Ÿ�����, j:���� ���Ÿ�����, l:������ ���Ÿ�����): ");
		String attack = scanner.nextLine();
		boolean attacked = false;
		switch(attack) {
		case"i":
			if(p2_row == p1_row+2 && p2_col == p1_col && p2_row > 0 ) {
				p2_ranged_attack_up();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"k":
			if(p2_row == p1_row - 2 &&p2_col == p1_col && p2_row < 4) {
				p2_ranged_attack_down() ;
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"j":
			if(p2_row == p1_row && p2_col == p1_col+2 && p2_col > 0) {
				p2_ranged_attack_left();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case"l":
			if(p2_row == p1_row && p2_col == p1_col-2 && p2_col < 4 ) {
				p2_ranged_attack_right();
				attacked =true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}
		
	}
	
	
	
	
	public static void p1_movement_up() {
	   if(p1_row > 0) {
		   map[p1_row][p1_col] = 0;
		   p1_row--;
		   map[p1_row][p1_col] = p1;
	   }
	}

	public static void p1_movement_down() {
	   if(p1_row < 4) {
		   map[p1_row][p1_col] = 0;
		   p1_row++;
		   map[p1_row][p1_col] = p1;
	   }
	}

	public static void p1_movement_left() {
	   if(p1_col > 0) {
		   map[p1_row][p1_col] = 0;
		   p1_col--;
		   map[p1_row][p1_col] = p1;
	   }
	}

	public static void p1_movement_right() {
	   if(p1_col < 4) {
		   map[p1_row][p1_col] = 0;
		   p1_col++;
		   map[p1_row][p1_col] = p1;
	   }
	}

	// p2 ������ �޼ҵ��
	public static void p2_movement_up() {
		   if(p2_row > 0) {
			   map[p2_row][p2_col] = 0;
			   p2_row--;
			   map[p2_row][p2_col] = p2;
		   }
		}

		public static void p2_movement_down() {
		   if(p2_row < 4) {
			   map[p2_row][p2_col] = 0;
			   p2_row++;
			   map[p2_row][p2_col] = p2;
		   }
		}

		public static void p2_movement_left() {
		   if(p2_col > 0) {
			   map[p2_row][p2_col] = 0;
			   p2_col--;
			   map[p2_row][p2_col] = p2;
		   }
		}

		public static void p2_movement_right() {
		   if(p2_col < 4) {
			   map[p2_row][p2_col] = 0;
			   p2_col++;
			   map[p2_row][p2_col] = p2;
		   }
		}

	// �� ����� ���� ����� �޼ҵ�
	public static void printMap() {
	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 5; j++) {
	            System.out.print(map[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}

	public static void p1_melee_acttack_up() {
		if(p1_row == p2_row+1 && p1_col == p2_col && p1_row > 0 ) {
			p2hp -= 4;
			
		}
	}
	public static void p1_melee_acttack_down() {
		if(p1_row == p2_row - 1 && p1_col == p2_col && p1_row < 4 ) {
			p2hp -= 4;
			
		}
	}
	public static void p1_melee_acttack_left() {
		if(p1_row == p2_row && p1_col == p2_col+1 && p1_col > 0 ) {
			p2hp -= 4;
			
		}
	}
	public static void p1_melee_acttack_right() {
	    if(p1_row == p2_row && p1_col == p2_col-1 && p1_col < 4 ) {
			p2hp -= 4;
			
		}
	
	}
	public static void p1_melee_acttack_sysout() {
		System.out.println("p2�� ü���� 4 ������ �޾ҽ��ϴ�");
		System.out.println("p2�� ü���� :"+ p2hp);
	}
	public static void p1_ranged_attack_up() {
		if(p1_row == p2_row+2 && p1_col == p2_col && p1_row > 0 ) {
			p2hp -= 2;
		}
	}
	public static void p1_ranged_attack_down() {
		if(p1_row == p2_row - 2 &&p1_col == p2_col && p1_row < 4 ) {
			p2hp -= 2;
		}
	}
	public static void p1_ranged_attack_left() {
		if(p1_row == p2_row && p1_col == p2_col+2 && p1_col > 0 ) {
			p2hp -= 2;
		}
	}
	public static void p1_ranged_attack_right() {
	    if(p1_row == p2_row && p1_col == p2_col-2 && p1_col < 4 ) {
			p2hp -= 2;
		}
	
	}
	public static void p1_ranged_attack_sysout() {
		System.out.println("p2�� ü���� 2 ������ �޾ҽ��ϴ�");
		System.out.println("p2�� ü���� :"+ p2hp);
	}
	
	//----------------------------------------------------------------------------------------------------------
	public static void p2_melee_acttack_up() {
		if(p2_row == p1_row+1 && p2_col == p1_col && p2_row >0) {
			p1hp -= 4;
			
		}
	}
	public static void p2_melee_acttack_down() {
		if(p2_row == p1_row - 1 &&p2_col == p1_col && p2_row < 4) {
			p1hp -= 4;
			
		}
	}
	public static void p2_melee_acttack_left() {
		if(p2_row == p1_row && p2_col == p1_col+1 && p2_col > 0) {
			p1hp -= 4;
		
		}
	}
	public static void p2_melee_acttack_right() {
	    if(p2_row == p1_row && p2_col == p1_col-1 && p2_col < 4) {
			p1hp -= 4;
			
		}
	
	}
	public static void p2_melee_acttack_sysout() {
		System.out.println("p1�� ü���� 4 ������ �޾ҽ��ϴ�");
		System.out.println("p1�� ü���� :"+ p1hp);
	}
	
	public static void p2_ranged_attack_up() {
		if(p2_row == p1_row+2 && p2_col == p1_col &&  p2_row >0) {
			p1hp -= 2;
		}
	}
	public static void p2_ranged_attack_down() {
		if(p2_row == p1_row - 2 &&p2_col == p1_col && p2_row < 4) {
			p1hp -= 2;
		}
	}
	public static void p2_ranged_attack_left() {
		if(p2_row == p1_row && p2_col == p1_col+2 &&p2_col > 0) {
			p1hp -= 2;
		}
	}
	public static void p2_ranged_attack_right() {
	    if(p2_row == p1_row && p2_col == p1_col-2 &&p2_col < 4) {
			p1hp -= 2;
		}
	
	}
	public static void p2_ranged_attack_sysout() {
		System.out.println("p1�� ü���� 2 ������ �޾ҽ��ϴ�");
		System.out.println("p1�� ü���� :"+ p1hp);
	}

}

