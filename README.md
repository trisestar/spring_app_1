SQL table creating code:

CREATE TABLE `policy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `policy_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
