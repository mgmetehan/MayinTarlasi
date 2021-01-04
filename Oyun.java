package game;

import java.util.Scanner;

public class Oyun {
	Scanner scan = new Scanner(System.in);

	int sutun, satir, size;
	int[][] mayin;
	int[][] map;

	public void start() {
		bomba();
		show(mayin);
		run();
	}

	public Oyun(int sutun, int satir) {
		this.satir = satir;
		this.sutun = sutun;
		this.size = satir * sutun;
		this.map = new int[satir][sutun];
		this.mayin = new int[satir][sutun];
	}

	public void run() {
		int i, j;
		boolean life = true;
		System.out.println("---------------------------");
		System.out.println("Gitmek istediginiz satir ve sütünu belirtiniz: ");
		while (life) {
			System.out.print("Satir: ");
			i = scan.nextInt();

			System.out.print("Sutun: ");
			j = scan.nextInt();

			if (i < 0 || i > satir) {
				System.out.println("Gecersiz islem!!!");
				continue;
			}
			if (j < 0 || j > satir) {
				System.out.println("Gecersiz islem!!!");
				continue;
			}
			if (mayin[i][j] != -1) {
				check(i, j);
			} else {// mayina basma durumu
				System.out.println("Bombaya Bastiniz!!\nGame OVER!!!!!");
				life = false;
				break;
			}
			if (finish() == 0) {
				System.out.println("\n|Oyunu Kazandiniz!!!!!!!!!");
				break;
			}
			show(map);
		}
	}

	public void check(int x, int y) {
		int kontrol = 0;
		if ((x > 0) && (mayin[x - 1][y] == -1)) {
			map[x][y]++;
			kontrol++;
		}
		if ((x < satir - 1) && (mayin[x + 1][y] == -1)) {
			map[x][y]++;
			kontrol++;
		}
		if ((y > 0) && (mayin[x][y - 1] == -1)) {
			map[x][y]++;
			kontrol++;
		}
		if ((y < sutun - 1) && (mayin[x][y + 1] == -1)) {
			map[x][y]++;
			kontrol++;
		}
		if (mayin[x][y] == 0) {
			mayin[x][y] = -2;
		}
		if (kontrol == 0) {
			map[x][y] = 9;
			mayin[x][y] = 9;
		}
	}

	public void bomba() {
		int bomsatir, bomsutun, i = 0;

		while ((size / 4) != i) {
			bomsatir = (int) (Math.random() * satir);
			bomsutun = (int) (Math.random() * sutun);

			if (mayin[bomsatir][bomsutun] != -1) {
				mayin[bomsatir][bomsutun] = -1;
				i++;
			}
		}
	}

	public void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int finish() {
		int finish = 0;
		for (int i = 0; i < mayin.length; i++) {
			for (int j = 0; j < mayin[0].length; j++) {
				if (mayin[i][j] == 0) {
					finish++;
				}
			}
		}
		return finish;
	}
}