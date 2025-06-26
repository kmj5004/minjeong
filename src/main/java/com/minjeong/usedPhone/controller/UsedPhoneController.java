package com.minjeong.usedPhone.controller;

import com.minjeong.usedPhone.dto.ResponseWrapper;
import com.minjeong.usedPhone.dto.UsedPhoneRequestDTO;
import com.minjeong.usedPhone.dto.UsedPhoneResponseDTO;
import com.minjeong.usedPhone.service.UsedPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usedphones")
public class UsedPhoneController {
    private final UsedPhoneService usedPhoneService;

    @Autowired
    public UsedPhoneController(UsedPhoneService usedPhoneService) {
        this.usedPhoneService = usedPhoneService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseWrapper<UsedPhoneResponseDTO> create(@RequestBody UsedPhoneRequestDTO request) {
        return usedPhoneService.save(request);
    }

    @GetMapping("/")
    public List<UsedPhoneResponseDTO> getAll() {
        return usedPhoneService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UsedPhoneResponseDTO> getById(@PathVariable Long id) {
        return usedPhoneService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseWrapper<UsedPhoneResponseDTO> update(@PathVariable Long id, @RequestBody UsedPhoneRequestDTO request) {
        return usedPhoneService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseWrapper<Object> delete(@PathVariable Long id) {
        return usedPhoneService.deleteById(id);
    }
}