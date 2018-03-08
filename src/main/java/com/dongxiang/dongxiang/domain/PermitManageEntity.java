package com.dongxiang.dongxiang.domain;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "permit_manage", schema = "dongxiang", catalog = "")
public class PermitManageEntity {
    public interface PermitSimpleView {};
    public interface PermitDetailView extends PermitSimpleView {};

    private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private long permitId;
    private String permitName;

    @Id
    @Column(name = "id", nullable = false)
    @JsonView(PermitDetailView.class)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    @JsonView(PermitDetailView.class)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified", nullable = false)
    @JsonView(PermitDetailView.class)
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "permit_id", nullable = false)
    @JsonView(PermitSimpleView.class)
    public long getPermitId() {
        return permitId;
    }

    public void setPermitId(long permitId) {
        this.permitId = permitId;
    }

    @Basic
    @Column(name = "permit_name", nullable = false, length = 20)
    @JsonView(PermitSimpleView.class)
    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermitManageEntity that = (PermitManageEntity) o;

        if (id != that.id) return false;
        if (permitId != that.permitId) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;
        if (permitName != null ? !permitName.equals(that.permitName) : that.permitName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (int) (permitId ^ (permitId >>> 32));
        result = 31 * result + (permitName != null ? permitName.hashCode() : 0);
        return result;
    }
}
