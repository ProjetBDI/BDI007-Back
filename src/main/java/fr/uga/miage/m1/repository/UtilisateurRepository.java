package fr.uga.miage.m1.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Utilisateur;
import org.springframework.data.repository.query.FluentQuery;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
    List<Utilisateur> findByNom(String nom);

    @Override
    default void flush() {

    }

    @Override
    default <S extends Utilisateur> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends Utilisateur> List<S> saveAllAndFlush(Iterable<S> entities) {

        return null;
    }

    @Override
    default void deleteAllInBatch(Iterable<Utilisateur> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default Utilisateur getOne(Long aLong) {
        return null;
    }

    @Override
    default Utilisateur getById(Long aLong) {
        return null;
    }

    @Override
    default Utilisateur getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends Utilisateur> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends Utilisateur> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    default <S extends Utilisateur> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default List<Utilisateur> findAll() {
        return null;
    }

    @Override
    default List<Utilisateur> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default <S extends Utilisateur> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Utilisateur> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Utilisateur entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Utilisateur> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<Utilisateur> findAll(Sort sort) {
        return null;
    }

    @Override
    default Page<Utilisateur> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Utilisateur> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends Utilisateur> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Utilisateur> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends Utilisateur> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends Utilisateur, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    Optional<Utilisateur> findByUsername(String username);
}

