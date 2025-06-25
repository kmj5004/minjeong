package com.minjeong.usedPhone.controller;

import com.minjeong.usedPhone.entity.UsedPhoneEntity;
import com.minjeong.usedPhone.service.UsedPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usedphones")
public class UsedPhoneController {
    private final UsedPhoneService usedPhoneService;

    @Autowired
    public UsedPhoneController(UsedPhoneService usedPhoneService) {
        this.usedPhoneService = usedPhoneService;
    }

    @PostMapping
    public UsedPhoneEntity create(@RequestBody UsedPhoneEntity usedPhone) {
        return usedPhoneService.save(usedPhone);
    }

    @GetMapping
    public List<UsedPhoneEntity> getAll() {
        return usedPhoneService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UsedPhoneEntity> getById(@PathVariable Long id) {
        return usedPhoneService.findById(id);
    }

    @PutMapping("/{id}")
    public UsedPhoneEntity update(@PathVariable Long id, @RequestBody UsedPhoneEntity usedPhone) {
        return usedPhoneService.save(usedPhone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usedPhoneService.deleteById(id);
    }
}
