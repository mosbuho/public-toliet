package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.PublicToilet;

public class PublicToiletManager {
    public static void getToilets(Scanner sc) {
        ArrayList<PublicToilet> ptlist = null;
        String pIndex = "1";
        while (true) {
            ptlist = APIUtill.getToilets(pIndex);
            System.out.println(ptlist);
            System.out.print(String.format("[%sp] 페이지 입력 (1 ~ 11 | 종료 : -1) : ", pIndex));
            pIndex = sc.nextLine();
            if (pIndex.equals("-1")) {
                break;
            }
        }
    }

    public static void searchToilets(Scanner sc) {
        System.out.print("지역 입력 : ");
        String addr = sc.nextLine();
        ArrayList<PublicToilet> ptlist = PublicToiletDAO.searchToilets(addr);
        System.out.println(ptlist);
    }
}
