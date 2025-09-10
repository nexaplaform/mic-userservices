package com.fiverr.app.mic.userservices.api.service;

import com.fiverr.app.mic.userservices.api.service.dto.in.SortEnumDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseApi<I, O, K> {


    @PostMapping
    @Operation(
            summary= "Create record",
            description = "Creation of record.")
    default ResponseEntity<O> create(@RequestBody I dto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update record.",
            description = "Update a record by id.")
    default ResponseEntity<O> update(@RequestBody I dto, @PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get record by id.",
            description = "Search a record by id.")
    default ResponseEntity<O> getById(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete record",
            description = "Delete record by id.")
    default ResponseEntity<Void> delete(@PathVariable K id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    @Operation(
            summary = "Get paginated record",
            description = "Get all records paginated."
    )
    default ResponseEntity<List<O>> findAll(
            @RequestParam(required = true, defaultValue = "0") Integer page,
            @RequestParam(required = true, defaultValue = "9") Integer size,
            @RequestParam(required = false, defaultValue = "ASC") SortEnumDTO sortDirection) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
