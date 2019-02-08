# xy-inc
INSTRUÇÕES

Chamada dos serviços via Heroku e Swagger:


Para realizar testes dos serviços sem a necessidade de importar o projeto.

Basta acessar o link abaixo:

https://prova-xy-inc.herokuapp.com/swagger-ui.html 

______________________________________________________________________________________________

Para realizar executar local:

git clone https://github.com/mhenrima/xy-inc.git 


realizar build maven: mvn clean install


start da aplicação, utilizar Java 8: java -jar aplicacao.jar


E chamar os serviços: 

LISTAR POI's: http://localhost:8080/poi


LISTAR POI's por proximidade: 
http://localhost:8080/poi/listaPoiProximo?x=VALOR&y=VALOR&distancia=VALOR

(No lugar de 'VALOR' colocar os valores de cada variavel).


Cadastrar POI's: http://localhost:8080/poi



Exemplo de JSON:

{

  "name": "string",
  
  "x": 0,
  
  "y": 0
  
}



Para execução dos testes:

Após imports realizados, executar as classes de teste via JUnit ou executar comando mvn test.
_______________________________________________________________________________________________

INFORMAÇÕES:

DATABASE: H2

COVERAGE: 98,5%

					    	 
