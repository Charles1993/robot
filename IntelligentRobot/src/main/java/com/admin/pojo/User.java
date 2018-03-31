package com.admin.pojo;

/**
 * @Author: Duke
 * @Description:
 * @Date: Created in 下午9:47 2018/3/18
 * @Modified By:
 */
public class User {

    /**
     * id 主键
     */
    private int id;

    /**
     * userName 用户名
     */
    private String userName;

    /**
     * passWord 密码
     */
    private String passWord;

    /**
     * account 账号
     */
    private String account;

    /**
     * email 邮箱
     */
    private String email;

    /**
     * chineseName 中文名
     */
    private String chineseName;

    /**
     * mobilePhone 手机号码
     */
    private String mobilePhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
