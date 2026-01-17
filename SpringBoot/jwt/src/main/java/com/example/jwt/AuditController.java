package com.example.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public class AuditController {

    private static final Logger log = LoggerFactory.getLogger(AuditController.class);

    @GetMapping("/audit")
    public String audit(Authentication auth) {

        log.info("User {} accessed /audit",
            auth.getName());

        return "Logged";
    }
}
