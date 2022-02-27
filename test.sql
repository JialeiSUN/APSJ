CREATE TABLE IF NOT EXISTS User (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    passwd VARCHAR(255) NOT NULL,
    prenom VARCHAR(50) not null,
    nom VARCHAR(20) not null,
    mail VARCHAR(100) not null,
    adress VARCHAR(255) not null
)  ENGINE=INNODB;

ALTER TABLE User ADD passwd VARCHAR(255) NOT NULL;
ALTER TABLE User ADD user_role VARCHAR(10) NOT NULL;
