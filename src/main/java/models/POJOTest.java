package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Stas on 07.10.2018.
 */
public class POJOTest {

    //@JsonProperty("ccy")  // аннотация Jackson
    private String ccy;
    //@JsonProperty("base_ccy")
    private String baseCcy;
    //@JsonProperty("buy")
    private String buy;
    //@JsonProperty("sale")
    private String sale;

    public POJOTest() {
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
