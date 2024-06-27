package ru.job4j.dreamjob.repository;

import ru.job4j.dreamjob.model.Candidate;
import java.util.Collection;
import java.util.Optional;

public interface CandidateRepository {
    Candidate save(Candidate candidate);

    void deleteById(Integer id);

    boolean update(Candidate candidate);

    Optional<Candidate> findById(Integer id);

    Collection<Candidate> findAll();
}
