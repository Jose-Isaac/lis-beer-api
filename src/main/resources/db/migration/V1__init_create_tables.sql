CREATE TABLE address (
   id           uuid         not null primary key,
   street       varchar(100) not null,
   city         varchar(50)  not null,
   state        varchar(40)  not null,
   postalCode   int          not null,
   country      varchar(60)  not null,
   houseNumber  int          not null,
   complement   varchar(200)
);

CREATE TABLE stores (
    id           uuid               not null,
    fantasy_name varchar(200)       not null unique,
    access_rule  varchar(20)        not null default 'USER',
    email        varchar(255)       not null unique,
    password     varchar(200)       not null,
    evaluation   double precision   not null default 0.0,
    photo_url    text               not null,
    address_id   uuid               not null,
    PRIMARY KEY (id),
    CONSTRAINT fk_address
        FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE beers (
    id          uuid                not null,
    name        varchar(200)        not null unique,
    evaluation  double precision    not null default 0.0,
    brand       varchar(30)         not null,
    price       decimal(4, 2)       not null,
    photo_url   text                not null,
    store_id    uuid                not null,
    PRIMARY KEY (id),
    CONSTRAINT fk_store
        FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE IF NOT EXISTS categories (
    id          uuid                not null,
    name        varchar(200)        not null unique,
    evaluation  double precision    not null default 0.0,
    PRIMARY KEY (id)
);

CREATE TABLE beers_categories (
    id               uuid,
    beer_id          uuid,
    category_id      uuid,
    PRIMARY KEY (beer_id, category_id),
    CONSTRAINT fk_beer
        FOREIGN KEY (beer_id) REFERENCES beers(id),
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES categories(id)
);