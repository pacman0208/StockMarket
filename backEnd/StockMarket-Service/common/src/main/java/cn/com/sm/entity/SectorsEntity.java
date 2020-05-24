package cn.com.sm.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sectors", schema = "mydb", catalog = "")
@EntityListeners(AuditingEntityListener.class)
public class SectorsEntity {
    private int id;
    private String sectorName;

    @LastModifiedDate
    private Timestamp lastChgTsp;

    @CreatedDate
    private Timestamp createTsp;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sector_name")
    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    @Basic
    @Column(name = "last_chg_tsp")
    public Timestamp getLastChgTsp() {
        return lastChgTsp;
    }

    public void setLastChgTsp(Timestamp lastChgTsp) {
        this.lastChgTsp = lastChgTsp;
    }

    @Basic
    @Column(name = "create_tsp")
    public Timestamp getCreateTsp() {
        return createTsp;
    }

    public void setCreateTsp(Timestamp createTsp) {
        this.createTsp = createTsp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorsEntity that = (SectorsEntity) o;
        return id == that.id &&
                Objects.equals(sectorName, that.sectorName) &&
                Objects.equals(lastChgTsp, that.lastChgTsp) &&
                Objects.equals(createTsp, that.createTsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sectorName, lastChgTsp, createTsp);
    }

    @Override
    public String toString() {
        return "SectorsEntity{" +
                "id=" + id +
                ", sectorName='" + sectorName + '\'' +
                ", lastChgTsp=" + lastChgTsp +
                ", createTsp=" + createTsp +
                '}';
    }
}
