create table customers(
customer_id int primary key,
full_name varchar(100) not null,
email_address varchar(100)not null,
age int check (age > 0),
credit_balance numeric(12, 2) default 0.00,
registered_at TIMESTAMPTZ default current_timestamp 
);

select column_name, data_type, character_maximum_length
from information_schema.columns
where table_name = 'customers';