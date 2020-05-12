package cn.com.sm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "mydb", catalog = "")
public class
CompanyEntity {
    private int id;
    private String stockCode;
    private String companyName;
    private Double turnover;
    private String ceo;
    private String boardOfDirectors;
    private String listInExchanges;
    private String briefIntro;
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
    @Column(name = "stock_code")
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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
    @Column(name = "turnover")
    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    @Basic
    @Column(name = "ceo")
    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    @Basic
    @Column(name = "board_of_directors")
    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    @Basic
    @Column(name = "list_in_exchanges")
    public String getListInExchanges() {
        return listInExchanges;
    }

    public void setListInExchanges(String listInExchanges) {
        this.listInExchanges = listInExchanges;
    }

    @Basic
    @Column(name = "brief_intro")
    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
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
        CompanyEntity that = (CompanyEntity) o;
        return id == that.id &&
                Objects.equals(stockCode, that.stockCode) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(turnover, that.turnover) &&
                Objects.equals(ceo, that.ceo) &&
                Objects.equals(boardOfDirectors, that.boardOfDirectors) &&
                Objects.equals(listInExchanges, that.listInExchanges) &&
                Objects.equals(briefIntro, that.briefIntro) &&
                Objects.equals(lastChgTsp, that.lastChgTsp) &&
                Objects.equals(createTsp, that.createTsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockCode, companyName, turnover, ceo, boardOfDirectors, listInExchanges, briefIntro, lastChgTsp, createTsp);
    }
}
