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
	static int p1_row = 4; // p1�� �ʱ� �� ��ġ
	static int p1_col = 0; // p1�� �ʱ� �� ��ġ
	static int p2_row = 0; // p2�� �ʱ� �� ��ġ
	static int p2_col = 4; // p2�� �ʱ� �� ��ġ
	static int[][] map = { { 0, 0, 0, 0, p2 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ p1, 0, 0, 0, 0 } };

	public static void main(String[] args) {

		System.out.println("-------------------");
		for (int i = 0; i < 2; i++) {
			System.out.println(purple + "�޴��� ���ڷ� �����Ͻÿ�" + exit);
			System.out.println("1.��������");
			System.out.println("2.�����°���");
			System.out.println("3.��Ʋ����");
			System.out.println("4.���ܾ� PVP����");
			System.out.println("5.�δ��� ������");
			System.out.println("6.����");
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
				System.out.println("����");
				break;
			}
			i--;
			System.out.println("-------------------");
		}

	}

	// 10�� �ܾ�� �� �Է�
	public static void InputWord() {
		System.out.println(green + "***����ܾ� �ܿ�����***" + exit);
		System.out.println("5���� �ܾ� 5���� ���� �Է��Ͻÿ�");
		for (int i = 0; i < EnglishWord.length; i++) {
			EnglishWord[i] = in.nextLine();
		}
		System.out.println("�ܾ��� ���� ����ܾ� �Է��� ������ �°� �Է��ϼ���.");
		for (int i = 0; i < EnglishWord.length; i++) {
			EnglishK[i] = in.nextLine();
		}
		System.out.println();
	}

	// �Է°� ���
	public static void OutputWord() {
		System.out.println("-------------------");
		System.out.println(cyan + "����� �ܾ�� �� ���: " + exit);
		for (int i = 0; i < EnglishWord.length; i++) {
			System.out.println(i + 1 + "��° ���ܾ�:" + EnglishWord[i] + " ");
		}
		System.out.println("-------------------");
		for (int i = 0; i < EnglishWord.length; i++) {
			System.out.println(i + 1 + "��° ���ܾ� ��: " + EnglishK[i] + " ");
		}
		System.out.println();
	}

	public static void Search() {
		// �Է��� ���� �ܾ�� ������ ��� �ƴϸ� ���� ���
		System.out.println("�˻��� �ܾ �Է��Ͻÿ�");
		String b = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (EnglishWord[i].equals(b)) {
				System.out.println("���ܾ�: " + EnglishWord[i]);
				System.out.println("�ܾ��: " + EnglishK[i]);
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
			if (i == EnglishWord.length - 1) { // ������ ��ұ��� ���µ��� ã�����ߴٸ�"����" -1 �ϴ������� �ε�����0���� ���������� length�� 1���� �����ϱ⶧����.
				System.out.println("����");
			}
		}
	}

	// �ܾ� ����
	public static void Delete() {
		System.out.println("������ �ܾ �Է��Ͻÿ�");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (InputWord.equals(EnglishWord[i])) {
				EnglishWord[i] = "";
				EnglishK[i] = "";
				System.out.println("�ܾ �����Ǿ����ϴ�.");
			}
		}

	}

	// �ܾ� ������Ʈ(����)
	public static void Update() {
		System.out.println("������ �ܾ �Է��ϼ���.(�����ϰ�� ����)");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishWord.length; i++) {
			if (InputWord.equals(EnglishWord[i])) {
				System.out.println("������ �ܾ �Է��ϼ���.");
				EnglishWord[i] = in.nextLine();
			}
		}
		System.out.println("������ ����ܾ� ���� �Է��ϼ���.(�����ϰ�� ����)");
		InputWord = in.nextLine();
		for (int i = 0; i < EnglishK.length; i++) {
			if (InputWord.equals(EnglishK[i])) {
				System.out.println("������ ����ܾ� ���� �Է��ϼ���.");
				EnglishK[i] = in.nextLine();
				System.out.println("�ܾ �����Ǿ����ϴ�.");
			}
		}
	}

	// ���ܾ� PVP���ӱ��
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
		System.out.println("���ܾ� pvp���� �Դϴ�.");
		System.out.println("P1Ǯ���̾� ü����" + p1 + "P2" + "�÷��̾�ü���� " + p2 + "�Դϴ�.");
		System.out.println("������ ü���� ���� 0�̵Ǹ� �¸��մϴ�.");
		boolean flag = true;
		while (flag) {
			System.out.println("P1�� �����Դϴ�. (���� HP: " + p1 + ")");
			System.out.println("���͸� ������ ������ ���۵˴ϴ�.");
			damage = 0;
			in.nextLine();
			System.out.println("�־��� �濡�´� ����ܾ �Է��ϼ���.");
			System.out.println("-------------------");
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				System.out.println(EnglishK[random]);
				String b = in.nextLine();
				if (EnglishWord[random].equals(b)) {
					damage++;
					System.out.println(green + "�����Դϴ�!" + exit + "(����������+" + damage + ")");
				} else {
					System.out.println("�����Դϴ�.");
				}
			}
			p2 -= damage;
			System.out.println("p2����" + damage + "��ŭ ���ظ� �־����ϴ�.");
			if (p1 < 1 || p2 < 1) {
				flag = false;
				System.out.println(green + "p2ü���� 0�� �Ǿ����ϴ� p1�� �¸��Ͽ����ϴ�!" + exit);
				System.out.println(" __          _______ _   _ ");
				System.out.println(" \\ \\        / /_   _| \\ | |");
				System.out.println("  \\ \\  /\\  / /  | | |  \\| |");
				System.out.println("   \\ \\/  \\/ /   | | | . ` |");
				System.out.println("    \\  /\\  /   _| |_| |\\  |");
				System.out.println("     \\/  \\/   |_____|_| \\_|");
				System.out.println("                          ");
				break;
			}
			System.out.println("P2�� �����Դϴ�. (���� HP: " + p2 + ")");
			System.out.println("���͸� ������ ������ ���۵˴ϴ�.");
			in.nextLine();
			damage = 0;
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				System.out.println(EnglishK[random]);
				String b = in.nextLine();
				if (EnglishWord[random].equals(b)) {
					damage++;
					System.out.println(green + "�����Դϴ�!" + exit + "(����������+" + damage + ")");
				} else {
					System.out.println(red + "�����Դϴ�." + exit);
				}
			}
			p1 -= damage;
			if (p1 < 1 || p2 < 1) {
				flag = false;
				System.out.println(green + "p1ü���� 0�� �Ǿ����ϴ� p2�� �¸��Ͽ����ϴ�!" + exit);
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

	// ���ӽ���(����� ����)
	public static void startGame() {
		damage = 0;
		System.out.println("***�δ��� ������ ����***");
		System.out.println("�� 5����� ����˴ϴ�.");
		System.out.println("�����Ϸ��� ���͸� �����ּ���");
		in.nextLine();
		for (int i = 0; i < 5; i++) {
			System.out.println("-----" + (i + 1) + "����" + "-----");
			randomMole();
		}
		finish();

	}

	// �δ��� ������ġ
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

	// ������
	public static void boardmain() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = hole;
			}
		}
	}

	// ���� Ű���� �Է�
	public static void input() {
		while (true) {
			System.out.print("�δ����� ���� ��ġ�� �Է��ϼ��� (��: 1 2): ");
			inputX = in.nextInt();
			inputY = in.nextInt();
			in.nextLine();
			if (check2(inputX, inputY)) { //
				break;
			}
			System.out.println("�߸��� �Է��Դϴ�. 0~2 ������ ���ڸ� �Է��ϼ���.");
			System.out.println("----------------");
		}

	}

	// �Է°� ����üũ
	public static boolean check2(int inputX, int inputY) {
		return inputX >= 0 && inputX < 3 && inputY >= 0 && inputY < 3;
	}

	// �����
	public static void check() {
		if (moleX == inputX && moleY == inputY) {
			System.out.println("�δ����� ��Ҿ��!(+20��)");
			damage += 20;
		} else {
			System.out.println("�δ����� ���ƾ��");
			cnt++;
		}
	}

	// �δ������ ��� ���
	public static void finish() {
		System.out.println("������ ����Ǿ����ϴ�.");
		System.out.println("���������� " + damage + "�� �Դϴ�.");
		System.out.println("��ģ�δ����� " + cnt + "���� �Դϴ�.");
	}

	///////////////////////////////////////////////////////////////////////////
	// ��������//
	public static void game2() {
		System.out.println("-------------------");
		System.out.println("���� pvp���� �Դϴ�.");
		System.out.println("�������� ���� ���ڸ� ������ּ���.");
		save();
		how();
		in.nextLine();
		gamestar();

	}

	public static void save() {
		System.out.println("���ڸ� ���� ��������.");
		for (int i = 0; i < 5; i++) {
			int a = in.nextInt();

			if (check(a) == 1) {
				i--;
				System.out.println("�ߺ��Դϴ�. �ٽ� �ۼ��ϼ���.");
			} else if (check(a) == 2) {
				num[i] = a;
				if (i < 4) {
					System.out.println("�������ڸ� �־��ּ���");
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
		System.out.println("P1Ǯ���̾� ü����20, P2 �÷��̾�ü���� 22�Դϴ�. (�����϶� �������� 2 �������� ��)");
		System.out.println("������ ü���� ���� 0�̵Ǹ� �¸��մϴ�.");
		System.out.println("���͸� ������ ������ ���۵˴ϴ�.");

	}

	public static void gamestar() {
		count1();
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("P1�� �����Դϴ�. (���� HP: " + p1 + ")");

			damage = 0;

			System.out.println();
			System.out.println("�����մϴ�~");
			System.out.println("-----------------------------");
			System.out.println("�־��� �Ŀ� ���� ���Ͻÿ�.");
			System.out.println("-------------------");
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				int random2 = r.nextInt(5);
				System.out.println(num[random] + "+" + num[random2]);

				int b = in.nextInt();

				if ((num[random] + num[random2]) == b) {
					damage += 2;
					System.out.println("�����Դϴ�!.(����������+" + damage + ")");
				} else {
					System.out.println("�����Դϴ�.");
				}
			}
			p2 -= damage;
			if (p2 < 1) {
				flag = false;
				System.out.println("p2ü���� 0�� �Ǿ����ϴ� p1�� �¸��Ͽ����ϴ�!");
				System.out.println("�����մϴ�.");
				break;
			}
			System.out.println("P2�� �����Դϴ�. (���� HP: " + p2 + ")");
			System.out.println("���͸� ������ ������ ���۵˴ϴ�.");
			in.nextLine();
			damage = 0;
			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				int random2 = r.nextInt(5);
				System.out.println(num[random] + "+" + num[random2]);

				int b = in.nextInt();

				if ((num[random] + num[random2]) == b) {
					damage += 2;
					System.out.println("�����Դϴ�!.(����������+" + damage + ")");
				} else {
					System.out.println("�����Դϴ�.");
				}
			}
			p1 -= damage;
			if (p1 < 1) {
				flag = false;
				System.out.println("p1ü���� 0�� �Ǿ����ϴ� p2�� �¸��Ͽ����ϴ�!");
				System.out.println("�����մϴ�.");
				break;
			}
		}
	}

	/////////////////////////////////
	/* �̷ΰ��� */
	public static void game3() {
		System.out.println("3ã�� �����Դϴ�. ���� ã�� ������ �̷��� ������  ������ϴ�.");
		show();
		System.out.println("���� 2�� 3�� ������ ������ �����ϴ�.");
		System.out.println("���͸� ġ�� ������ �����ϰڽ��ϴ�.");
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

		System.out.println("������ ������ �� �Ʒ� ������ ������ ġ�ÿ�  ");
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
					if (map1[i][j] == 2) { // ���� ��ġ�� 2�� ���� �̵�
						if (type.equals("��") && i - 1 >= 0) {
							map1[i][j] = 0; // ���� ��ġ�� 0���� ����
							map1[i - 1][j] = 2; // ���� �̵�
							flag = false;
							break;

						} else if (type.equals("�Ʒ�") && i + 1 < map1.length) {
							map1[i][j] = 0;
							map1[i + 1][j] = 2;
							flag = false;
							break;

						} else if (type.equals("����") && j - 1 >= 0) {
							map1[i][j] = 0;
							map1[i][j - 1] = 2;
							flag = false;
							break;

						} else if (type.equals("������") && j + 1 < map1[0].length) {
							map1[i][j] = 0;
							map1[i][j + 1] = 2;
							flag = false;
							break;

						} else {
							System.out.println("������ ������ϴ�. �ٽ� �ۼ��ϼ���");

						}

					}
				}

			}

		}
		System.out.println("�������ϴ�.");
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
	// ��Ʋ����//
	public static void game_p1_movement() { // 1p �̵�
		printMap();
		System.out.println("�÷��̾� 1 �̵� (w:��, s:�Ʒ�, a:����, d:������): ");
		String move = in.nextLine();
		boolean moved = false;
		switch (move) {
		case "w":
			if (p1_row > 0) {
				p1_movement_up();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "s":
			if (p1_row < 4) {
				p1_movement_down();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "a":
			if (p1_col > 0) {
				p1_movement_left();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "d":
			if (p1_col < 4) {
				p1_movement_right();
				moved = true;
				printMap();
			} else {
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

	public static void game_p2_movement() { // 2p �̵�
		System.out.println("�÷��̾� 2 �̵� (w:��, s:�Ʒ�, a:����, d:������): ");
		String move = in.nextLine();
		boolean moved = false;
		switch (move) {
		case "w":
			if (p2_row > 0) {
				p2_movement_up();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "s":
			if (p2_row < 4) {
				p2_movement_down();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "a":
			if (p2_col > 0) {
				p2_movement_left();
				moved = true;
				printMap();
			} else {
				System.out.println("������ ������ϴ�");
			}
			break;
		case "d":
			if (p2_col < 4) {
				p2_movement_right();
				moved = true;
				printMap();
			} else {
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

	public static void game_p1_melee_acttack() { // 1p ��������
		printMap();
		System.out.println("�÷��̾� 1 ���� (i:�� ��������, k:�Ʒ� ��������, j:���� ��������, l:������ ��������): ");
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
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "k":
			if (p1_row == p2_row - 1 && p1_col == p2_col && p1_row < 4) {
				p1_melee_acttack_down();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "j":
			if (p1_row == p2_row && p1_col == p2_col + 1 && p1_col > 0) {
				p1_melee_acttack_left();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "l":
			if (p1_row == p2_row && p1_col == p2_col - 1 && p1_col < 4) {
				p1_melee_acttack_right();
				attacked = true;
				p1_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}

	}

	public static void game_p2_melee_acttack() {// 2p ��������
		printMap();
		System.out.println("�÷��̾� 2 ���� (i:�� ��������, k:�Ʒ� ��������, j:���� ��������, l:������ ��������): ");
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
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "k":
			if (p2_row == p1_row - 1 && p2_col == p1_col && p2_row < 4) {
				p2_melee_acttack_down();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "j":
			if (p2_row == p1_row && p2_col == p1_col + 1 && p2_col > 0) {
				p2_melee_acttack_left();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "l":
			if (p2_row == p1_row && p2_col == p1_col - 1 && p2_col < 4) {
				p2_melee_acttack_right();
				attacked = true;
				p2_melee_acttack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ� ");
			}
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}
	}

	public static void game_p1_ranged_attack() {// 1p ���Ÿ� ����
		printMap();
		System.out.println("�÷��̾� 1 ���� (i:�� ���Ÿ�����, k:�Ʒ� ���Ÿ�����, j:���� ���Ÿ�����, l:������ ���Ÿ�����): ");
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
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "k":
			if (p1_row == p2_row - 2 && p1_col == p2_col && p1_row < 4) {
				p1_ranged_attack_down();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "j":
			if (p1_row == p2_row && p1_col == p2_col + 2 && p1_col > 0) {
				p1_ranged_attack_left();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "l":
			if (p1_row == p2_row && p1_col == p2_col - 2 && p1_col < 4) {
				p1_ranged_attack_right();
				attacked = true;
				p1_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
		}

	}

	public static void game_p2_ranged_attack() {//2p ���Ÿ� ����
		printMap();
		System.out.println("�÷��̾� 2 ���� (i:�� ���Ÿ�����, k:�Ʒ� ���Ÿ�����, j:���� ���Ÿ�����, l:������ ���Ÿ�����): ");
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
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "k":
			if (p2_row == p1_row - 2 && p2_col == p1_col && p2_row < 4) {
				p2_ranged_attack_down();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "j":
			if (p2_row == p1_row && p2_col == p1_col + 2 && p2_col > 0) {
				p2_ranged_attack_left();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		case "l":
			if (p2_row == p1_row && p2_col == p1_col - 2 && p2_col < 4) {
				p2_ranged_attack_right();
				attacked = true;
				p2_ranged_attack_sysout();
				printMap();
			} else {
				System.out.println("���¾ҽ��ϴ�");
			}
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ� i,k,j,l�߿��� �Է��Ͻʽÿ�");
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

	// p2 ������ �޼ҵ��
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

	// �� ����� ���� ����� �޼ҵ�
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
		System.out.println("p2�� ü���� 4 ������ �޾ҽ��ϴ�");
		System.out.println("p2�� ü���� :" + p2hp);
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
		System.out.println("p2�� ü���� 2 ������ �޾ҽ��ϴ�");
		System.out.println("p2�� ü���� :" + p2hp);
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
		System.out.println("p1�� ü���� 4 ������ �޾ҽ��ϴ�");
		System.out.println("p1�� ü���� :" + p1hp);
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
		System.out.println("p1�� ü���� 2 ������ �޾ҽ��ϴ�");
		System.out.println("p1�� ü���� :" + p1hp);
	}

	public static void text() { 
		System.out.println("�̵��� ������ �밢�� �ܷ̿� ����� �� �ֽ��ϴ�");
		System.out.println("�̵��� ��ĭ���� �����մϴ�");
		System.out.println("���������� 4�������̰� ���� �ٷ� ��ó�� ������ �����մϴ�");
		System.out.println("���Ÿ� ������ 2�������̰� ���� �� ĭ ���̷� ������ �����մϴ�");
		System.out.println("�÷��̾��� ü���� �Ѵ� 40���� �����Դϴ�.");
		System.out.println();
		System.out.println();

		String button = "";
		for (int i = 0; i < 1000; i++) {
			if (i % 2 == 0 || p1hp >= 0) { // ¦���� ��� 1p ��

				System.out.println("�÷��̾�1�� ���Դϴ�");
				System.out.println("1�� ������ �̵� 2�� ������ �������� 3�� ������ ���Ÿ�����");
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
				System.out.println("�÷��̾�1�� �׾����ϴ� ������ �����մϴ�.");
				break;
			}
			if (i % 2 != 0 || p2hp >= 0) { // ¦���� ��� 2p
				System.out.println("�÷��̾�2�� ���Դϴ�");
				System.out.println("1�� ������ �̵� 2�� ������ �������� 3�� ������ ���Ÿ�����");
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
				System.out.println("�÷��̾�2�� �׾����ϴ� ������ �����մϴ�.");
				break;
			}
		}

	}

}