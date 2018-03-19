package com.dongxiang.dongxiang.domain;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "user_manage", schema = "dongxiang", catalog = "")
public class UserManageEntity {
    private long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String pkUserid;
    private String userPwd;
    private String userNum;
    private String userPic;
    private String userRealname;
    private String userLocation;
    private String userTelephone;
    private String userRemark;
    private long userFactory;
    private long userRole;
    private long userPermit;
    private byte isExtended;
    private byte isFactory;

    @Basic
    @Column(name = "is_factory", nullable = false)
    public byte getIsFactory() {
        return isFactory;
    }

    public void setIsFactory(byte isFactory) {
        this.isFactory = isFactory;
    }

    @Id
    @Column(name = "id", nullable = false)
    @JsonView(UserSimpleView.class)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    @JsonView(UserSimpleView.class)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified", nullable = false)
    @JsonView(UserSimpleView.class)
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "pk_userid", nullable = false, length = 20)
    @NotEmpty(message = "用户名不能为空!")
    @Size(min = 4, max = 20)
    @JsonView(UserSimpleView.class)
    public String getPkUserid() {
        return pkUserid;
    }

    public void setPkUserid(String pkUserid) {
        this.pkUserid = pkUserid;
    }

    @Basic
    @Column(name = "user_pwd", nullable = false, length = 20)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 3, max = 20)
    @JsonView(UserDetailView.class)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_num", nullable = false, length = 20)
    @JsonView(UserSimpleView.class)
    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Basic
    @Column(name = "user_pic", nullable = false, length = 40)
    @JsonView(UserSimpleView.class)
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    @Basic
    @Column(name = "user_realname", nullable = false, length = 20)
    @JsonView(UserSimpleView.class)
    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    @Basic
    @Column(name = "user_location", nullable = false, length = 20)
    @JsonView(UserDetailView.class)
    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Basic
    @Column(name = "user_telephone", nullable = false, length = 20)
    @JsonView(UserDetailView.class)
    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    @Basic
    @Column(name = "user_remark", nullable = false, length = -1)
    @JsonView(UserDetailView.class)
    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    @Basic
    @Column(name = "user_factory", nullable = false, length = 20)
    @JsonView(UserSimpleView.class)
    public long getUserFactory() {
        return userFactory;
    }

    public void setUserFactory(long userFactory) {
        this.userFactory = userFactory;
    }

    @Basic
    @Column(name = "user_role", nullable = false)
    @JsonView(UserSimpleView.class)
    public long getUserRole() {
        return userRole;
    }

    public void setUserRole(long userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "user_permit", nullable = false)
    @JsonView(UserSimpleView.class)
    public long getUserPermit() {
        return userPermit;
    }

    public void setUserPermit(long userPermit) {
        this.userPermit = userPermit;
    }

    @Basic
    @Column(name = "is_extended", nullable = false)
    @JsonView(UserSimpleView.class)
    public byte getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(byte isExtended) {
        this.isExtended = isExtended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserManageEntity that = (UserManageEntity) o;

        if (id != that.id) return false;
        if (userRole != that.userRole) return false;
        if (userPermit != that.userPermit) return false;
        if (isExtended != that.isExtended) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;
        if (pkUserid != null ? !pkUserid.equals(that.pkUserid) : that.pkUserid != null) return false;
        if (userPwd != null ? !userPwd.equals(that.userPwd) : that.userPwd != null) return false;
        if (userNum != null ? !userNum.equals(that.userNum) : that.userNum != null) return false;
        if (userPic != null ? !userPic.equals(that.userPic) : that.userPic != null) return false;
        if (userRealname != null ? !userRealname.equals(that.userRealname) : that.userRealname != null) return false;
        if (userLocation != null ? !userLocation.equals(that.userLocation) : that.userLocation != null) return false;
        if (userTelephone != null ? !userTelephone.equals(that.userTelephone) : that.userTelephone != null)
            return false;
        if (userRemark != null ? !userRemark.equals(that.userRemark) : that.userRemark != null) return false;
        if (userFactory != that.userFactory) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (pkUserid != null ? pkUserid.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userNum != null ? userNum.hashCode() : 0);
        result = 31 * result + (userPic != null ? userPic.hashCode() : 0);
        result = 31 * result + (userRealname != null ? userRealname.hashCode() : 0);
        result = 31 * result + (userLocation != null ? userLocation.hashCode() : 0);
        result = 31 * result + (userTelephone != null ? userTelephone.hashCode() : 0);
        result = 31 * result + (userRemark != null ? userRemark.hashCode() : 0);
        result = 31 * result + (int)(userFactory ^ (userFactory >>> 32));
        result = 31 * result + (int) (userRole ^ (userRole >>> 32));
        result = 31 * result + (int) (userPermit ^ (userPermit >>> 32));
        result = 31 * result + (int) isExtended;
        return result;
    }

public interface UserSimpleView {}

public interface UserDetailView extends UserSimpleView {}
}
