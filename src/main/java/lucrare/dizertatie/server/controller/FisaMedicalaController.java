package lucrare.dizertatie.server.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lucrare.dizertatie.common.exception.EntityNotFoundException;
import lucrare.dizertatie.common.exception.ErrorResponse;
import lucrare.dizertatie.server.model.FisaMedicala;
import lucrare.dizertatie.server.service.FisaMedicalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "Fisa Medicala")
@RequestMapping("/fisa-medicala")
@RequiredArgsConstructor
public class FisaMedicalaController {

    private final FisaMedicalaService fisaMedicalaService;

    @GetMapping("/all")
    public ResponseEntity<List<FisaMedicala>> getAll() {
        return ResponseEntity.ok(fisaMedicalaService.getAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FisaMedicala>> getAllInternati() {
        return ResponseEntity.ok(fisaMedicalaService.getAllActive());
    }

    @PostMapping("/save")
    public ResponseEntity<FisaMedicala> save(@RequestBody FisaMedicala fisaMedicala) {
        return ResponseEntity.ok(fisaMedicalaService.save(fisaMedicala));
    }

    @GetMapping("/id")
    public ResponseEntity<FisaMedicala> getById(@RequestParam Integer id)
    {
        try{
            return ResponseEntity.ok(fisaMedicalaService.findById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
