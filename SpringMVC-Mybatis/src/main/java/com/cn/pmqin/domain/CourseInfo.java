package com.cn.pmqin.domain;

public class CourseInfo {
    private Integer id;

    private String cname;

    private String cadress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCadress() {
        return cadress;
    }

    public void setCadress(String cadress) {
        this.cadress = cadress == null ? null : cadress.trim();
    }
}