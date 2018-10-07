package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "ccy",
        "base_ccy",
        "buy",
        "sale"
})

/**
 * Created by Stas on 07.10.2018.
 */
public class Currency {
    @JsonProperty("ccy")
    private String ccy;
    @JsonProperty("baseCcy")
    private String base_ccy;
    @JsonProperty("buy")
    private String buy;
    @JsonProperty("sale")
    private String sale;

    @JsonProperty("ccy")
    public String getCcy() {
        return ccy;
    }

    @JsonProperty("ccy")
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @JsonProperty("base_ccy")
    public String getBase_ccy() {
        return base_ccy;
    }

    @JsonProperty("base_ccy")
    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    @JsonProperty("buy")
    public String getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(String buy) {
        this.buy = buy;
    }

    @JsonProperty("sale")
    public String getSale() {
        return sale;
    }

    @JsonProperty("sale")
    public void setSale(String sale) {
        this.sale = sale;
    }
}
