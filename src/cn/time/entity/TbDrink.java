package cn.time.entity;

public class TbDrink {
    private Integer d_Id;

    private String d_Name;

    private Integer cId;

    private Integer price;

    private String status;

    public Integer getd_Id() {
        return d_Id;
    }

    public void setd_Id(Integer dId) {
        this.d_Id = dId;
    }


    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getD_Name() {
		return d_Name;
	}

	public void setD_Name(String d_Name) {
		this.d_Name = d_Name;
	}
}