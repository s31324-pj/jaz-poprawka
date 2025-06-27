package pl.pjatk.jaz_s31324_nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrController {

    @Autowired
    private CurrService service;

    @Operation(summary = "Pobranie tabel NBP typu A dla podanego przedziału dat i waluty")
    @GetMapping("/{code}")
    public ResponseEntity<List<Table>> getRates(
            @Parameter(description = "Kod waluty", required = true)
            @PathVariable("code")
            String code,
            @Parameter(description = "Data początkowa w formacie YYYY-MM-DD", required = true)
            @RequestParam("start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,
            @Parameter(description = "Data końcowa w formacie YYYY-MM-DD", required = true)
            @RequestParam("end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end
    ) {
        return ResponseEntity.ok(service.getRates(code, start, end));
    }

}
