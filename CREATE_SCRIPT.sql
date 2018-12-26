CREATE DATABASE eicon_pedido;
USE eicon_pedido;

CREATE TABLE cli_cliente
(
	cli_n_id int auto_increment not null,
	cli_c_nome varchar(255) not null,
	cli_c_email varchar(255),
    cli_c_situacao char(1) not null default 'A',
    
	primary key (cli_n_id)
);

CREATE TABLE ped_pedido
(	
	ped_n_id int auto_increment not null,
	ped_cli_n_id int not null,
	ped_n_num_controle int not null,
	ped_d_dt_cadastro datetime not null,
	ped_n_vlr_total decimal(18,2) not null,
	ped_n_desconto decimal(5,2) not null,
	ped_c_situacao char(1) not null default 'A',
	
	primary key(ped_n_id),
	foreign key(ped_cli_n_id) references cli_cliente(cli_n_id)
);

CREATE TABLE itm_ped_item_pedido
(
	itm_ped_item_pedido_n_id int auto_increment not null,
	itm_ped_ped_n_id int not null,
	itm_ped_itm_c_descricao varchar(255) not null,
	itm_ped_n_vlr_itm decimal(12,2) not null,
	itm_ped_n_quantidade int not null,

	primary key(itm_ped_item_pedido_n_id),
	foreign key(itm_ped_ped_n_id) references ped_pedido(ped_n_id)
);


/**

DELIMITER $$
	CREATE PROCEDURE `while_cli`()
	BEGIN    
		DECLARE i INT;
		SET i=1;
		WHILE (i <= 10) DO
			INSERT INTO eicon_pedido.cli_cliente
				(cli_c_nome, cli_c_email, cli_c_situacao)
			VALUES
					(CONCAT('CLIENTE ',i), CONCAT('CLIENTE',i,'@eicon.com'), 'A');
			SET i=i+1;
		END WHILE;
	END$$
DELIMITER ;

DELIMITER $$
	CREATE PROCEDURE `consulta_pedido`(IN _ped_d_dt_cadastro DATETIME,
									  IN _ped_n_num_controle INT)
	BEGIN
		SELECT 
			`ped_pedido`.`ped_n_id`
		FROM `eicon_pedido`.`ped_pedido`
		WHERE
			(CASE WHEN _ped_d_dt_cadastro IS NOT NULL THEN DATE(_ped_d_dt_cadastro) = DATE(`ped_pedido`.`ped_d_dt_cadastro`) END)
		AND
			(CASE WHEN _ped_n_num_controle IS NOT NULL THEN _ped_n_num_controle = `ped_pedido`.`ped_n_num_controle`  END);
	END 
DELIMITER ;


CALL while_cli();
DROP PROCEDURE while_cli;

**/

