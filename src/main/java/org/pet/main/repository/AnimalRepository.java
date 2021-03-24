package org.pet.main.repository;

import org.pet.main.model.Animal;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Override
    @Cacheable("animals")
    Iterable<Animal> findAll();

    @Override
    @Cacheable("animals")
    Optional<Animal> findById(Long aLong);

    @Override
    @Cacheable("animals")
    boolean existsById(Long aLong);

    @Override
    @Cacheable("animals")
    Iterable<Animal> findAllById(Iterable<Long> iterable);

    @Override
    @Cacheable("animals")
    long count();

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    <S extends Animal> S save(S s);

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    <S extends Animal> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    void deleteById(Long aLong);

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    void delete(Animal animal);

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    void deleteAll(Iterable<? extends Animal> iterable);

    @Override
    @CacheEvict(value = "animals", allEntries=true)
    void deleteAll();
}
