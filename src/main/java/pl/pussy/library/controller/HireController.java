package pl.pussy.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pussy.library.model.Hire;
import pl.pussy.library.service.HireService;

@RestController
@RequestMapping("/api/hires")
@RequiredArgsConstructor
public class HireController {
    private final HireService hireService;

    @GetMapping()
    public ResponseEntity<?> getAllHires() {
        return ResponseEntity.ok("\"hires\": \"AAA\"");
        //return ResponseEntity.ok(hireService.getAllHires());
    }

    @PostMapping()
    public ResponseEntity<Hire> addHire(@RequestBody Hire hire) {
        return ResponseEntity.ok(hireService.addHire(hire));
    }
}
