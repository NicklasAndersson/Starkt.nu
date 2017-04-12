package model;

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

    public BigDecimal getAlkoholperkrona() {
        if (!getMlAlkohol().equals(BigDecimal.ZERO) && !prisinklmoms.equals(BigDecimal.ZERO)) {
            return getMlAlkohol().divide(prisinklmoms, BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }

    public ArtikelDao getDao() {
        ArtikelDao toReturn = new ArtikelDao();

        toReturn.nr = nr;
        toReturn.artikelid = artikelid;
        toReturn.varnummer = varnummer;
        toReturn.namn = namn;
        toReturn.namn2 = namn2;
        toReturn.prisinklmoms = prisinklmoms;
        toReturn.volymiml = volymiml;
        toReturn.prisPerLiter = prisPerLiter;
        toReturn.saljstart = saljstart;
        toReturn.utgått = utgått;
        toReturn.varugrupp = varugrupp;
        toReturn.typ = typ;
        toReturn.stil = stil;
        toReturn.forpackning = forpackning;
        toReturn.forslutning = forslutning;
        toReturn.ursprung = ursprung;
        toReturn.ursprunglandnamn = ursprunglandnamn;
        toReturn.producent = producent;
        toReturn.leverantor = leverantor;
        toReturn.argang = argang;
        toReturn.provadargang = provadargang;
        toReturn.alkoholhalt = alkoholhalt;
        toReturn.sortiment = sortiment;
        toReturn.sortimentText = sortimentText;
        toReturn.ekologisk = ekologisk;
        toReturn.etiskt = etiskt;
        toReturn.koscher = koscher;
        toReturn.ravarorBeskrivning = ravarorBeskrivning;
        toReturn.alkoholperkrona = getAlkoholperkrona();

        return toReturn;
    }

}
