--liquibase formatted sql

--changeset daniel.patrocinio:1
--precondition-sql-check expectedResult:0 SELECT count(*) FROM pg_class c LEFT JOIN pg_namespace n ON n.oid = c.relnamespace where n.nspname = 'public' and c.relname = 'interessados';
--comment: Criando tabela interessados
create SEQUENCE interessados_id_seq;
create table interessados (
    id varchar(20) primary key not null DEFAULT nextval('interessados_id_seq'),
    nome varchar(255) not null,
   	email varchar(60) not null,
   	data_cadastro timestamp
);
ALTER SEQUENCE interessados_id_seq OWNED BY interessados.id;
--rollback drop table interessados;