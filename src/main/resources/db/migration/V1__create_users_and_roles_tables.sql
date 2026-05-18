CREATE TABLE users_data
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    password_hash  VARCHAR(255) NOT NULL,
    email          VARCHAR(50)  NOT NULL UNIQUE,
    verified_email BOOLEAN      NOT NULL DEFAULT FALSE,
    first_name     VARCHAR(80)  NOT NULL,
    last_name      VARCHAR(80)  NOT NULL,
    created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE roles
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL REFERENCES users_data (id) ON DELETE CASCADE,
    role_id BIGINT NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);