package com.example.wangchang.testpalette.bean;

public class Pblresources {
    String coverImg;
    String name;
    int rtype;
    String createtime;
    String classifyname;
    String size;
    String company;
    String nickName;

    public Pblresources() {
    }

    public Pblresources(String coverImg, String name, int rtype, String createtime, String classifyname, String size, String company, String nickName) {
        this.coverImg = coverImg;
        this.name = name;
        this.rtype = rtype;
        this.createtime = createtime;
        this.classifyname = classifyname;
        this.size = size;
        this.company = company;
        this.nickName = nickName;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
