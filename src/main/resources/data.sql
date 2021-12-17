INSERT INTO tb_servidor(nome, telefone, email, senha)
VALUES ('Ana Cavalcanti', '(67) 99999-7788', 'ana@gmail.com', '456');

INSERT INTO tb_ordem_de_servico(equipamento, patrimonio, setor, descricao_problema, 
data_cadastro, status, prioridade, descricao_solucao, servidor_id)
VALUES(1, '1234', 'CEREL', 'Não está ligando', '2021-08-01 09:30:00',
'PENDENTE', 'ALTA', '', 1);
