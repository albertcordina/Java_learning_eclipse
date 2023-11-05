package testing;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

public class StudentManagementSystem {

	public static void main(String[] args) {

		System.out.println("\t- Welcome to the Student Database -");

		CollectionInfoMenu collectionInfoMenu = new CollectionInfoMenu();
		collectionInfoMenu.menu();
	}
}
