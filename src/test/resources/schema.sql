CREATE TABLE IF NOT EXISTS "subscription" (
    id INT PRIMARY KEY,
    subscription_type VARCHAR(255),
    begin_date DATE,
    end_date DATE,
    status VARCHAR(255),
    user_id INT
    );

CREATE TABLE IF NOT EXISTS "trainers" (
    id INT PRIMARY KEY,
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS "training" (
    id INT PRIMARY KEY,
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    status VARCHAR(255),
    trainer_id INT,
    user_id INT
    );

CREATE TABLE IF NOT EXISTS "app_user" (
    id INT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birthdate DATE,
    phone_number VARCHAR(255)
    );
