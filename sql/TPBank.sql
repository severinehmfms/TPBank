-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS TPBank;
CREATE DATABASE TPBank;
USE TPBank;

-- -----------------------------------------------------------------------------
-- - Construction des TABLES						                     ---
-- -----------------------------------------------------------------------------

CREATE TABLE Customer(
    customer_id            INT              PRIMARY KEY AUTO_INCREMENT,
    name                   VARCHAR(50)      NOT NULL,
    first_name             VARCHAR(50),
    last_name              VARCHAR(50),
    mail                   VARCHAR(50)
) ENGINE = InnoDB;

CREATE TABLE Account (
    account_num			    VARCHAR(50)     PRIMARY KEY,
    type_account    		varchar(50)		NOT NULL,
    create_date             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    balance				    DECIMAL(10,2) 	NOT NULL DEFAULT 0,
    customer_id		        INT	            NOT NULL,
    KEY customer_id(customer_id)
) ENGINE = InnoDB;

CREATE TABLE BankTransaction(
    bank_transaction_id 			INT 	PRIMARY KEY AUTO_INCREMENT,
    bank_transaction_date    	DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    amount          		DECIMAL(10,2) 	NOT NULL,
    type_transaction		varchar(12)		NOT NULL,
    account_num      	    VARCHAR(50) 	NOT NULL,
    KEY account_num (account_num)
) ENGINE = InnoDB;

ALTER TABLE Account
    ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`customer_id`)
;

ALTER TABLE BankTransaction
    ADD CONSTRAINT `bank_transaction_ibfk_1` FOREIGN KEY (`account_num`) REFERENCES `Account` (`account_num`)
;


-- ------------------------------------------------------------------------------
-- - Insertion des données 				                                      ---
-- ------------------------------------------------------------------------------

INSERT INTO `Customer` (`customer_id`, `name`, `first_name`, `last_name`, `mail` ) VALUES
         (1, 'Robert DUPONT', 'Robert', 'DUPONT', 'r.dupont@mail.fr'),
         (2, 'DURAND Eric', 'Eric', 'DURAND', 'e.durand@mail.fr'),
         (3, 'Alice SMITH', 'Alice', 'SMITH', 'a.smith@mail.fr')