package com.MIAGE.jeuxmiagiques.repository;

import com.MIAGE.jeuxmiagiques.model.Billet;
//JpaRepository is particularly a JPA specific extension for Repository. It has full API CrudRepository and PagingAndSortingRepository. So, basically, Jpa Repository contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilletRepository extends JpaRepository<Billet, Integer> {
}
