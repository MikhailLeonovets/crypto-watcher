create database crypto_currency_db;

create table crypto_currency
(
    id            bigserial
        primary key,
    symbol        varchar(5)     not null
        unique,
    current_price numeric(10, 8) not null
);

alter table crypto_currency
    owner to postgres;

create table app_user
(
    id                 bigserial
        primary key,
    username           varchar(255)   not null
        unique,
    crypto_currency_id bigint         not null
        references crypto_currency
            on update cascade on delete cascade,
    first_crypto_price numeric(10, 8) not null
);

alter table app_user
    owner to postgres;
