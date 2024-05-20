package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicToilet {
    String name;
    String addr;
    String mfUse;
    String openTime;
    Date sourceDate;

    public PublicToilet() {
    }

    public PublicToilet(String name, String addr, String mfUse, String openTime, Date sourceDate) {
        this.name = name;
        this.addr = addr;
        this.mfUse = mfUse;
        this.openTime = openTime;
        this.sourceDate = sourceDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMfUse() {
        return mfUse;
    }

    public void setMfUse(String mfUse) {
        this.mfUse = mfUse;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Date getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(Date sourceDate) {
        this.sourceDate = sourceDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("이름 : %s, 주소 : %s, 남여 공용 : %s, 개방 시간 : %s, 데이터 생성일 : %s",
                name, addr, mfUse, openTime.equals(":~:") ? "24시간" : openTime,
                sourceDate != null ? dateFormat.format(sourceDate) : "null");
    }
}
