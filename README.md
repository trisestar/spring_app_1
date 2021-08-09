Реализовал просмотр всех страховок и добавление новых. На странице добавления все поля для ввода валидированы.
С docker раньше не сталкивался, погуглил, разобраться можно, но боюсь что тогда не уложусь в обговоренное время. Так что кидаю так.
Спасибо за потраченное время :)


SQL table creating code:

CREATE TABLE `policy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `policy_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
