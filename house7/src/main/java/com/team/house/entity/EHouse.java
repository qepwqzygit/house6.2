package com.team.house.entity;

/**
 * @author:ZY
 * @date:2019/10/23
 * @Time:23:50
 */
public class EHouse  extends House{
    //区域名字  街道名字   户型名字
    private String dname;
    private String tname;
    private String sname;
    private Integer did;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
