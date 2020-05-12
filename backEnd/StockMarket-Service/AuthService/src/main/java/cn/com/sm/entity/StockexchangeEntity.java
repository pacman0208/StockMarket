package cn.com.sm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "stockexchange", schema = "mydb", catalog = "")
public class StockexchangeEntity {
    private int id;
    private String exchangeName;
    private String brief;
    private String contactAddress;
    private String remarks;
    private Timestamp lastChgTsp;
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
    @Column(name = "exchange_name")
    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "contact_address")
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        StockexchangeEntity that = (StockexchangeEntity) o;
        return id == that.id &&
                Objects.equals(exchangeName, that.exchangeName) &&
                Objects.equals(brief, that.brief) &&
                Objects.equals(contactAddress, that.contactAddress) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(lastChgTsp, that.lastChgTsp) &&
                Objects.equals(createTsp, that.createTsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exchangeName, brief, contactAddress, remarks, lastChgTsp, createTsp);
    }
}
