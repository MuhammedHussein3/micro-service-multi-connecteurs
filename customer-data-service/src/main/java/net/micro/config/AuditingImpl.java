package net.micro.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditingImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("test system");
    }
}
