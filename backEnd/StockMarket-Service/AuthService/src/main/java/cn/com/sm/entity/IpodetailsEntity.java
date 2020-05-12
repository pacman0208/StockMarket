package cn.com.sm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ipodetails", schema = "mydb", catalog = "")
public class IpodetailsEntity {
    private int id;
    private String companyName;
    private String exchangeName;
    private Double pricePerShare;
    private String totalNumOfShares;
    private Timestamp openDateTime;
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
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    @Column(name = "price_per_share")
    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    @Basic
    @Column(name = "total_num_of_shares")
    public String getTotalNumOfShares() {
        return totalNumOfShares;
    }

    public void setTotalNumOfShares(String totalNumOfShares) {
        this.totalNumOfShares = totalNumOfShares;
    }

    @Basic
    @Column(name = "open_date_time")
    public Timestamp getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(Timestamp openDateTime) {
        this.openDateTime = openDateTime;
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
        IpodetailsEntity that = (IpodetailsEntity) o;
        return id == that.id &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(exchangeName, that.exchangeName) &&
                Objects.equals(pricePerShare, that.pricePerShare) &&
                Objects.equals(totalNumOfShares, that.totalNumOfShares) &&
                Objects.equals(openDateTime, that.openDateTime) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(lastChgTsp, that.lastChgTsp) &&
                Objects.equals(createTsp, that.createTsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, exchangeName, pricePerShare, totalNumOfShares, openDateTime, remarks, lastChgTsp, createTsp);
    }
}
