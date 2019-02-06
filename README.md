# xy-inc
INSTRUÇÕES

É possivel realizar os testes dos serviços através do HEROKU, não sendo preciso baixar o projeto para a maquina local.
Também foi utilizado o Swagger para não precisar de nenhum outro programa para realizar requisiçõs.
Basta acessar o link abaixo:

https://prova-xy-inc.herokuapp.com/swagger-ui.html 


Para realizar testes fora do HEROKU, deve-se baixar o repositorio para o computador local: git clone https://github.com/mhenrima/xy-inc.git 


Realizar o import do mesmo no eclipse


Executar mvn install


Rodar a aplicação


E chamar os serviços: 

LISTAR POI's: http://localhost:8080/poi
LISTAR POI's por proximidade: https://prova-xy-inc.herokuapp.com/poi/listaPoiProximo?x=VALOR&y=VALOR&distancia=VALOR 

(No lugar de 'VALOR' colocar os valores de cada variavel).


Cadastrar POI's: http://localhost:8080/poi



Exemplo de JSON:
{
  "name": "string",
  "x": 0,
  "y": 0
}

