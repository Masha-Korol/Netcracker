create table contracts(
                          id integer not null,
                          start date,
                          finish date,
                          user_id integer,
                          max_internet_speed_mb integer,
                          mb_internet integer,
                          sms integer,
                          canal_package varchar(100),
                          contract_type varchar(100) not null,
                          constraint contracts_pk PRIMARY KEY (id)
);

create table contract_users(
                               id integer not null,
                               last_name varchar(100),
                               birth date,
                               sex varchar(100),
                               passport_number varchar(100),
                               passport_series varchar(100),
                               constraint users_pk PRIMARY KEY (id)
);

alter table contracts add constraint contracts_fk0 FOREIGN KEY (user_id) REFERENCES contract_users (id);
