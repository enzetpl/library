package pl.pussy.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.model.Hire;
import pl.pussy.library.repository.HireRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HireService {
    private final HireRepository hireRepository;

    public List<Hire> getAllHires() {
        return hireRepository.findAll();
    }

    public Hire addHire(Hire hire) {
        return hireRepository.save(hire);
    }

    public boolean isCopyHired(BookCopy copy) {
        return hireRepository.findAllByBookCopy(copy)
                .stream()
                .anyMatch(hire -> !hire.isReturned());
    }
}
