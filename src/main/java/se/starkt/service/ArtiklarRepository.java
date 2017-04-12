package se.starkt.service;

import model.ArtikelDao;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * Created by
 *
 * @author nicklas on 2017-04-11.
 */
public interface ArtiklarRepository extends DataTablesRepository<ArtikelDao, Long> {

}
