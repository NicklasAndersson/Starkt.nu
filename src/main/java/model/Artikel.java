package model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by
 *
 * @author nicklas on 2017-03-23.
 */
@Data
@Entity
public class Artikel {
    @JsonView(DataTablesOutput.View.class)
    @Id
    Long nr;

    Long artikelid;
    Long varnummer;

    @JsonView(DataTablesOutput.View.class)
    String namn;

    @JsonView(DataTablesOutput.View.class)
    String namn2;

    @JsonView(DataTablesOutput.View.class)
    BigDecimal prisinklmoms;

    @JsonView(DataTablesOutput.View.class)
    BigDecimal volymiml;

    @JsonView(DataTablesOutput.View.class)
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

    @Column(length = 1000)
    String ravarorBeskrivning;

    public Artikel() {
        super();
    }

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

    @JsonView(DataTablesOutput.View.class)
    public BigDecimal getAlkoholperkrona() {
        if (!getMlAlkohol().equals(BigDecimal.ZERO) && !prisinklmoms.equals(BigDecimal.ZERO)) {
            return getMlAlkohol().divide(prisinklmoms, BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }

}
