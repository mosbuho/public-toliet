import java.util.Scanner;

import Controller.DataBaseUtill;
import View.MainMenu;

public class PublicToiletMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        while (true) {
            MainMenu.mainView();
            try {menu = Integer.parseInt(sc.nextLine());} 
            catch (NumberFormatException e) {}
            switch (menu) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("올바른 메뉴 입력");
                    break;
            }
        }
    }
}
