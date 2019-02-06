# xy-inc
INSTRUÇÕES

Chamada dos serviços via Heroku e Swagger:


Para realizar testes dos serviços sem a necessidade de importar o projeto.

Basta acessar o link abaixo:

https://prova-xy-inc.herokuapp.com/swagger-ui.html 

______________________________________________________________________________________________

Para realizar os testes fora local:

git clone https://github.com/mhenrima/xy-inc.git 


Realizar o import do mesmo no eclipse


Executar comando mvn install


Executar a aplicação


E chamar os serviços: 

LISTAR POI's: http://localhost:8080/poi


LISTAR POI's por proximidade: 
https://prova-xy-inc.herokuapp.com/poi/listaPoiProximo?x=VALOR&y=VALOR&distancia=VALOR 

(No lugar de 'VALOR' colocar os valores de cada variavel).


Cadastrar POI's: http://localhost:8080/poi



Exemplo de JSON:
{
  "name": "string",
  "x": 0,
  "y": 0
}



INFORMAÇÕES:

DATABASE: H2

COVERAGE: 98,5%

					    	 
