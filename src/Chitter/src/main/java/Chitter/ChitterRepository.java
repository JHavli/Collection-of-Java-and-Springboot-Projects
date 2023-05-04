package Chitter;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChitterRepository extends MongoRepository<Chitter, String> {
    List<Chitter> findByOrderByTimestampDesc();
    List<Chitter> findByUserOrderByTimestampDesc(String user);
}
