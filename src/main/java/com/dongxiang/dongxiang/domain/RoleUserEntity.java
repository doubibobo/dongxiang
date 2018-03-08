package com.dongxiang.dongxiang.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role_user", schema = "dongxiang", catalog = "")
public class RoleUserEntity {
    private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private long pkTypeid;
    private String typeName;
    private long defaultPermit;

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
    @Column(name = "pk_typeid", nullable = false)
    public long getPkTypeid() {
        return pkTypeid;
    }

    public void setPkTypeid(long pkTypeid) {
        this.pkTypeid = pkTypeid;
    }

    @Basic
    @Column(name = "type_name", nullable = false, length = 20)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "default_permit", nullable = false)
    public long getDefaultPermit() {
        return defaultPermit;
    }

    public void setDefaultPermit(long defaultPermit) {
        this.defaultPermit = defaultPermit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleUserEntity that = (RoleUserEntity) o;

        if (id != that.id) return false;
        if (pkTypeid != that.pkTypeid) return false;
        if (defaultPermit != that.defaultPermit) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (int) (pkTypeid ^ (pkTypeid >>> 32));
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (int) (defaultPermit ^ (defaultPermit >>> 32));
        return result;
    }
}
