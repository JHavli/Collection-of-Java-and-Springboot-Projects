package Chitter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chitters")
public class ChittersEndpoint {
    private final ChitterService chitterService;

    public ChittersEndpoint(ChitterService chitterService) {
        this.chitterService = chitterService;
    }

    @GetMapping
    List<Chitter> getAll() {
        return chitterService.findAll();
    }

    @GetMapping("/user/{user}")
    List<Chitter> getForUser(@PathVariable String user) {
        return chitterService.findBy(user);
    }

    @PostMapping
    Chitter post(@RequestBody Chitter chitter) {
        return chitterService.save(chitter);
    }

    @PutMapping("/{id}/likes")
    void like(@PathVariable String id) {
        chitterService.like(id);
    }

    @PutMapping("/{id}/comments")
    void comment(@PathVariable String id, @RequestBody String comment) {
        chitterService.comment(id, comment);
    }
}
