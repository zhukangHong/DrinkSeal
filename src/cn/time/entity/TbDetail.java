package cn.time.entity;

public class TbDetail extends TbDetailKey {
    private String cName;

    private String d_Name;

    private Integer num;

    private Float price;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getd_Name() {
        return d_Name;
    }

    public void setdName(String d_Name) {
        this.d_Name = d_Name == null ? null : d_Name.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}