package cn.time.entity;

import java.util.Date;

public class TbDeal {
    private String dd_Id;

    private String dd_Date;

    private Float total;

    private Integer e_Id;

    private String ismer;

    private String m_Id;

    private Integer point;

    private Integer num;

    public String getDd_Id() {
        return dd_Id;
    }

    public void setDd_Id(String dd_Id) {
        this.dd_Id = dd_Id == null ? null : dd_Id.trim();
    }

    public String getDd_Date() {
        return dd_Date;
    }

    public void setDd_Date(String dd_Date) {
        this.dd_Date = dd_Date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer gete_Id() {
        return e_Id;
    }

    public void sete_Id(Integer e_Id) {
        this.e_Id = e_Id;
    }

    public String getIsmer() {
        return ismer;
    }

    public void setIsmer(String ismer) {
        this.ismer = ismer == null ? null : ismer.trim();
    }

    public String getm_Id() {
        return m_Id;
    }

    public void setm_Id(String m_Id) {
        this.m_Id = m_Id == null ? null : m_Id.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}