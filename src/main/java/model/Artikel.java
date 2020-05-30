package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by
 *
 * @author nicklas on 2017-03-23.
 */
@Data
public class Artikel implements Comparable<Artikel>{

    Long nr;
    Long artikelid;
    Long varnummer;
    String namn;
    String namn2;
    BigDecimal prisinklmoms;
    BigDecimal volymiml;
    BigDecimal prisPerLiter;
    String saljstart;
    Integer utgått;
    String varugrupp;
    String typ;
    String stil;
    String forpackning;
    String forslutning;
    String ursprung;
    String ursprunglandnamn;
    String producent;
    String leverantor;
    String argang;
    String provadargang;
    String alkoholhalt;
    String sortiment;
    String sortimentText;
    Integer ekologisk;
    Integer etiskt;
    Integer koscher;
    String ravarorBeskrivning;


    public BigDecimal getAlkoholhaltAmount() {
        String amount = alkoholhalt.substring(0, alkoholhalt.length() - 1);
        BigDecimal amt = new BigDecimal(amount);
        if (!amt.equals(BigDecimal.ZERO)) {
            return amt.divide(new BigDecimal(100), BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getMlAlkohol() {
        return volymiml.multiply(getAlkoholhaltAmount());
    }

    @JsonProperty("apk")
    public BigDecimal getAlkoholperkrona() {
        if (!getMlAlkohol().equals(BigDecimal.ZERO) && !prisinklmoms.equals(BigDecimal.ZERO)) {
            return getMlAlkohol().divide(prisinklmoms, BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }

    @Override
    public int compareTo(Artikel o) {
        if(getAlkoholperkrona() == null || o.getAlkoholperkrona() == null){
            return 0;
        }
        return o.getAlkoholperkrona().compareTo(getAlkoholperkrona());
    }
}
