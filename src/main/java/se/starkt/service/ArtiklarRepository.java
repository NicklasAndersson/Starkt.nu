package se.starkt.service;

import model.ArtikelDao;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtiklarRepository extends PagingAndSortingRepository<ArtikelDao, Long> {

}
