package br.com.famaciel.edvrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.famaciel.edvrestapi.model.entity.AtendenteEntity;

@RepositoryRestResource(collectionResourceRel = "atendente", path = "atendente")
public interface IAtendenteRepository extends CrudRepository<AtendenteEntity, Integer> {

}
