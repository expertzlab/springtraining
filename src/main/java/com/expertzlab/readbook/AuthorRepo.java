package com.expertzlab.readbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by gireeshbabu on 30/12/16.
 */

//@RepositoryRestResource
public interface AuthorRepo extends PagingAndSortingRepository<Author,Long>{
}
