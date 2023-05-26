CREATE TABLE IF NOT EXISTS subscription
(
    id                SERIAL PRIMARY KEY,
    subscription_type VARCHAR(255) NOT NULL,
    begin_date        DATE         NOT NULL,
    end_date          DATE         NOT NULL,
    status            VARCHAR(255) NOT NULL,
    user_id           INT
);


CREATE TABLE IF NOT EXISTS trainers
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS training
(
    id              SERIAL PRIMARY KEY,
    start_date_time TIMESTAMP,
    end_date_time   TIMESTAMP,
    status          VARCHAR(255) NOT NULL,
    trainer_id      INT,
    user_id         INT
);


CREATE TABLE IF NOT EXISTS app_user
(
    id           SERIAL PRIMARY KEY,
    email        VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    birthdate    DATE         NOT NULL,
    phone_number VARCHAR(255) NOT NULL
);


INSERT INTO app_user (email, password, first_name, last_name, birthdate, phone_number)
VALUES ('user1@example.com', 'password1', 'Alice', 'Johnson', '1990-01-01', '123456789');
INSERT INTO app_user (email, password, first_name, last_name, birthdate, phone_number)
VALUES ('user2@example.com', 'password2', 'Bob', 'Smith', '1995-02-02', '987654321');
INSERT INTO app_user (email, password, first_name, last_name, birthdate, phone_number)
VALUES ('user3@example.com', 'password3', 'Charlie', 'Doe', '1998-03-03', '456789123');

INSERT INTO trainers (email, first_name, last_name)
VALUES ('trainer1@example.com', 'John', 'Doe');
INSERT INTO trainers (email, first_name, last_name)
VALUES ('trainer2@example.com', 'Jane', 'Smith');
INSERT INTO trainers (email, first_name, last_name)
VALUES ('trainer3@example.com', 'Michael', 'Johnson');


INSERT INTO subscription (subscription_type, begin_date, end_date, status, user_id)
VALUES ('FOUR', '2023-01-01', '2023-02-01', 'ACTIVE', 1);
INSERT INTO subscription (subscription_type, begin_date, end_date, status, user_id)
VALUES ('SIX', '2023-03-01', '2023-04-01', 'INACTIVE', 2);
INSERT INTO subscription (subscription_type, begin_date, end_date, status, user_id)
VALUES ('EIGHT', '2023-05-01', '2023-06-01', 'ACTIVE', 3);

INSERT INTO training (start_date_time, end_date_time, status, trainer_id, user_id)
VALUES ('2023-01-01T10:00:00', '2023-01-01T11:00:00', 'COMPLETED', 1, 1);
INSERT INTO training (start_date_time, end_date_time, status, trainer_id, user_id)
VALUES ('2023-02-01T14:00:00', '2023-02-01T15:00:00', 'UPCOMING', 2, 2);
INSERT INTO training (start_date_time, end_date_time, status, trainer_id, user_id)
VALUES ('2023-03-01T09:00:00', '2023-03-01T10:00:00', 'COMPLETED', 3, 3);