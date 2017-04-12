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
 * @author nicklas on 2017-04-12.
 */
@Data
@Entity
public class ArtikelDao {


    @JsonView(DataTablesOutput.View.class)
    @Id
    Long nr;

    @JsonView(DataTablesOutput.View.class)
    Long artikelid;

    @JsonView(DataTablesOutput.View.class)
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

    @JsonView(DataTablesOutput.View.class)
    String saljstart;

    @JsonView(DataTablesOutput.View.class)
    Integer utgått;

    @JsonView(DataTablesOutput.View.class)
    String varugrupp;

    @JsonView(DataTablesOutput.View.class)
    String typ;

    @JsonView(DataTablesOutput.View.class)
    String stil;

    @JsonView(DataTablesOutput.View.class)
    String forpackning;

    @JsonView(DataTablesOutput.View.class)
    String forslutning;

    @JsonView(DataTablesOutput.View.class)
    String ursprung;

    @JsonView(DataTablesOutput.View.class)
    String ursprunglandnamn;

    @JsonView(DataTablesOutput.View.class)
    String producent;

    @JsonView(DataTablesOutput.View.class)
    String leverantor;

    @JsonView(DataTablesOutput.View.class)
    String argang;

    @JsonView(DataTablesOutput.View.class)
    String provadargang;

    @JsonView(DataTablesOutput.View.class)
    String alkoholhalt;

    @JsonView(DataTablesOutput.View.class)
    String sortiment;

    @JsonView(DataTablesOutput.View.class)
    String sortimentText;

    @JsonView(DataTablesOutput.View.class)
    Integer ekologisk;

    @JsonView(DataTablesOutput.View.class)
    Integer etiskt;

    @JsonView(DataTablesOutput.View.class)
    Integer koscher;

    @JsonView(DataTablesOutput.View.class)
    @Column(length = 1000)
    String ravarorBeskrivning;

    @JsonView(DataTablesOutput.View.class)
    BigDecimal alkoholperkrona;
}
