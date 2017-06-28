package com.expertzlab.readbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by gireeshbabu on 30/12/16.
 */

@RepositoryRestResource(collectionResourceRel = "author",path = "/author")
public interface AuthorRestRepo extends PagingAndSortingRepository<Author,Long>{
}
