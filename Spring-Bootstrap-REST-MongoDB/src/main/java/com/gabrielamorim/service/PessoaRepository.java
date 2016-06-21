package com.gabrielamorim.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa")
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

	List<Pessoa> findByCidade(@Param("cidade") String cidade);

	List<Pessoa> findByCidadeLikeIgnoreCase(@Param("cidade") String cidade);

	List<Pessoa> findByNomeLikeIgnoreCase(@Param("nome") String nome);

	List<Pessoa> findByEnderecoLikeIgnoreCase(@Param("endereco") String endereco);

	List<Pessoa> findByEstado(@Param("estado") String estado);

	List<Pessoa> findByEstadoAndCidade(@Param("estado") String estado,
			@Param("cidade") String cidade);

	List<Pessoa> findByIdade(@Param("idade") Integer idade);
}
