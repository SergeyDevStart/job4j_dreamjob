package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.dto.FileDto;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.repository.CandidateRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleCandidateService implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final FileService fileService;

    public SimpleCandidateService(CandidateRepository sql2oCandidateRepository, FileService fileService) {
        this.candidateRepository = sql2oCandidateRepository;
        this.fileService = fileService;
    }

    @Override
    public Candidate save(Candidate candidate, FileDto fileDto) {
        saveNewFile(candidate, fileDto);
        return candidateRepository.save(candidate);
    }

    private void saveNewFile(Candidate candidate, FileDto fileDto) {
        var file = fileService.save(fileDto);
        candidate.setFileId(file.getId());
    }

    @Override
    public void deleteById(int id) {
        var candidateOptional = findById(id);
        if (candidateOptional.isPresent()) {
            candidateRepository.deleteById(id);
            fileService.deleteById(candidateOptional.get().getFileId());
        }
    }

    @Override
    public boolean update(Candidate candidate, FileDto fileDto) {
        boolean isNewFileEmpty = fileDto.getContent().length == 0;
        if (isNewFileEmpty) {
            return candidateRepository.update(candidate);
        }
        var oldFile = candidate.getFileId();
        saveNewFile(candidate, fileDto);
        boolean isUpdated = candidateRepository.update(candidate);
        fileService.deleteById(oldFile);
        return isUpdated;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidateRepository.findAll();
    }
}
