package org.enrichment.talent_scouting_backend.services;

import org.enrichment.talent_scouting_backend.models.Dummy;
import org.enrichment.talent_scouting_backend.repositories.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyService {
    @Autowired
    private DummyRepository dummyRepository;

    public List<Dummy> getAllDummy() {
        return dummyRepository.getAllDummy();
    }

    public Dummy getDummyById(String id) {
        return dummyRepository.getDummyById(id);
    }

    public int addDummy(Dummy dummy) {
        return dummyRepository.addDummy(dummy);
    }
}
