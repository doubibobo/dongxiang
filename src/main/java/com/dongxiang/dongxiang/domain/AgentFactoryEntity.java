package com.dongxiang.dongxiang.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "agent_factory", schema = "dongxiang", catalog = "")
public class AgentFactoryEntity {
    private int id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private byte agentRank;
    private String agentName;
    private String agentArea;
    private int agentFather;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "agent_rank", nullable = false)
    public byte getAgentRank() {
        return agentRank;
    }

    public void setAgentRank(byte agentRank) {
        this.agentRank = agentRank;
    }

    @Basic
    @Column(name = "agent_name", nullable = false, length = 40)
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Basic
    @Column(name = "agent_area", nullable = false, length = 20)
    public String getAgentArea() {
        return agentArea;
    }

    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }

    @Basic
    @Column(name = "agent_father", nullable = false)
    public int getAgentFather() {
        return agentFather;
    }

    public void setAgentFather(int agentFather) {
        this.agentFather = agentFather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentFactoryEntity that = (AgentFactoryEntity) o;

        if (id != that.id) return false;
        if (agentRank != that.agentRank) return false;
        if (agentFather != that.agentFather) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (agentArea != null ? !agentArea.equals(that.agentArea) : that.agentArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        result = 31 * result + (int) agentRank;
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (agentArea != null ? agentArea.hashCode() : 0);
        result = 31 * result + agentFather;
        return result;
    }
}
