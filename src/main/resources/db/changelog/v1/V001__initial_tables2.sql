--liquibase formatted sql
--changeset albert:1

CREATE TABLE organizers
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(128) NOT NULL,
    delete      BOOLEAN      NOT NULL DEFAULT FALSE,
    date_create TIMESTAMP,
    date_delete TIMESTAMP
);
