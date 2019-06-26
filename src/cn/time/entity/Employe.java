package cn.time.entity;

public class Employe {
    private Integer e_Id;

    private String name;

    private String sex;
    
    private String user;
    
    private String passwd;
    
    private String status;
    
    
    public String getStatus() {
		return status;
	}
    
    public void setStatus(String status) {
		this.status = status;
	}

    public String getUser() {
		return user;
	}

	public void setUser(String username) {
		this.user = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer gete_Id() {
        return e_Id;
    }

    public void sete_Id(Integer e_Id) {
        this.e_Id = e_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}