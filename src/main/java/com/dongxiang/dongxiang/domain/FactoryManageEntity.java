package com.dongxiang.dongxiang.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "factory_manage", schema = "dongxiang", catalog = "")
public class FactoryManageEntity {
    private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String pkNumber;
    private String breadName;
    private String breadLocation;
    private Timestamp createTime;
    private long responsiblePersonid;
    private String remark;
    private String disnfectP;
    private short agent;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified", nullable = false)
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "pk_number", nullable = false, length = 20)
    public String getPkNumber() {
        return pkNumber;
    }

    public void setPkNumber(String pkNumber) {
        this.pkNumber = pkNumber;
    }

    @Basic
    @Column(name = "bread_name", nullable = false, length = 20)
    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }

    @Basic
    @Column(name = "bread_location", nullable = false, length = 20)
    public String getBreadLocation() {
        return breadLocation;
    }

    public void setBreadLocation(String breadLocation) {
        this.breadLocation = breadLocation;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "responsible_personid", nullable = false)
    public long getResponsiblePersonid() {
        return responsiblePersonid;
    }

    public void setResponsiblePersonid(long responsiblePersonid) {
        this.responsiblePersonid = responsiblePersonid;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "disnfect_p", nullable = false, length = 50)
    public String getDisnfectP() {
        return disnfectP;
    }

    public void setDisnfectP(String disnfectP) {
        this.disnfectP = disnfectP;
    }

    @Basic
    @Column(name = "agent", nullable = false)
    public short getAgent() {
        return agent;
    }

    public void setAgent(short agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactoryManageEntity that = (FactoryManageEntity) o;

        if (id != that.id) return false;
        if (responsiblePersonid != that.responsiblePersonid) return false;
        if (agent != that.agent) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;
        if (pkNumber != null ? !pkNumber.equals(that.pkNumber) : that.pkNumber != null) return false;
        if (breadName != null ? !breadName.equals(that.breadName) : that.breadName != null) return false;
        if (breadLocation != null ? !breadLocation.equals(that.breadLocation) : that.breadLocation != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (disnfectP != null ? !disnfectP.equals(that.disnfectP) : that.disnfectP != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (pkNumber != null ? pkNumber.hashCode() : 0);
        result = 31 * result + (breadName != null ? breadName.hashCode() : 0);
        result = 31 * result + (breadLocation != null ? breadLocation.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (int) (responsiblePersonid ^ (responsiblePersonid >>> 32));
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (disnfectP != null ? disnfectP.hashCode() : 0);
        result = 31 * result + (int) agent;
        return result;
    }
}
