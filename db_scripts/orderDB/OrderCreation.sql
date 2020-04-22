create database orderdb;
CREATE TABLE IF NOT EXISTS orderdb.orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
	uid INT NOT NULL,
	total DECIMAL(13, 4) UNSIGNED NOT NULL,
	shippingCharges DECIMAL(13, 4) UNSIGNED  NOT NULL,
	DEcoins DECIMAL(13, 4)UNSIGNED NOT NULL,
	CODcharges DECIMAL(13, 4)UNSIGNED  NOT NULL,
	total_cash_to_take DECIMAL(13, 4)UNSIGNED  NOT NULL,
	status VARCHAR(15)NOT NULL,
	courierPartnerID int NOT NULL,	
	ETA TIMESTAMP NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS orderdb.orderItemMapping (
    id INT AUTO_INCREMENT PRIMARY KEY,
	oid int NOT NULL,
	itemid int NOT NULL,
	qty int NOT NULL,
	qtytype varchar(3) NOT NULL,
	status varchar(10)NOT NULL,
    FOREIGN KEY (oid) REFERENCES orders(id)
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS orderdb.deliverPartner (
    id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) NOT NULL,
	phoneno1 DECIMAL(13) NOT NULL,
	phoneno2 DECIMAL(13) NOT NULL,
	email varchar(100) NOT NULL
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS orderdb.deliverStatus (
    id INT AUTO_INCREMENT PRIMARY KEY,
	oid int NOT NULL,
	status varchar(10) NOT NULL,
	comments varchar(100) NOT NULL,
	did int NOT NULL,
	FOREIGN KEY (oid) REFERENCES orders(id),
	FOREIGN KEY (did) REFERENCES deliverPartner(id)
)  ENGINE=INNODB;


