package 안지훈_30110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Main {

	static String filePath = "c:\\test\\30110_안지훈";
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
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	private static void lentBook() throws IOException {

		System.out.println("책 대여");
		System.out.println("대여하고 싶은 책을 검색해라");
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
					System.out.println("대여 여부를 보세요. " );
				}
			}
			br.close();
		} catch (IOException e) {

			System.out.println("지정된 값이 없습니다.");
			e.printStackTrace();
		}
		
	}

	private static void diplayMenu() {
		System.out.println("도서 관리 프로그램 입니다.");
		System.out.println("1.전체 도서 출력");
		System.out.println("2.도서 검색");
		System.out.println("3.신규 도서 추가");
		System.out.println("4.노후 도서 폐기");
		System.out.println("5.도서 대여");
		System.out.println("0.프로그램 종료");
	}

	private static int inputChoice() {
		int choice = -1;

		System.out.println("선택하세요 : ");
		choice = scan.nextInt();
		System.out.println("선택한 값 : " + choice);
		System.out.println("");
		return choice;
	}

	private static void deleteBook() {
		System.out.println("책 삭제");
		// TODO Auto-generated method stub

	}

	private static void insertBook() throws IOException {

		Book b = new Book();

		System.out.println("책 추가");

		System.out.println("추가할 책의 정보를 입력하세요");

		scan.nextLine();
		System.out.print("책 제목 : ");
		b.setName(scan.nextLine());

		System.out.print("저 자 : ");
		b.setAuthor(scan.nextLine());

		System.out.print("출판사 : ");
		b.setPublisher(scan.nextLine());

		System.out.print("가 격 : ");
		b.setCost(scan.nextLine());
		
		System.out.print("대여 여부 : ");
		b.setLent(scan.nextLine());

		System.out.println(b.toString());

		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));

		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getCost() +  "\t" +b.getLent());
		bw.newLine();
		bw.close();

	}

	private static void searchBook() throws FileNotFoundException {
		System.out.println("책 검색");
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

			System.out.println("지정된 값이 없습니다.");
			e.printStackTrace();
		}
	}

	private static void printBooks() throws FileNotFoundException {
		System.out.println("전체 도서 출력");
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		String str = "";

		try {
			while ((str = br.readLine()) != null) {

				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {

			System.out.println("지정된 값이 없습니다.");
			e.printStackTrace();
		}
	}

}
