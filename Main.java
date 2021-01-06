package game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int satir, sutun;

		System.out.println("Mayin Tarlasi Oyununa Hos Geldiniz!");
		System.out.println("Kac kaclik alan yaratilisin");
		System.out.print("Satir: ");
		satir = scan.nextInt();
		System.out.print("Sutun: ");
		sutun = scan.nextInt();

		System.out.println("-1->Mayin\t-2->Mayin Yok\t 9->Onceden Ziyaret Edilen Nokta");
		Oyun gm = new Oyun(satir, sutun);
		gm.start();
	}
}
