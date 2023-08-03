CREATE TABLE card_brand (
    brand_id BIGINT PRIMARY KEY,
    name_brand VARCHAR(255) NOT NULL
);

CREATE TABLE card (
    card_id BIGINT PRIMARY KEY,
    amount INT NOT NULL,
    card_number VARCHAR(20) NOT NULL,
    symbol VARCHAR(10) NOT NULL,
    brand_id BIGINT UNIQUE,
    CONSTRAINT fk_card
        FOREIGN KEY (brand_id)
        REFERENCES card_brand (brand_id)
);

CREATE TABLE transactions (
    transaction_id BIGINT PRIMARY KEY,
    amount INT NOT NULL,
	note VARCHAR(255) NOT NULL,
	card_id BIGINT NOT NULL,
	wallet_id BIGINT NOT NULL,
	outcome_id BIGINT NOT NULL,
	income_id BIGINT NOT NULL,
	CONSTRAINT transactions_card
        FOREIGN KEY (card_id)
        REFERENCES card (card_id),
	CONSTRAINT transactions_wallet
        FOREIGN KEY (wallet_id)
        REFERENCES wallet (wallet_id),
	CONSTRAINT transactions_outcome
        FOREIGN KEY (outcome_id)
        REFERENCES outcome (outcome_id),
	CONSTRAINT transactions_income
        FOREIGN KEY (income_id)
        REFERENCES income (income_id)
);
CREATE TABLE transaction_categogy (
  transaction_id BIGINT NOT NULL,
  categogy_id BIGINT NOT NULL,
  PRIMARY KEY (transaction_id, categogy_id),
  CONSTRAINT fk_transaction FOREIGN KEY(transaction_id) REFERENCES transactions(transaction_id),
  CONSTRAINT fk_categogy FOREIGN KEY(categogy_id) REFERENCES categogy(categogy_id)
)
CREATE TABLE categogy (
    categogy_id BIGINT PRIMARY KEY,
    name_categogy VARCHAR(255) NOT NULL
);

CREATE TABLE outcome (
    outcome_id BIGINT PRIMARY KEY,
    date_time DATE NOT NULL
);
CREATE TABLE income (
    income_id BIGINT PRIMARY KEY,
    date_time DATE NOT NULL
);
CREATE TABLE report (
    report_id BIGINT PRIMARY KEY,
    name_report VARCHAR(255) NOT NULL,
	type_report VARCHAR(10) NOT NULL
);
CREATE TABLE user_model_report (
  user_id BIGINT NOT NULL,
  report_id BIGINT NOT NULL,
  PRIMARY KEY (user_id, report_id),
  CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES user_model(user_id),
  CONSTRAINT fk_report FOREIGN KEY(report_id) REFERENCES report(report_id)
)
CREATE TABLE saving_taget(
	sv_id BIGINT PRIMARY KEY,
	name_sv VARCHAR(255) NOT NULL,
	describe_sv VARCHAR(255) NOT NULL,
	amount_sv INT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL
);
CREATE TABLE user_model (
    user_id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    email_verified VARCHAR(255) NOT NULL,
    enabled VARCHAR(255) NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	sv_id BIGINT UNIQUE NOT NULL,
    wallet_id BIGINT UNIQUE NOT NULL,
    CONSTRAINT fk_user_target
        FOREIGN KEY (sv_id)
        REFERENCES saving_taget (sv_id)
);
CREATE TABLE currency(
	currency_id BIGINT PRIMARY KEY,
	name_currency VARCHAR(255) NOT NULL
);
CREATE TABLE wallet_currency (
  wallet_id BIGINT NOT NULL,
  currency_id BIGINT NOT NULL,
  PRIMARY KEY (wallet_id, currency_id),
  CONSTRAINT fk_wallet FOREIGN KEY(wallet_id) REFERENCES wallet(wallet_id),
  CONSTRAINT fk_currency FOREIGN KEY(currency_id) REFERENCES currency(currency_id)
)
CREATE TABLE wallet (
    wallet_id BIGINT PRIMARY KEY,
    cash INT NOT NULL,
    creadit INT NOT NULL,
    total INT NOT NULL,
    user_id BIGINT UNIQUE NOT NULL,
    CONSTRAINT fk_wallet_user
        FOREIGN KEY (user_id)
        REFERENCES user_model (user_id)
);
