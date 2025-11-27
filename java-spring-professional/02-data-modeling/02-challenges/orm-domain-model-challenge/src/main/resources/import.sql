-- 1. CATEGORIAS (Independentes)
INSERT INTO tb_categoria(id, descricao) VALUES (1, 'Curso');
INSERT INTO tb_categoria(id, descricao) VALUES (2, 'Oficina');

-- 2. PARTICIPANTES (Independentes)
INSERT INTO tb_participante(id, nome, email) VALUES (1, 'José Silva', 'jose@gmail.com');
INSERT INTO tb_participante(id, nome, email) VALUES (2, 'Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante(id, nome, email) VALUES (3, 'Maria do Rosário', 'maria@gmail.com');
INSERT INTO tb_participante(id, nome, email) VALUES (4, 'Teresa Silva', 'teresa@gmail.com');

-- 3. ATIVIDADES (Dependem de Categoria)
INSERT INTO tb_atividade(id, nome, descricao, preco, categoria_id) VALUES (1, 'Curso de HTML', 'Aprenda HTML de forma prática', 80.00, 1);
INSERT INTO tb_atividade(id, nome, descricao, preco, categoria_id) VALUES (2, 'Oficina de Github', 'Controle versões de seus projetos', 50.00, 2);

-- 4. BLOCOS (Dependem de Atividade)
-- Nota: O formato TIMESTAMP WITH TIME ZONE garante que o H2 entenda o horário UTC (Z)
INSERT INTO tb_bloco(id, inicio, fim, atividade_id) VALUES (1, TIMESTAMP WITH TIME ZONE '2017-09-25T08:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T11:00:00Z', 1);
INSERT INTO tb_bloco(id, inicio, fim, atividade_id) VALUES (2, TIMESTAMP WITH TIME ZONE '2017-09-25T14:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T18:00:00Z', 2);
INSERT INTO tb_bloco(id, inicio, fim, atividade_id) VALUES (3, TIMESTAMP WITH TIME ZONE '2017-09-26T08:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-26T11:00:00Z', 2);

-- 5. ASSOCIAÇÃO (N:N) ATIVIDADE <-> PARTICIPANTE
-- José Silva (1) participa da Atividade 1 e 2
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (1, 1);
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (2, 1);

-- Tiago Faria (2) participa da Atividade 1
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (1, 2);

-- Maria do Rosário (3) participa da Atividade 1 e 2
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (1, 3);
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (2, 3);

-- Teresa Silva (4) participa da Atividade 2
INSERT INTO tb_atividade_participante(atividade_id, participante_id) VALUES (2, 4);