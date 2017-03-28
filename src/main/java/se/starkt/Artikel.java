package se.starkt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by
 *
 * @author nicklas on 2017-03-23.
 */
@Data
@ToString
@EqualsAndHashCode
public class Artikel {
    Long nr;
    Long artikelid;
    Long varunummer;
    String namn;
    String namn2;



}
