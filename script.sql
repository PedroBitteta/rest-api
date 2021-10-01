CREATE DATABASE estoque;
USE estoque;

CREATE TABLE estoque (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(20) NOT NULL,
preco DOUBLE NOT NULL
);

INSERT INTO estoque (id,nome,preco) VALUES (1,"Computador",4500);
INSERT INTO estoque (id,nome,preco) VALUES (2,"Headset",700);
DELETE FROM estoque WHERE id = 2;
UPDATE estoque SET nome = "Notebook" , preco = 5500 WHERE id = 1;
SELECT * FROM estoque; 
SELECT id, nome, preco FROM estoque WHERE id = 2;