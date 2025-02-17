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
	static int p1_row = 4; // p1의 초기 행 위치
	static int p1_col = 0; // p1의 초기 열 위치
	static int p2_row = 0; // p2의 초기 행 위치
	static int p2_col = 4; // p2의 초기 열 위치
	static int[][] map = { { 0, 0, 0, 0, p2 }, 
						   { 0, 0, 0, 0, 0 }, 
			               { 0, 0, 0, 0, 0 }, 
			               { 0, 0, 0, 0, 0 },
		 	               { p1, 0, 0, 0, 0} };
	

	public static void main(String[] args) {
		System.out.println("이동과 공격은 대각선 이외로 사용할 수 있습니다");
		System.out.println("이동은 한칸씩만 가능합니다");
		System.out.println("근접공격은 4데미지이고 적이 바로 근처에 있을때 가능합니다");
		System.out.println("원거리 공격은 2데미지이고 적이 두 칸 차이로 있을때 가능합니다");
		System.out.println("플레이어의 체력은 둘다 40으로 시작입니다.");
		System.out.println();
		System.out.println();
		
		
		String button = "";
		for(int i = 0; i <1000; i++) {
			if(i%2 == 0 || p1hp >= 0) { //짝수이면 1번 플레이어 턴
				
					System.out.println("플레이어1의 턴입니다");
					System.out.println("1을 누르면 이동 2를 누르면 근접공격 3을 누르면 원거리공격");
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
				System.out.println("플레이어1가 죽었습니다 게임을 종료합니다.");
				break;
			}
			if(i%2 != 0 || p2hp >= 0) { // 홀수일 경우 플레이어2의 턴
				System.out.println("플레이어2의 턴입니다");
				System.out.println("1을 누르면 이동 2를 누르면 근접공격 3을 누르면 원거리공격");
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
				System.out.println("플레이어2가 죽었습니다 게임을 종료합니다.");
				break;
			}
		}
		
		
		
	}
	
	public static void game_p1_movement() {// 플레이어1번 이동 메서드
		printMap();
        System.out.println("플레이어 1 이동 (w:위, s:아래, a:왼쪽, d:오른쪽): ");
		String move = scanner.nextLine();
		boolean moved = false;
		switch(move) {
		case"w":
			if(p1_row > 0) {
				p1_movement_up();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"s":
			if(p1_row < 4) {
				p1_movement_down();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"a":
			if(p1_col > 0) {
				p1_movement_left();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"d":
			if(p1_col < 4) {
				p1_movement_right();
				moved =true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 w,s,a,d중에서 입력하십시오");
		}
		if (moved) {
            System.out.println("플레이어 1이 이동했습니다.");
        }
	}
	public static void game_p2_movement() { // 플레이어2 이동 메서드
        System.out.println("플레이어 2 이동 (w:위, s:아래, a:왼쪽, d:오른쪽): ");
        String move = scanner.nextLine();
		boolean moved = false;
        switch(move) {
		case"w":
			if(p2_row > 0) {
				p2_movement_up();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"s":
			if(p2_row < 4) {
				p2_movement_down();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"a":
			if(p2_col > 0) {
				p2_movement_left();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case"d":
			if(p2_col < 4) {
				p2_movement_right();
				moved = true;
				printMap();
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 w,s,a,d중에서 입력하십시오");
		}
		if (moved) {
            System.out.println("플레이어 2이 이동했습니다.");
        }
	}
	
	
	public static void game_p1_melee_acttack() {// 플레이어1 근접공격
		printMap();
        System.out.println("플레이어 1 공격 (i:위 근접공격, k:아래 근접공격, j:왼쪽 근접공격, l:오른쪽 근접공격): ");
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
				System.out.println("빗맞았습니다");
			}
			break;
		case"k":
			if(p1_row == p2_row - 1 &&p1_col == p2_col && p1_row < 4) {
				p1_melee_acttack_down();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"j":
			if(p1_row == p2_row && p1_col == p2_col+1 && p1_col > 0) {
				p1_melee_acttack_left();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"l":
			if(p1_row == p2_row && p1_col == p2_col-1 && p1_col < 4 ) {
				p1_melee_acttack_right();
				attacked =true;
				p1_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}
		
	}
	public static void game_p2_melee_acttack() {// 플레이어2 근접공격
		printMap();
        System.out.println("플레이어 2 공격 (i:위 근접공격, k:아래 근접공격, j:왼쪽 근접공격, l:오른쪽 근접공격): ");
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
				System.out.println("빗맞았습니다");
			}
			break;
		case"k":
			if(p2_row == p1_row - 1 &&p2_col == p1_col && p2_row < 4) {
				p2_melee_acttack_down();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"j":
			if(p2_row == p1_row && p2_col == p1_col+1 &&p2_col > 0) {
				p2_melee_acttack_left();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"l":
			if(p2_row == p1_row && p2_col == p1_col-1 && p2_col < 4) {
				p2_melee_acttack_right();
				attacked =true;
				p2_melee_acttack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다 ");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}
	}
	public static void game_p1_ranged_attack() {//플레이어1 원거리 공격
		printMap();
        System.out.println("플레이어 1 공격 (i:위 원거리공격, k:아래 원거리공격, j:왼쪽 원거리공격, l:오른쪽 원거리공격): ");
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
				System.out.println("빗맞았습니다");
			}
			break;
		case"k":
			if(p1_row == p2_row - 2 &&p1_col == p2_col && p1_row < 4) {
				p1_ranged_attack_down();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"j":
			if(p1_row == p2_row && p1_col == p2_col+2 && p1_col > 0) {
				p1_ranged_attack_left();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"l":
			if(p1_row == p2_row && p1_col == p2_col-2 && p1_col < 4 ) {
				p1_ranged_attack_right();
				attacked =true;
				p1_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}
		
	}
	public static void game_p2_ranged_attack() {플레이어2 원거리 공격
		printMap();
        System.out.println("플레이어 2 공격 (i:위 원거리공격, k:아래 원거리공격, j:왼쪽 원거리공격, l:오른쪽 원거리공격): ");
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
				System.out.println("빗맞았습니다");
			}
			break;
		case"k":
			if(p2_row == p1_row - 2 &&p2_col == p1_col && p2_row < 4) {
				p2_ranged_attack_down() ;
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"j":
			if(p2_row == p1_row && p2_col == p1_col+2 && p2_col > 0) {
				p2_ranged_attack_left();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
		case"l":
			if(p2_row == p1_row && p2_col == p1_col-2 && p2_col < 4 ) {
				p2_ranged_attack_right();
				attacked =true;
				p2_ranged_attack_sysout();
				printMap();
			}else {
				System.out.println("빗맞았습니다");
			}
			break;
			default:
				System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
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

	// p2 움직임 메소드들
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

	// 맵 출력을 위한 도우미 메소드
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
		System.out.println("p2의 체력이 4 데미지 받았습니다");
		System.out.println("p2의 체력은 :"+ p2hp);
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
		System.out.println("p2의 체력이 2 데미지 받았습니다");
		System.out.println("p2의 체력은 :"+ p2hp);
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
		System.out.println("p1의 체력이 4 데미지 받았습니다");
		System.out.println("p1의 체력은 :"+ p1hp);
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
		System.out.println("p1의 체력이 2 데미지 받았습니다");
		System.out.println("p1의 체력은 :"+ p1hp);
	}

}

