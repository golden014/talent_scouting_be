package org.enrichment.talent_scouting_backend.controllers;

import org.enrichment.talent_scouting_backend.models.Dummy;
import org.enrichment.talent_scouting_backend.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/getAllDummys")
    public ResponseEntity<List<Dummy>> getAllDummys() {
        List<Dummy> dummys = dummyService.getAllDummy();
        return ResponseEntity.ok(dummys);
    }

    @GetMapping("/getDummyById/{id}")
    public ResponseEntity<Dummy> getDummyByID (@PathVariable String id) {
        Dummy dummy = dummyService.getDummyById(id);
        if (dummy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dummy);
    }

    @PostMapping("/addDummy")
    public int addDummy(@RequestBody Dummy dummy) {
        return dummyService.addDummy (dummy);
    }




}
