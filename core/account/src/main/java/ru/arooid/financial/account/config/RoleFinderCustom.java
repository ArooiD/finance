package ru.arooid.financial.account.config;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.security.token.RolesFinder;
import jakarta.inject.Singleton;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Singleton
@Replaces(RolesFinder.class)
public class RoleFinderCustom implements RolesFinder {
    @Override
    public @NonNull List<String> resolveRoles(@Nullable Map<String, Object> attributes) {
        return List.of();
    }

    @Override
    public boolean hasAnyRequiredRoles(@NonNull List<String> requiredRoles, @Nullable Map<String, Object> attributes) {
        return RolesFinder.super.hasAnyRequiredRoles(requiredRoles, attributes);
    }

    @Override
    public boolean hasAnyRequiredRoles(@NonNull List<String> requiredRoles, @NonNull Collection<String> grantedRoles) {
        return RolesFinder.super.hasAnyRequiredRoles(requiredRoles, grantedRoles);
    }
}
