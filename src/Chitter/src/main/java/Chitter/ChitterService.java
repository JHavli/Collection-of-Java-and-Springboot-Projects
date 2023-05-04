package Chitter;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChitterService {
    private final ChitterRepository repository;

    public ChitterService(ChitterRepository repository) {
        this.repository = repository;
    }

    public List<Chitter> findAll() {
        return repository.findByOrderByTimestampDesc();
    }
    public List<Chitter> findBy(String user) {
        return repository.findByUserOrderByTimestampDesc(user);
    }
    public Chitter save(Chitter chitter) {
        chitter.setComments(new ArrayList<>());
        chitter.setTimestamp(LocalDateTime.now());
        return repository.save(chitter);
    }
    public void like(String id) {
        Optional<Chitter> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        Chitter chitter = byId.get();
        int likes = chitter.getLikes();
        chitter.setLikes(likes + 1);
        repository.save(chitter);
    }
    public void comment(String id, String comment) {
        Optional<Chitter> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        Chitter chitter = byId.get();
        chitter.getComments().add(comment);
        repository.save(chitter);
    }
}
