CREATE SEQUENCE seq_entregador
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_pedido
  OWNER TO postgres;

 CREATE SEQUENCE seq_pedido
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_pedido
  OWNER TO postgres;

CREATE SEQUENCE seq_item_pedido
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_pedido
  OWNER TO postgres;  

CREATE TABLE tb_entregador
(
  seq_entregador numeric NOT NULL,
  seq_pessoa numeric NOT NULL,
  dat_contratacao date NOT NULL,
  CONSTRAINT "PK_ENTREGADOR" PRIMARY KEY (seq_entregador),
  CONSTRAINT "FK_ENTREGADOR_PESSOA" FOREIGN KEY (seq_pessoa)
      REFERENCES tb_pessoa (seq_pessoa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "UK_ENTREGADOR" UNIQUE (seq_pessoa)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tb_entregador
  OWNER TO postgres;

DROP TABLE tb_item_pedido;
DROP TABLE tb_pedido;

CREATE TABLE tb_pedido (
   seq_pedido numeric NOT NULL,
   seq_cliente numeric,
   dth_cadastro timestamp NOT NULL,
   dth_entrega timestamp NOT NULL,
   val_pagar numeric,
   val_troco numeric,
   val_pago numeric,
   val_troco_para numeric,
   ind_requer_talher boolean,
   dth_entregar_a_partir_de time,
   dth_entregar_ate time,
   txt_observacao text,
   num_volumes numeric,
   seq_entregador numeric,
   txt_numero_telefone character varying(20) NOT NULL,
   txt_endereco character varying(200) NOT NULL,
   txt_numero_endereco character varying(10) NOT NULL,
   seq_bairro numeric NOT NULL,
   txt_cep character varying(8),
   txt_ponto_referencia text,
   txt_complemento character varying(200),
   txt_status character varying(1),
   CONSTRAINT "PK_PEDIDO" PRIMARY KEY (seq_pedido),
   CONSTRAINT "FK_PEDIDO_CLIENTE" FOREIGN KEY (seq_cliente)
      REFERENCES tb_cliente (seq_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "FK_PEDIDO_ENTREGADOR" FOREIGN KEY (seq_entregador)
      REFERENCES tb_entregador(seq_entregador) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "FK_PEDIDO_BAIRRO" FOREIGN KEY (seq_bairro)
      REFERENCES tb_bairro (seq_bairro) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "CK_STATUS" CHECK (txt_status::text = ANY (ARRAY['A'::character varying, 'C'::character varying, 'D'::character varying, 'E'::character varying]::text[]))
)
WITH (
  OIDS=FALSE
);      
ALTER TABLE tb_pedido OWNER TO postgres;

CREATE TABLE tb_item_pedido (
   seq_item_pedido numeric not null,
   seq_pedido numeric not null,
   seq_produto numeric not null,
   num_quantidade numeric not null,
   val_unitario numeric not null,
   ind_prato_sofreu_alteracao boolean,
   txt_alteracao_prato text,
   ind_molho_sofreu_alteracao boolean,
   txt_alteracao_molho text,
   CONSTRAINT "PK_ITEM_PEDIDO" PRIMARY KEY (seq_item_pedido),
   CONSTRAINT "FK_ITEM_PEDIDO_PEDIDO" FOREIGN KEY (seq_pedido)
      REFERENCES tb_pedido (seq_pedido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "FK_ITEM_PEDIDO_PRODUTO" FOREIGN KEY (seq_produto)
      REFERENCES tb_produto (seq_produto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);      
ALTER TABLE tb_item_pedido OWNER TO postgres;      
   	
        