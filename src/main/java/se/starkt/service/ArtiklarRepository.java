package se.starkt.service;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import model.Artikel;

/**
 * Created by
 *
 * @author nicklas on 2017-04-11.
 */
public interface ArtiklarRepository extends DataTablesRepository<Artikel, Long> {

}
