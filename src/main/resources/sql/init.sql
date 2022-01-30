CREATE SCHEMA IF NOT EXISTS `testdb`;
CREATE TABLE IF NOT EXISTS `testdb`.`account` (
                                               `id` int NOT NULL AUTO_INCREMENT,
                                               `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `age` int COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `testdb`.`account` (username, password, email, age, `role`) VALUES ('admin', '1111', 'dfadf@naver.com', 22, 'ROLE_ADMIN');