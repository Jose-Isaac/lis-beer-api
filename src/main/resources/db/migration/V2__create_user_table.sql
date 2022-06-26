CREATE TABLE users (
   id           uuid         not null primary key,
   email        varchar(255) not null unique,
   password     varchar(255) not null,
   username     varchar(255) not null unique
);

CREATE INDEX users_email_index ON users(email);