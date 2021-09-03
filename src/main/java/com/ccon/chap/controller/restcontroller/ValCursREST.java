package com.ccon.chap.controller.restcontroller;

import com.ccon.chap.dto.ValCursDto;
import com.ccon.chap.service.valcurs.ValCursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/valcurs")
public class ValCursREST {
    private final ValCursService valCursService;

    @Autowired
    public ValCursREST(ValCursService valCursService) {
        this.valCursService = valCursService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValCursDto> findByWriteId(@PathVariable Long id) {
        return new ResponseEntity<>(valCursService.findValCursDtoByWriteId(id), HttpStatus.OK);
    }

    @GetMapping("/last")
    public ResponseEntity<ValCursDto> getLastEntry() {
        return new ResponseEntity<>(valCursService.getLastEntryDto(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ValCursDto>> findAllOrName(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(name != null
                ? valCursService.findValCursDtoByName(name)
                : valCursService.findAllDto(), HttpStatus.OK);
    }

    @GetMapping("/CurrencyId")
    public ResponseEntity<List<ValCursDto>> findByCurrencyId(@RequestParam(required = false) String currencyId) {
        return new ResponseEntity<>(valCursService.findValCursDtoByCurrencyId(currencyId), HttpStatus.OK);
    }

    @GetMapping("/NumCode")
    public ResponseEntity<List<ValCursDto>> findByNumCode(@RequestParam(required = false) Short numCode) {
        return new ResponseEntity<>(valCursService.findValCursDtoByNumCode(numCode), HttpStatus.OK);
    }

    @GetMapping("/ByDate")
    public ResponseEntity<List<ValCursDto>> findByDate(@RequestParam(required = false) String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
        return new ResponseEntity<>(valCursService.findValCursDtoByDate(localDateTime), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody ValCursDto valCursDto) {
        valCursService.createdNewValCursDto(valCursDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody ValCursDto valCursDto, @RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
        valCursDto.setCurrency_date(localDateTime);
        valCursService.updateValCursDto(id, valCursDto);
    }
}