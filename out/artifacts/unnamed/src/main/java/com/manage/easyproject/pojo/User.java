package com.manage.easyproject.pojo;

/**
 * @version 1.0.0
 * @ClassName User
 * @Description TODO
 */
public class User {
    private int id;
    private String account;
    private String password;
    private String email;
    private String country;
    private String name;
    private String phone;
    private String purpose;
    private int status;

    private String statusDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        switch (status) {
            case 0:
                statusDesc = "未审核";
                break;
            case 1:
                statusDesc = "审核通过";
                break;
            case 2:
                statusDesc = "审核驳回";
                break;
        }
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
