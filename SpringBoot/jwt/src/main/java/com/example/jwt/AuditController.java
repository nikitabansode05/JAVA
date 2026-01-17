package com.example.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public class AuditController {
     @GetMapping("/audit")
    public String audit(Authentication auth) {

        log.info("User {} accessed /audit",
            auth.getName());

        return "Logged";
    }
}
