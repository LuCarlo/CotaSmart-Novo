package br.com.cotasmart.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreationFactory {
	private Connection connection;
	
	public CreationFactory() throws SQLException {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void criarTabelas() throws SQLException{ 	
		String SQL =
					"DROP TABLE cidades CASCADE; "+
					"DROP TABLE cotacao CASCADE; "+
					"DROP TABLE cotacaoprodutos CASCADE; "+
					"DROP TABLE empresa CASCADE; "+
					"DROP TABLE fornecedores CASCADE; "+
					"DROP TABLE grupoprodutos CASCADE; "+
					"DROP TABLE gruposUsuario CASCADE; "+
					"DROP TABLE produtos CASCADE; "+
					"DROP TABLE status CASCADE; "+
					"DROP TABLE uf CASCADE; "+
					"DROP TABLE usuarios CASCADE;"+
					" "+
					"CREATE TABLE IF NOT EXISTS status ( "+
					"codStatus SERIAL, "+
					"nome CHARACTER VARYING (20), "+
					"tipo CHARACTER VARYING (1),"+
					"CONSTRAINT pk_status PRIMARY KEY (codStatus)); "+
					" "+
					"CREATE TABLE  IF NOT EXISTS gruposUsuario ( "+
					"codGrupo SERIAL, "+
					"nome CHARACTER VARYING (20),"+
					"CONSTRAINT pk_grupos_usuario PRIMARY KEY (codGrupo));"+
					" "+
					"CREATE TABLE IF NOT EXISTS usuarios ( "+
					"codUsuario SERIAL, "+
					"nome CHARACTER VARYING(50), "+
					"login CHARACTER VARYING (20), "+
					"senha CHARACTER VARYING (10), "+
					"ativo BOOLEAN, "+
					"administrador BOOLEAN,"+
					"CONSTRAINT pk_usuario PRIMARY KEY (codUsuario));" +
					" "+
					"CREATE TABLE IF NOT EXISTS uf ( "+
					"codUf SERIAL, "+
					"uf CHARACTER VARYING (2), "+
					"CONSTRAINT pk_uf PRIMARY KEY (codUf));"+
					" "+
					"CREATE TABLE IF NOT EXISTS cidades ( "+
					"codCidade SERIAL, "+
					"nome CHARACTER VARYING (100), "+
					"uf CHARACTER VARYING(2), "+
					"CONSTRAINT pk_cidades PRIMARY KEY (codCidade));"+
					" "+
					"CREATE TABLE IF NOT EXISTS fornecedores ("+
					"codFornecedor SERIAL,"+
					"cnpj CHARACTER VARYING (20),"+	
					"nome CHARACTER VARYING (50), "+
					"endereco CHARACTER VARYING (100), "+
					"cidade CHARACTER VARYING(100), "+
					"uf CHARACTER VARYING (2), "+
					"telefone1 CHARACTER VARYING(20), "+
					"telefone2 CHARACTER VARYING(20), "+
					"telefone3 CHARACTER VARYING(20), "+
					"codUsuario INTEGER REFERENCES usuarios ON DELETE CASCADE, "+
					"ativo boolean, "+
					"CONSTRAINT pk_fornecedores PRIMARY KEY (codFornecedor));"+
					" "+
					"CREATE TABLE IF NOT EXISTS grupoProdutos ( "+
					"codGrupoProdutos SERIAL, "+
					"nome CHARACTER VARYING(20),"+
					"CONSTRAINT pk_grupoProdutos PRIMARY KEY(codGrupoProdutos) );"+
					" "+
					"CREATE TABLE IF NOT EXISTS produtos ( "+
					"codProduto SERIAL, "+
					"nome CHARACTER VARYING (50), "+
					"codBarras CHARACTER VARYING (50)," +
					"ativo boolean, "+
					"codGrupoProdutos INTEGER REFERENCES grupoProdutos ON DELETE CASCADE, "+
					"CONSTRAINT pk_produtos PRIMARY KEY (codProduto));"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao ( "+
					"codCotacao SERIAL, "+
					"data DATE, "+
					"codUsuario INTEGER REFERENCES usuarios ON DELETE CASCADE, "+
					"valorTotal NUMERIC ," +
					"finalizado BOOLEAN,"+
					"ativo BOOLEAN,"+
					"datafinalizacao DATE,"+
					"CONSTRAINT pk_cotacao PRIMARY KEY (codCotacao) );"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacaoProdutos ( "+
					"codCotacaoProdutos SERIAL, "+
					"codCotacao INTEGER REFERENCES cotacao ON DELETE CASCADE, "+
					"codProduto INTEGER REFERENCES produtos ON DELETE CASCADE, " +
					"codFornecedor INTEGER REFERENCES fornecedores ON DELETE CASCADE);"+
					" "+
					"CREATE TABLE IF NOT EXISTS empresa ("+
					"codEmpresa SERIAL,"+
					"nome CHARACTER VARYING(50),"+
					"cnpj CHARACTER VARYING(20),"+
					"endereco CHARACTER VARYING (100),"+
					"telefone1 CHARACTER VARYING (20),"+
					"telefone2 CHARACTER VARYING (20),"+
					"CONSTRAINT pk_empresa PRIMARY KEY (codEmpresa) ); "+
					" "+
					"INSERT INTO empresa (nome) VALUES('Minha empresa');"+
					"INSERT INTO usuarios (nome,login,senha,administrador,ativo) VALUES ('Administrador', 'admin', '123', true, true);"+
					"INSERT INTO usuarios (nome,login,senha,administrador,ativo) VALUES ('Fornecedor', 'fornecedor', '123', false, true);"+
					"";
					
	
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.execute();
			stmt.close();
			alimentarCidades();
		} catch (SQLException e) {
			System.out.println("Erro ao criar tabelas "+e.getMessage());
			throw new RuntimeException(e);
		}
		
	}
	
	public void alimentarCidades(){
		String sql = "INSERT INTO cidades(nome, uf) VALUES('ABADIANIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('AGUA FRIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('AGUAS CLARAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('AGUAS LINDAS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('ALEXANIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('ALTO PARAIZO DE GOIAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('ALVORADA DO NORTE','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('ANAPOLIS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('APARECIDA DE GOIANIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('ARAPOANGA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('ARARAQUARA','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('ARINOS','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('ARNIQUEIRAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('ASA NORTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('ASA SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('BAHIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('BARREIRAS','BA');"+
				"INSERT INTO cidades(nome, uf) VALUES('BARUERI','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('BELEM','PA');"+
				"INSERT INTO cidades(nome, uf) VALUES('BELO HORIZONTE','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('BRASÍLIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('BRASILINHA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('BRAZLANDIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CABECEIRA GOIAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CALDAS NOVAS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('CANDANGOLANDIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CATALÃO','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('CEILANDIA CENTRO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CEILANDIA NORTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CEILANDIA SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CERQUEIRA CÉSAR','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('CEU AZUL','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('CIDADE NOVA','RJ');"+
				"INSERT INTO cidades(nome, uf) VALUES('CIDADE OCIDENTAL GOIAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CIMOLANDIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('colorado','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CRISTALINA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CRUZEIRO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CRUZEIRO NOVO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CRUZEIRO VELHO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CUIABA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('CURITIBA','PR');"+
				"INSERT INTO cidades(nome, uf) VALUES('DIVINOPOLIS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('ESPIRITO SANTO','ES');"+
				"INSERT INTO cidades(nome, uf) VALUES('ESTRUTURAL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('FLORES','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('FLORIANOPOLIS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('FORMOSA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('FORTALEZA','CE');"+
				"INSERT INTO cidades(nome, uf) VALUES('GAMA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('GAMA OESTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('GANDANGOLANDIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('GIRASSOL','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('GOIANIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('GRANJA DO TORTO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('GUARA I','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('GUARA II','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('IACIARA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('IBATE','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('ITAPUÃ','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('JARDIM BOTANICO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('JARDIM INGA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('JARDIM PAULISTANO','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('JARDIM SÃO LUIZ','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('JÕAO PESSOA','PB');"+
				"INSERT INTO cidades(nome, uf) VALUES('LAGO AZUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('LAGO NORTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('LAGO OESTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('LAGO SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('LUCIO COSTA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('LUZIANIA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('M NORTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('MACAPA','AP');"+
				"INSERT INTO cidades(nome, uf) VALUES('MACEIO','AL');"+
				"INSERT INTO cidades(nome, uf) VALUES('MANAUS','AM');"+
				"INSERT INTO cidades(nome, uf) VALUES('MARABA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('MONTE ALEGRE DE GOIAS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('NATAL','RN');"+
				"INSERT INTO cidades(nome, uf) VALUES('NITEROI','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('NOVA IGUAÇU','RJ');"+
				"INSERT INTO cidades(nome, uf) VALUES('NOVO GAMA','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('NUCLEO BANDEIRANTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('OCIDENTAL','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('OCTOGONAL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('P NORTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('P SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PADEF','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PADRE BERNARDO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PARACATU','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('PARANOA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PARAUAPEBAS','PA');"+
				"INSERT INTO cidades(nome, uf) VALUES('PARK WAY','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PATOS DE MINAS','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('PEDREGAL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PLANALTINA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('PLANALTINA GOIAS','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('PORTO ALEGRE','RS');"+
				"INSERT INTO cidades(nome, uf) VALUES('POSSE','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('RECANTO DAS EMAS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('RECIFE','PE');"+
				"INSERT INTO cidades(nome, uf) VALUES('REGIAO DOS LAGOS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('RIACHO FUNDO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('RIACHO FUNDO II','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('RIBEIRAO PRETO','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('RIO BRANCO','AC');"+
				"INSERT INTO cidades(nome, uf) VALUES('RIO DE JANEIRO','RJ');"+
				"INSERT INTO cidades(nome, uf) VALUES('RORAIMA','RO');"+
				"INSERT INTO cidades(nome, uf) VALUES('SAMAMBAIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SAMAMBAIA SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SANTA MARIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SANTANA','BA');"+
				"INSERT INTO cidades(nome, uf) VALUES('SANTARÉM','PA');"+
				"INSERT INTO cidades(nome, uf) VALUES('SANTO ANTONIO DO DESCOBERTO','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('SAO CARLOS','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('SÃO GONÇALO','RJ');"+
				"INSERT INTO cidades(nome, uf) VALUES('SÃO JOÃO DA ALIANÇA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SÃO LUIS','MA');"+
				"INSERT INTO cidades(nome, uf) VALUES('SÃO PAULO','SP');"+
				"INSERT INTO cidades(nome, uf) VALUES('SÃO RAIMUNDO NONATO','PI');"+
				"INSERT INTO cidades(nome, uf) VALUES('SAO SEBASTIAO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SERRA DO SALITRE','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR COMERCIAL SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR DE CLUBE SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR DE DIVERSOES SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR DE EMBAIXADAS SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR DE MANSOES DOM BOSCO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR DE OFICINA SUL','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR LESTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SETOR O','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SOBRADINHO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('SUDOESTE','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('TAGUATINGA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('TAQUARI','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('TARAUACA','AC');"+
				"INSERT INTO cidades(nome, uf) VALUES('TEREZINA','PI');"+
				"INSERT INTO cidades(nome, uf) VALUES('TOCANTINS','TO');"+
				"INSERT INTO cidades(nome, uf) VALUES('TRES MARIAS MINAS GERAIS','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('UBERLANDIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('UNAÍ','MG');"+
				"INSERT INTO cidades(nome, uf) VALUES('VALPARAISO I','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('VALPARAISO II','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('VALPARAIZO','GO');"+
				"INSERT INTO cidades(nome, uf) VALUES('VARGEM BONITA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('VARJAO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('VICENTE PIRES','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('VILA PLANALTO','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('VILA TELEBRASILIA','DF');"+
				"INSERT INTO cidades(nome, uf) VALUES('VILAS BOAS','GO');";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
