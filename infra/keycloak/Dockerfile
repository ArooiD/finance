FROM quay.io/keycloak/keycloak:20.0.3

ENV KEYCLOAK_ADMIN=admin
ENV KC_FEATURES=admin2,admin-api
ENV KC_DB=postgres

EXPOSE 7777

ENTRYPOINT ["sh", "/opt/keycloak/bin/kc.sh", "start"]