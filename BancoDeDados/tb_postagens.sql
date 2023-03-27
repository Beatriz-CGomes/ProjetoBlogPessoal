-- select@@version ---
USE db_blogpessoal;

INSERT INTO tb_postagens (data, texto, titulo) 
VALUES (current_timestamp(), 'Olá Mundo!! 01', 'Postagem 01');

INSERT INTO tb_postagens (data, texto, titulo)
VALUES (current_timestamp(), 'Texto para segunda postagem', 'Postagem 02');

SELECT * FROM tb_postagens;