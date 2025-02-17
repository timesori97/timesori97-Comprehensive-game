package main;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class game {
	static Scanner in = new Scanner(System.in);
	static String InputWord;
	static String[] EnglishWord = new String[5];
	static String[] EnglishK = new String[5];
	static Random r = new Random();
	static int p1 = 15;
	static int p2 = 16;
	static int damage = 0;
	public static String red = "\u001B[31m";
	
	public static String green = "\u001B[32m";
	public static String blue = "\u001B[34m";
	public static String purple = "\u001B[35m";
	public static String cyan = "\u001B[36m";
	public static String exit = "\u001B[0m";
	static String[][] board = new String[3][3];
	static String mole = "\uD83D\uDC39";
	static String hole = "\uD83D\uDD73";
	static int moleX = 0;
	static int moleY = 0;
	static int inputX = 0;
	static int inputY = 0;
	static int cnt = 0;
	static int num[] = new int[5];
	static int map1[][] = { { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 } };
	static int p1hp = 24;
	static int p2hp = 24;
	static int p1_row = 4; // p1의 초기 행 위치
	static int p1_col = 0; // p1의 초기 열 위치
	static int p2_row = 0; // p2의 초기 행 위치
	static int p2_col = 4; // p2의 초기 열 위치
	static int[][] map = { { 0, 0, 0, 0, p2 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ p1, 0, 0, 0, 0 } };

	public static void main(String[] args) {

		System.out.println("-------------------");
		for (int i = 0; i < 2; i++) {
			System.out.println(purple + "메뉴를 숫자로 선택하시오" + exit);
			System.out.println("1.덧셈게임");
			System.out.println("2.만나는게임");
			System.out.println("3.배틀게임");
			System.out.println("4.영단어 PVP게임");
			System.out.println("5.두더지 잡기게임");
			System.out.println("6.종료");
			String menunum = in.nextLine();
			if (menunum.equals("1")) {
				game2();
			} else if (menunum.equals("2")) {
				game3();
			} else if (menunum.equals("3")) {
				text();
			} else if (menunum.equals("4")) {
				game_start();
			} else if (menunum.equals("5")) {
				startGame();
			} else if (menunum.equals("7")) {
				System.out.println("종료");
				break;
			}
			i--;
			System.out.println("-------------------");
		}

	}

	// 10개 단어와 뜻 입력
	public static void InputWord() {
		System.out.println(green + "***영어단어 외우기게임***" + exit);
		System.out.println("5개는 단어 5개는 뜻을 입력하시오");
		for (int i = 0; i < EnglishWord.length; i++) {
			EnglishWord[i] = in.nextLine();
		}
		System.out.println("단어의 뜻을 영어단어 입력한 순서에 맞게 입력하세요.");
		for (int i = 0; i < EnglishWord.length; i++) {
			EnglishK[i] = in.nextLine();
		}
		System.out.println();
	}

	// 입력값 출력
	public static void OutputWord() {
		System.out.println("-------------------");
		System.out.println(cyan + "등록한 단어와 뜻 목록: " + exit);
		for (int i = 0; i < EnglishWord.length; i++) {
			System.out.println(i + 1 + "번째 영단어:" + EnglishWord[i] + " ");
		}
		System.out.println("-------------------");
		for (int i = 0; i < EnglishWord.length; i++) {
			System.out.println(i + 1 + "번째 영단어 뜻: " + EnglishK[i] + " ");
		}
		System.out.println();
	}

	public static void Search() {
		// 입력한 값이 단어와 맞으면 출력 아니면 없음 출력
		System.out.println("검색할 단어를 입력하시오");
		String b = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (EnglishWord[i].equals(b)) {
				System.out.println("영단어: " + EnglishWord[i]);
				System.out.println("단어뜻: " + EnglishK[i]);
				break;
			} else if (!(b.length() == (EnglishWord[i].length() - 1))) {
				int cnt = 0;

				for (int j = 0; j < EnglishWord[i].length() - 1; j++) {
					if (j < b.length()) {
						if (b.charAt(j) == EnglishWord[i].charAt(j)) {
							cnt++;
						}
						if (cnt >= EnglishWord[i].length() - 1) {
							System.out.println(EnglishWord[i]);
							System.out.println(EnglishK[i]);
						}
					}
				}
			}
			if (i == EnglishWord.length - 1) { // 마지막 요소까지 갔는데도 찾지못했다면"없음" -1 하는이유는 인덱스는0부터 시작하지만 length는 1부터 시작하기때문에.
				System.out.println("없음");
			}
		}
	}

	// 단어 삭제
	public static void Delete() {
		System.out.println("삭제할 단어를 입력하시오");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (InputWord.equals(EnglishWord[i])) {
				EnglishWord[i] = "";
				EnglishK[i] = "";
				System.out.println("단어가 삭제되었습니다.");
			}
		}

	}

	// 단어 업데이트(수정)
	public static void Update() {
		System.out.println("변경전 단어를 입력하세요.(공백일경우 엔터)");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (InputWord.equals(EnglishWord[i])) {
				System.out.println("변경후 단어를 입력하세요.");
				EnglishWord[i] = in.nextLine();
			}
		}
		System.out.println("변경전 영어단어 뜻을 입력하세요.(공백일경우 엔터)");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishK.length; i++) {
			if (InputWord.equals(EnglishK[i])) {
				System.out.println("변경후 영어단어 뜻을 입력하세요.");
				EnglishK[i] = in.nextLine();
				System.out.println("단어가 수정되었습니다.");
			}
		}
	}

	// 영단어 PVP게임기능
	public static void game_start() {
		InputWord();
		OutputWord();
		p1 = 15;
		p2 = 16;
		System.out.println("-------------------");
		System.out.println("   _____          __  __ ______ ");
		System.out.println("  / ____|   /\\   |  \\/  |  ____|");
		System.out.println(" | |  __   /  \\  | \\  / | |__   ");
		System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|  ");
		System.out.println(" | |__| |/ ____ \\| |  | | |____ ");
		System.out.println("  \\_____/_/    \\_\\_|  |_|______|");
		System.out.println("                               ");
		System.out.println("영단어 pvp게임 입니다.");
		System.out.println("P1풀레이어 체력은" + p1 + "P2" + "플레이어체력은 " + p2 + "입니다.");
		System.out.println("상대방의 체력이 먼저 0이되면 승리합니다.");
		boolean flag = true;
		while (flag) {
			System.out.println("P1님 차례입니다. (남은 HP: " + p1 + ")");
			System.out.println("엔터를 누르면 게임이 시작됩니다.");
			damage = 0;
			in.nextLine();
			System.out.println("주어진 뜻에맞는 영어단어를 입력하세요.");
			System.out.println("-------------------");
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				System.out.println(EnglishK[random]);
				String b = in.nextLine();
				if (EnglishWord[random].equals(b)) {
					damage++;
					System.out.println(green + "정답입니다!" + exit + "(누적데미지+" + damage + ")");
				} else {
					System.out.println("오답입니다.");
				}
			}
			p2 -= damage;
			System.out.println("p2에게" + damage + "만큼 피해를 주었습니다.");
			if (p1 < 1 || p2 < 1) {
				flag = false;
				System.out.println(green + "p2체력이 0이 되었습니다 p1이 승리하였습니다!" + exit);
				System.out.println(" __          _______ _   _ ");
				System.out.println(" \\ \\        / /_   _| \\ | |");
				System.out.println("  \\ \\  /\\  / /  | | |  \\| |");
				System.out.println("   \\ \\/  \\/ /   | | | . ` |");
				System.out.println("    \\  /\\  /   _| |_| |\\  |");
				System.out.println("     \\/  \\/   |_____|_| \\_|");
				System.out.println("                          ");
				break;
			}
			System.out.println("P2님 차례입니다. (남은 HP: " + p2 + ")");
			System.out.println("엔터를 누르면 게임이 시작됩니다.");
			in.nextLine();
			damage = 0;
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				System.out.println(EnglishK[random]);
				String b = in.nextLine();
				if (EnglishWord[random].equals(b)) {
					damage++;
					System.out.println(green + "정답입니다!" + exit + "(누적데미지+" + damage + ")");
				} else {
					System.out.println(red + "오답입니다." + exit);
				}
			}
			p1 -= damage;
			if (p1 < 1 || p2 < 1) {
				flag = false;
				System.out.println(green + "p1체력이 0이 되었습니다 p2가 승리하였습니다!" + exit);
				System.out.println(" __          _______ _   _ ");
				System.out.println(" \\ \\        / /_   _| \\ | |");
				System.out.println("  \\ \\  /\\  / /  | | |  \\| |");
				System.out.println("   \\ \\/  \\/ /   | | | . ` |");
				System.out.println("    \\  /\\  /   _| |_| |\\  |");
				System.out.println("     \\/  \\/   |_____|_| \\_|");
				System.out.println("                          ");
				break;
			}
		}
	}

	// 게임시작(라운드수 설정)
	public static void startGame() {
		damage = 0;
		System.out.println("***두더지 잡기게임 시작***");
		System.out.println("총 5라운드로 진행됩니다.");
		System.out.println("시작하려면 엔터를 눌러주세요");
		in.nextLine();
		for (int i = 0; i < 5; i++) {
			System.out.println("-----" + (i + 1) + "라운드" + "-----");
			randomMole();
		}
		finish();

	}

	// 두더지 랜덤배치
	public static void randomMole() {
		boardmain();
		moleX = r.nextInt(3);
		moleY = r.nextInt(3);
		board[moleX][moleY] = mole;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "      ");
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("----------------");
		input();
		check();
	}

	// 게임판
	public static void boardmain() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = hole;
			}
		}
	}

	// 정답 키보드 입력
	public static void input() {
		while (true) {
			System.out.print("두더지를 잡을 위치를 입력하세요 (예: 1 2): ");
			inputX = in.nextInt();
			inputY = in.nextInt();
			in.nextLine();
			if (check2(inputX, inputY)) { //
				break;
			}
			System.out.println("잘못된 입력입니다. 0~2 사이의 숫자를 입력하세요.");
			System.out.println("----------------");
		}

	}

	// 입력값 오류체크
	public static boolean check2(int inputX, int inputY) {
		return inputX >= 0 && inputX < 3 && inputY >= 0 && inputY < 3;
	}

	// 정답비교
	public static void check() {
		if (moleX == inputX && moleY == inputY) {
			System.out.println("두더지를 잡았어요!(+20점)");
			damage += 20;
		} else {
			System.out.println("두더지를 놓쳤어요");
			cnt++;
		}
	}

	// 두더지잡기 결과 결산
	public static void finish() {
		System.out.println("게임이 종료되었습니다.");
		System.out.println("최종점수는 " + damage + "점 입니다.");
		System.out.println("놓친두더지는 " + cnt + "마리 입니다.");
	}

	///////////////////////////////////////////////////////////////////////////
	// 덧셈게임//
	public static void game2() {
		System.out.println("-------------------");
		System.out.println("덧샘 pvp게임 입니다.");
		System.out.println("랜덤으로 더할 숫자를 등록해주세요.");
		save();
		how();
		in.nextLine();
		gamestar();

	}

	public static void save() {
		System.out.println("숫자를 집어 넣으세요.");
		for (int i = 0; i < 5; i++) {
			int a = in.nextInt();

			if (check(a) == 1) {
				i--;
				System.out.println("중복입니다. 다시 작성하세요.");
			} else if (check(a) == 2) {
				num[i] = a;
				if (i < 4) {
					System.out.println("다음숫자를 넣어주세요");
				}
			}
		}

	}

	public static int check(int a) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] == a) {
				return 1;
			}
		}
		return 2;

	}

	public static void how() {
		System.out.println("P1풀레이어 체력은20, P2 플레이어체력은 22입니다. (정답일때 상대방한테 2 데미지를 줌)");
		System.out.println("상대방의 체력이 먼저 0이되면 승리합니다.");
		System.out.println("엔터를 누르면 게임이 시작됩니다.");

	}

	public static void gamestar() {
		count1();
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("P1님 차례입니다. (남은 HP: " + p1 + ")");

			damage = 0;

			System.out.println();
			System.out.println("시작합니다~");
			System.out.println("-----------------------------");
			System.out.println("주어진 식에 답을 구하시오.");
			System.out.println("-------------------");
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				int random2 = r.nextInt(5);
				System.out.println(num[random] + "+" + num[random2]);

				int b = in.nextInt();

				if ((num[random] + num[random2]) == b) {
					damage += 2;
					System.out.println("정답입니다!.(누적데미지+" + damage + ")");
				} else {
					System.out.println("오답입니다.");
				}
			}
			p2 -= damage;
			if (p2 < 1) {
				flag = false;
				System.out.println("p2체력이 0이 되었습니다 p1이 승리하였습니다!");
				System.out.println("종료합니다.");
				break;
			}
			System.out.println("P2님 차례입니다. (남은 HP: " + p2 + ")");
			System.out.println("엔터를 누르면 게임이 시작됩니다.");
			in.nextLine();
			damage = 0;
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				int random2 = r.nextInt(5);
				System.out.println(num[random] + "+" + num[random2]);

				int b = in.nextInt();

				if ((num[random] + num[random2]) == b) {
					damage += 2;
					System.out.println("정답입니다!.(누적데미지+" + damage + ")");
				} else {
					System.out.println("오답입니다.");
				}
			}
			p1 -= damage;
			if (p1 < 1) {
				flag = false;
				System.out.println("p1체력이 0이 되었습니다 p2가 승리하였습니다!");
				System.out.println("종료합니다.");
				break;
			}
		}
	}

	/////////////////////////////////
	/* 미로게임 */
	public static void game3() {
		System.out.println("3찾기 게임입니다. 저희 찾기 게임은 이러한 식으로  생겼습니다.");
		show();
		System.out.println("숫자 2와 3이 만나면 게임이 끝납니다.");
		System.out.println("엔터를 치면 게임을 시작하겠습니다.");
		in.nextLine();
		count();
		playmap();
	}

	public static void show() {

		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[0].length; j++) {
				System.out.print(map1[i][j] + "  ");
			}
			System.out.println();
			System.out.println();

		}

	}

	public static void count() {
		for (int i = 5; i > 0; i--) {
			System.out.print(i + "! ");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

	}

	public static void playmap() {
		System.out.println("-------------------------------------");
		System.out.println();

		System.out.println("움직일 곳으로 위 아래 오른쪽 왼쪽을 치시오  ");
		move();

	}

	public static void move() {
		boolean flag2 = true;
		while (flag2) {
			show();
			String type = in.nextLine();
			boolean flag = true;
			for (int i = 0; i < map1.length; i++) {
				if (map1[9][9] == 2) {
					flag2 = false;
					break;
				}
				if (!flag) {
					break;
				}

				for (int j = 0; j < map1[0].length; j++) {
					if (map1[i][j] == 2) { // 현재 위치가 2일 때만 이동
						if (type.equals("위") && i - 1 >= 0) {
							map1[i][j] = 0; // 현재 위치를 0으로 설정
							map1[i - 1][j] = 2; // 위로 이동
							flag = false;
							break;

						} else if (type.equals("아래") && i + 1 < map1.length) {
							map1[i][j] = 0;
							map1[i + 1][j] = 2;
							flag = false;
							break;

						} else if (type.equals("왼쪽") && j - 1 >= 0) {
							map1[i][j] = 0;
							map1[i][j - 1] = 2;
							flag = false;
							break;

						} else if (type.equals("오른쪽") && j + 1 < map1[0].length) {
							map1[i][j] = 0;
							map1[i][j + 1] = 2;
							flag = false;
							break;

						} else {
							System.out.println("범위를 벗어났습니다. 다시 작성하세요");

						}

					}
				}

			}

		}
		System.out.println("만났습니다.");
		System.out.println(" __          _______ _   _ ");
		System.out.println(" \\ \\        / /_   _| \\ | |");
		System.out.println("  \\ \\  /\\  / /  | | |  \\| |");
		System.out.println("   \\ \\/  \\/ /   | | | . ` |");
		System.out.println("    \\  /\\  /   _| |_| |\\  |");
		System.out.println("     \\/  \\/   |_____|_| \\_|");
		System.out.println("                          ");

	}

	public static void count1() {
		for (int i = 5; i > 0; i--) {
			System.out.print(i + "! ");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

	}

	///////////////////////////////////
	// 배틀게임//
	public static void game_p1_movement() { // 1p 이동
		printMap();
		System.out.println("플레이어 1 이동 (w:위, s:아래, a:왼쪽, d:오른쪽): ");
		String move = in.nextLine();
		boolean moved = false;
		switch (move) {
		case "w":
			if (p1_row > 0) {
				p1_movement_up();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "s":
			if (p1_row < 4) {
				p1_movement_down();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "a":
			if (p1_col > 0) {
				p1_movement_left();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "d":
			if (p1_col < 4) {
				p1_movement_right();
				moved = true;
				printMap();
			} else {
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

	public static void game_p2_movement() { // 2p 이동
		System.out.println("플레이어 2 이동 (w:위, s:아래, a:왼쪽, d:오른쪽): ");
		String move = in.nextLine();
		boolean moved = false;
		switch (move) {
		case "w":
			if (p2_row > 0) {
				p2_movement_up();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "s":
			if (p2_row < 4) {
				p2_movement_down();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "a":
			if (p2_col > 0) {
				p2_movement_left();
				moved = true;
				printMap();
			} else {
				System.out.println("범위를 벗어났습니다");
			}
			break;
		case "d":
			if (p2_col < 4) {
				p2_movement_right();
				moved = true;
				printMap();
			} else {
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

	public static void game_p1_melee_acttack() { // 1p 근접공격
		printMap();
		System.out.println("플레이어 1 공격 (i:위 근접공격, k:아래 근접공격, j:왼쪽 근접공격, l:오른쪽 근접공격): ");
		String attack = in.nextLine();
		boolean attacked = false;
		switch (attack) {
		case "i":
			if (p1_row == p2_row + 1 && p1_col == p2_col && p1_row > 0) {
				p1_melee_acttack_up();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "k":
			if (p1_row == p2_row - 1 && p1_col == p2_col && p1_row < 4) {
				p1_melee_acttack_down();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "j":
			if (p1_row == p2_row && p1_col == p2_col + 1 && p1_col > 0) {
				p1_melee_acttack_left();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "l":
			if (p1_row == p2_row && p1_col == p2_col - 1 && p1_col < 4) {
				p1_melee_acttack_right();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}

	}

	public static void game_p2_melee_acttack() {// 2p 근접공격
		printMap();
		System.out.println("플레이어 2 공격 (i:위 근접공격, k:아래 근접공격, j:왼쪽 근접공격, l:오른쪽 근접공격): ");
		String attack = in.nextLine();
		boolean attacked = false;
		switch (attack) {
		case "i":
			if (p2_row == p1_row + 1 && p2_col == p1_col && p2_row > 0) {
				p2_melee_acttack_up();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "k":
			if (p2_row == p1_row - 1 && p2_col == p1_col && p2_row < 4) {
				p2_melee_acttack_down();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "j":
			if (p2_row == p1_row && p2_col == p1_col + 1 && p2_col > 0) {
				p2_melee_acttack_left();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "l":
			if (p2_row == p1_row && p2_col == p1_col - 1 && p2_col < 4) {
				p2_melee_acttack_right();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다 ");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}
	}

	public static void game_p1_ranged_attack() {// 1p 원거리 공격
		printMap();
		System.out.println("플레이어 1 공격 (i:위 원거리공격, k:아래 원거리공격, j:왼쪽 원거리공격, l:오른쪽 원거리공격): ");
		String attack = in.nextLine();
		boolean attacked = false;
		switch (attack) {
		case "i":
			if (p1_row == p2_row + 2 && p1_col == p2_col && p1_row > 0) {
				p1_ranged_attack_up();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "k":
			if (p1_row == p2_row - 2 && p1_col == p2_col && p1_row < 4) {
				p1_ranged_attack_down();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "j":
			if (p1_row == p2_row && p1_col == p2_col + 2 && p1_col > 0) {
				p1_ranged_attack_left();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "l":
			if (p1_row == p2_row && p1_col == p2_col - 2 && p1_col < 4) {
				p1_ranged_attack_right();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}

	}

	public static void game_p2_ranged_attack() {//2p 원거리 공격
		printMap();
		System.out.println("플레이어 2 공격 (i:위 원거리공격, k:아래 원거리공격, j:왼쪽 원거리공격, l:오른쪽 원거리공격): ");
		String attack = in.nextLine();
		boolean attacked = false;
		switch (attack) {
		case "i":
			if (p2_row == p1_row + 2 && p2_col == p1_col && p2_row > 0) {
				p2_ranged_attack_up();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "k":
			if (p2_row == p1_row - 2 && p2_col == p1_col && p2_row < 4) {
				p2_ranged_attack_down();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "j":
			if (p2_row == p1_row && p2_col == p1_col + 2 && p2_col > 0) {
				p2_ranged_attack_left();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		case "l":
			if (p2_row == p1_row && p2_col == p1_col - 2 && p2_col < 4) {
				p2_ranged_attack_right();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("빗맞았습니다");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다 i,k,j,l중에서 입력하십시오");
		}

	}

	public static void p1_movement_up() {
		if (p1_row > 0) {
			map[p1_row][p1_col] = 0;
			p1_row--;
			map[p1_row][p1_col] = p1;
		}
	}

	public static void p1_movement_down() {
		if (p1_row < 4) {
			map[p1_row][p1_col] = 0;
			p1_row++;
			map[p1_row][p1_col] = p1;
		}
	}

	public static void p1_movement_left() {
		if (p1_col > 0) {
			map[p1_row][p1_col] = 0;
			p1_col--;
			map[p1_row][p1_col] = p1;
		}
	}

	public static void p1_movement_right() {
		if (p1_col < 4) {
			map[p1_row][p1_col] = 0;
			p1_col++;
			map[p1_row][p1_col] = p1;
		}
	}

	// p2 움직임 메소드들
	public static void p2_movement_up() {
		if (p2_row > 0) {
			map[p2_row][p2_col] = 0;
			p2_row--;
			map[p2_row][p2_col] = p2;
		}
	}

	public static void p2_movement_down() {
		if (p2_row < 4) {
			map[p2_row][p2_col] = 0;
			p2_row++;
			map[p2_row][p2_col] = p2;
		}
	}

	public static void p2_movement_left() {
		if (p2_col > 0) {
			map[p2_row][p2_col] = 0;
			p2_col--;
			map[p2_row][p2_col] = p2;
		}
	}

	public static void p2_movement_right() {
		if (p2_col < 4) {
			map[p2_row][p2_col] = 0;
			p2_col++;
			map[p2_row][p2_col] = p2;
		}
	}

	// 맵 출력을 위한 도우미 메소드
	public static void printMap() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + "   ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static void p1_melee_acttack_up() {
		if (p1_row == p2_row + 1 && p1_col == p2_col && p1_row > 0) {
			p2hp -= 4;

		}
	}

	public static void p1_melee_acttack_down() {
		if (p1_row == p2_row - 1 && p1_col == p2_col && p1_row < 4) {
			p2hp -= 4;

		}
	}

	public static void p1_melee_acttack_left() {
		if (p1_row == p2_row && p1_col == p2_col + 1 && p1_col > 0) {
			p2hp -= 4;

		}
	}

	public static void p1_melee_acttack_right() {
		if (p1_row == p2_row && p1_col == p2_col - 1 && p1_col < 4) {
			p2hp -= 4;

		}

	}

	public static void p1_melee_acttack_sysout() {
		System.out.println("p2의 체력이 4 데미지 받았습니다");
		System.out.println("p2의 체력은 :" + p2hp);
	}

	public static void p1_ranged_attack_up() {
		if (p1_row == p2_row + 2 && p1_col == p2_col && p1_row > 0) {
			p2hp -= 2;
		}
	}

	public static void p1_ranged_attack_down() {
		if (p1_row == p2_row - 2 && p1_col == p2_col && p1_row < 4) {
			p2hp -= 2;
		}
	}

	public static void p1_ranged_attack_left() {
		if (p1_row == p2_row && p1_col == p2_col + 2 && p1_col > 0) {
			p2hp -= 2;
		}
	}

	public static void p1_ranged_attack_right() {
		if (p1_row == p2_row && p1_col == p2_col - 2 && p1_col < 4) {
			p2hp -= 2;
		}

	}

	public static void p1_ranged_attack_sysout() {
		System.out.println("p2의 체력이 2 데미지 받았습니다");
		System.out.println("p2의 체력은 :" + p2hp);
	}

	// ----------------------------------------------------------------------------------------------------------
	public static void p2_melee_acttack_up() {
		if (p2_row == p1_row + 1 && p2_col == p1_col && p2_row > 0) {
			p1hp -= 4;

		}
	}

	public static void p2_melee_acttack_down() {
		if (p2_row == p1_row - 1 && p2_col == p1_col && p2_row < 4) {
			p1hp -= 4;

		}
	}

	public static void p2_melee_acttack_left() {
		if (p2_row == p1_row && p2_col == p1_col + 1 && p2_col > 0) {
			p1hp -= 4;

		}
	}

	public static void p2_melee_acttack_right() {
		if (p2_row == p1_row && p2_col == p1_col - 1 && p2_col < 4) {
			p1hp -= 4;

		}

	}

	public static void p2_melee_acttack_sysout() {
		System.out.println("p1의 체력이 4 데미지 받았습니다");
		System.out.println("p1의 체력은 :" + p1hp);
	}

	public static void p2_ranged_attack_up() {
		if (p2_row == p1_row + 2 && p2_col == p1_col && p2_row > 0) {
			p1hp -= 2;
		}
	}

	public static void p2_ranged_attack_down() {
		if (p2_row == p1_row - 2 && p2_col == p1_col && p2_row < 4) {
			p1hp -= 2;
		}
	}

	public static void p2_ranged_attack_left() {
		if (p2_row == p1_row && p2_col == p1_col + 2 && p2_col > 0) {
			p1hp -= 2;
		}
	}

	public static void p2_ranged_attack_right() {
		if (p2_row == p1_row && p2_col == p1_col - 2 && p2_col < 4) {
			p1hp -= 2;
		}

	}

	public static void p2_ranged_attack_sysout() {
		System.out.println("p1의 체력이 2 데미지 받았습니다");
		System.out.println("p1의 체력은 :" + p1hp);
	}

	public static void text() { 
		System.out.println("이동과 공격은 대각선 이외로 사용할 수 있습니다");
		System.out.println("이동은 한칸씩만 가능합니다");
		System.out.println("근접공격은 4데미지이고 적이 바로 근처에 있을때 가능합니다");
		System.out.println("원거리 공격은 2데미지이고 적이 두 칸 차이로 있을때 가능합니다");
		System.out.println("플레이어의 체력은 둘다 40으로 시작입니다.");
		System.out.println();
		System.out.println();

		String button = "";
		for (int i = 0; i < 1000; i++) {
			if (i % 2 == 0 || p1hp >= 0) { // 짝수일 경우 1p 턴

				System.out.println("플레이어1의 턴입니다");
				System.out.println("1을 누르면 이동 2를 누르면 근접공격 3을 누르면 원거리공격");
				button = in.nextLine();
				if (button.equals("1")) {
					game_p1_movement();
				}
				if (button.equals("2")) {
					game_p1_melee_acttack();
				}
				if (button.equals("3")) {
					game_p1_ranged_attack();
				}

			} else {
				System.out.println("플레이어1가 죽었습니다 게임을 종료합니다.");
				break;
			}
			if (i % 2 != 0 || p2hp >= 0) { // 짝수일 경우 2p
				System.out.println("플레이어2의 턴입니다");
				System.out.println("1을 누르면 이동 2를 누르면 근접공격 3을 누르면 원거리공격");
				button = in.nextLine();
				if (button.equals("1")) {
					game_p2_movement();
				}
				if (button.equals("2")) {
					game_p2_melee_acttack();
				}
				if (button.equals("3")) {
					game_p2_ranged_attack();
				}
			} else {
				System.out.println("플레이어2가 죽었습니다 게임을 종료합니다.");
				break;
			}
		}

	}

}