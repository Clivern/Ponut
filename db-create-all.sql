create table options (
  id                            bigint auto_increment not null,
  opkey                         varchar(255) not null,
  opvalue                       varchar(255) not null,
  autoload                      varchar(255) not null,
  constraint pk_options primary key (id)
);

