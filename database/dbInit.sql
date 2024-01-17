CREATE DATABASE bank_manager;

\c bank_manager;

CREATE TABLE IF NOT EXISTS org_legal_forms (
    org_legal_forms_id serial PRIMARY KEY,
	org_legal_forms_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS clients ( 
	client_id serial PRIMARY KEY,
	client_name VARCHAR (50) NOT NULL,
	client_short_name VARCHAR (50) NOT NULL,
	address VARCHAR (50) NOT NULL,
	org_legal_forms_id integer NOT NULL,
	
	FOREIGN KEY (org_legal_forms_id) REFERENCES org_legal_forms (org_legal_forms_id) MATCH SIMPLE
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS banks (
	bank_id serial PRIMARY KEY,
	bank_name VARCHAR (50) NOT NULL,
	bic integer NOT NULL
);

CREATE TABLE deposits (
	deposit_id serial PRIMARY KEY,
	client_id integer NOT NULL,
	bank_id integer NOT NULL,
	opening_date timestamp NOT NULL,
	percent integer NOT NULL,
	period_month integer NOT NULL,
	
	FOREIGN KEY (client_id) REFERENCES clients (client_id) MATCH SIMPLE
		ON UPDATE CASCADE ON DELETE CASCADE,

	FOREIGN KEY (bank_id) REFERENCES banks (bank_id) MATCH SIMPLE
		ON UPDATE CASCADE ON DELETE CASCADE
);	