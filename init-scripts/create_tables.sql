CREATE DATABASE IF NOT EXISTS sys;
USE sys;
CREATE TABLE USER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
