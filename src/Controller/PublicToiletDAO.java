package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Model.PublicToilet;

public class PublicToiletDAO {
    public static void insertToilets() {
        String sql = "INSERT INTO PUBLICTOILET(PT_NAME, PT_ADDR, PT_MFUSE, OPENTIME, SOURCEDATE) VALUES(?, ?, ?, ?, ?)";
        ArrayList<PublicToilet> ptList = null;
        try (Connection conn = DataBaseUtill.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            Random random = new Random();
            int percent = 0;
            int randomVal = 0;
            for (int i = 1; i < 12; i++) {
                ptList = APIUtill.getToilets(String.format("%d", i));
                for (PublicToilet pt : ptList) {
                    pstmt.setString(1, pt.getName());
                    pstmt.setString(2, pt.getAddr());
                    pstmt.setString(3, pt.getMfUse());
                    pstmt.setString(4, pt.getOpenTime());
                    pstmt.setDate(5, new Date(pt.getSourceDate().getTime()));
                    pstmt.addBatch();
                }
                randomVal = random.nextInt(7) + 6;
                percent += randomVal;
                if (i == 11) {
                    percent = 100;
                }
                System.out.println(String.format("%d%%", percent));
            }
            pstmt.executeBatch();
            System.out.println("저장 끝");
        } catch (SQLException e) {
            System.out.println("저장 에러" + e.getMessage());
        }
    }

    public static void deleteToilets() {
        String sql = "DELETE FROM PUBLICTOILET";
        try (Connection conn = DataBaseUtill.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("삭제 끝");
        } catch (SQLException e) {
            System.out.println("삭제 에러" + e.getMessage());
        }
    }

    public static ArrayList<PublicToilet> searchToilets(String addr) {
        String sql = "SELECT PT_NAME, PT_ADDR, PT_MFUSE, OPENTIME, SOURCEDATE FROM PUBLICTOILET WHERE PT_ADDR LIKE ?";
        ArrayList<PublicToilet> ptlist = new ArrayList<>();
        try (Connection conn = DataBaseUtill.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + addr + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PublicToilet pt = new PublicToilet(rs.getString("PT_NAME"), rs.getString("PT_ADDR"),
                        rs.getString("PT_MFUSE"), rs.getString("OPENTIME"), rs.getDate("SOURCEDATE"));
                ptlist.add(pt);
            }
        } catch (SQLException e) {
            System.out.println("검색 에러" + e.getMessage());
        }
        return ptlist;
    }
}
