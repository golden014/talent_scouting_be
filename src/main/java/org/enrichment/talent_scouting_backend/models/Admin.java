package org.enrichment.talent_scouting_backend.models;

import org.enrichment.talent_scouting_backend.enums.Role;

public class Admin extends User{
    public Admin() {
        this.setRole(Role.ADMIN);
    }
}
