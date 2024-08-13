--liquibase formatted sql
--changeset albert:1

CREATE TABLE organizers
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(128) NOT NULL,
    date_create TIMESTAMP
);
