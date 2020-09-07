DROP SCHEMA IF EXISTS `viafa-bmb-trasporti`;

CREATE SCHEMA `viafa-bmb-trasporti`;

use `viafa-bmb-trasporti`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(45) DEFAULT NULL,
    `address` VARCHAR(45) DEFAULT NULL,
    `city` VARCHAR(45) DEFAULT NULL,
    `cap` VARCHAR(10) DEFAULT NULL,
    `phone` VARCHAR(15) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `fax` VARCHAR(15) DEFAULT NULL,
    `contact_name` VARCHAR(45) DEFAULT NULL,
    `contact_phone` VARCHAR(15) DEFAULT NULL,
    `contact_email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
 `id`         int(11) NOT NULL AUTO_INCREMENT,
 `first_name` varchar(45) DEFAULT NULL,
 `last_name`  varchar(45) DEFAULT NULL,
 `phone`      varchar(45) DEFAULT NULL,
 `email`      varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `truck`;
CREATE TABLE `truck` (
 `id`                int(11) NOT NULL AUTO_INCREMENT,
 `brand`             varchar(45) DEFAULT NULL,
 `model`             varchar(45) DEFAULT NULL,
 `year`              int(4) DEFAULT NULL,
 `insurance_expiry`  datetime DEFAULT NULL,
 `revision_deadline` datetime DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
 `id`             int(11) NOT NULL AUTO_INCREMENT,
 `driver_id`      int(11) DEFAULT NULL,
 `truck_id`       int(11) DEFAULT NULL,
 `client_id`      int(11) DEFAULT NULL,
 `departure`      varchar(45) DEFAULT NULL,
 `destination`    varchar(45) DEFAULT NULL,
 `tot_km`         int DEFAULT NULL,
 `rate`           int DEFAULT NULL,
 `travel_date`    datetime DEFAULT NULL,
 `departure_date` datetime DEFAULT NULL,
 `arrival_date`   datetime DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_DRIVER_idx` (`driver_id`),
  CONSTRAINT `FK_DRIVER`
  FOREIGN KEY (`driver_id`)
  REFERENCES `driver` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_TRUCK_idx` (`truck_id`),
  CONSTRAINT `FK_TRUCK`
  FOREIGN KEY (`truck_id`)
  REFERENCES `truck` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_CLIENT_idx` (`client_id`),
  CONSTRAINT `FK_CLIENT`
  FOREIGN KEY (`client_id`)
  REFERENCES `client` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
 `id`             int(11) NOT NULL AUTO_INCREMENT,
 `travel_id`      int(11) DEFAULT NULL,
 `invoice_number` int DEFAULT NULL,
 `invoice_pdf`    blob DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_TRAVEL_idx` (`travel_id`),
  CONSTRAINT `FK_TRAVEL`
  FOREIGN KEY (`travel_id`)
  REFERENCES `travel` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;