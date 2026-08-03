DROP TABLE IF EXISTS bank_accounts CASCADE;

CREATE TABLE bank_accounts (
    account_id INT PRIMARY KEY,
    owner_name VARCHAR(100) NOT NULL,
    balance DECIMAL(12, 2) NOT NULL,
    CONSTRAINT chk_positive_balance CHECK (balance >= 0.00)
);

INSERT INTO bank_accounts (account_id, owner_name, balance) VALUES 
(101, 'David Miller', 500.00),
(102, 'Emily Davis', 150.00);


-- Task 1: Basic Successful Transfer
select account_id, owner_name, balance 
from bank_accounts where account_id in (101, 102);
begin;
	update bank_accounts set balance = balance - 100 where account_id = 101;
	update bank_accounts set balance = balance + 100 where account_id = 102;
commit;

select account_id, owner_name, balance from bank_accounts where account_id in (101, 102);

-- Task 2: Failed transfer
begin;
	update bank_accounts set balance = balance - 600 where account_id = 101;
	update bank_accounts set balance = balance + 600 where account_id = 102;
rollback;

select account_id, owner_name, balance from bank_accounts where account_id in (101,102);

--Task 3: Savepoint Checkpoints

begin;
	insert into bank_accounts (account_id, owner_name, balance) values (103, 'David Vault', 0.00);
	savepoint vault_created;
	update bank_accounts set balance = balance - 300.00 where account_id = 101;
	update bank_accounts set balance = balance + 300.00 where account_id = 103;
	rollback to savepoint vault_created;
commit;

select account_id, owner_name, balance from bank_accounts where account_id in (101, 103);