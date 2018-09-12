package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class ArtikelDao {


    @Id
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
    @Column(length = 1000)
    String ravarorBeskrivning;
    BigDecimal alkoholperkrona;
}
