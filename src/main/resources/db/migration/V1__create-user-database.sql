CREATE TABLE IF NOT EXISTS Users (
    user_id UUID PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_login VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    user_role VARCHAR(10) NOT NULL
);

INSERT INTO Users (user_id, user_name, user_login, user_password, user_role)
VALUES (gen_random_uuid(), 'admin', 'admin', '{noop}admin', 'ADMIN')
ON CONFLICT (user_login) DO NOTHING;



