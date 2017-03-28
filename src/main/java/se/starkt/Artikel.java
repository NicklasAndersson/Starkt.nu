package se.starkt;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by
 *
 * @author nicklas on 2017-03-23.
 */
@Data
public class Artikel {
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
}
