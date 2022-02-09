create sequence seq_order;

create table orders
(
    id            bigint not null primary key default nextval('seq_order'),
    cake_id       bigint,
    user_id       bigint,
    delivery_date timestamp with time zone
);