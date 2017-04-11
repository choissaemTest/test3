package ������_30110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Main {

	static String filePath = "c:\\test\\30110_������";
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		diplayMenu();

		int choice = -1;

		while (choice != 0) {
			choice = inputChoice();

			switch (choice) {
			case 1:
				printBooks();
				break;
			case 2:
				searchBook();
				break;
			case 3:
				insertBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				lentBook();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
			}
		}
	}

	private static void lentBook() throws IOException {

		System.out.println("å �뿩");
		System.out.println("�뿩�ϰ� ���� å�� �˻��ض�");
		Book b = new Book();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));

		scan.nextLine();
		String str = "";
		String kw = scan.nextLine();
		try {

			while ((str = br.readLine()) != null) {
				if (str.contains(kw)) {
					System.out.println(str);
					System.out.println("�뿩 ���θ� ������. " );
				}
			}
			br.close();
		} catch (IOException e) {

			System.out.println("������ ���� �����ϴ�.");
			e.printStackTrace();
		}
		
	}

	private static void diplayMenu() {
		System.out.println("���� ���� ���α׷� �Դϴ�.");
		System.out.println("1.��ü ���� ���");
		System.out.println("2.���� �˻�");
		System.out.println("3.�ű� ���� �߰�");
		System.out.println("4.���� ���� ���");
		System.out.println("5.���� �뿩");
		System.out.println("0.���α׷� ����");
	}

	private static int inputChoice() {
		int choice = -1;

		System.out.println("�����ϼ��� : ");
		choice = scan.nextInt();
		System.out.println("������ �� : " + choice);
		System.out.println("");
		return choice;
	}

	private static void deleteBook() {
		System.out.println("å ����");
		// TODO Auto-generated method stub

	}

	private static void insertBook() throws IOException {

		Book b = new Book();

		System.out.println("å �߰�");

		System.out.println("�߰��� å�� ������ �Է��ϼ���");

		scan.nextLine();
		System.out.print("å ���� : ");
		b.setName(scan.nextLine());

		System.out.print("�� �� : ");
		b.setAuthor(scan.nextLine());

		System.out.print("���ǻ� : ");
		b.setPublisher(scan.nextLine());

		System.out.print("�� �� : ");
		b.setCost(scan.nextLine());
		
		System.out.print("�뿩 ���� : ");
		b.setLent(scan.nextLine());

		System.out.println(b.toString());

		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));

		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getCost() +  "\t" +b.getLent());
		bw.newLine();
		bw.close();

	}

	private static void searchBook() throws FileNotFoundException {
		System.out.println("å �˻�");
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		scan.nextLine();
		String str = "";
		String kw = scan.nextLine();
		try {

			while ((str = br.readLine()) != null) {
				if (str.contains(kw)) {
					System.out.println(str);
				}
			}
			br.close();
		} catch (IOException e) {

			System.out.println("������ ���� �����ϴ�.");
			e.printStackTrace();
		}
	}

	private static void printBooks() throws FileNotFoundException {
		System.out.println("��ü ���� ���");
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		String str = "";

		try {
			while ((str = br.readLine()) != null) {

				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {

			System.out.println("������ ���� �����ϴ�.");
			e.printStackTrace();
		}
	}

}
