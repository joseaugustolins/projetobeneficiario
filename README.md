# projetobeneficiario

## Microserviço destinado ao gerenciamento dos beneficiários. Ele mantém as informações em um banco de dados postgreSQL e estuta uma fila no RabbitMQ que recebe informações do serviço de aporte do valor.
- Para rodar o projeto é necessário o projeto é necessário o Docker e o Docker Compose instalados, bem como a JDK versão 11 do java;
- Para iniciar o banco de dados PostgreSQL e o Rabbitmq. Rodar o comando 

		`docker-compose up -d` 

- Com os serviços acima levantado, iniciar a api.
- Após a api levantada, a documentação encontra-se em: 
http://localhost:8080/swagger-ui.html

## Endpoints
* findAll -> GET em    http://localhost:8080/beneficiario
* findById -> GET em   http://localhost:8080/beneficiario/{id}
* save -> POST em 		http://localhost:8080/beneficiario
	body json:
	
    	`{
		    "cpf": 31231,
		    ”email": "joasdifjs@123.com",
		    "valor": 15,
		    "anos": 1
        }`
* update -> PUT em http://localhost:8080/beneficiario
	json body:


		`{
		    "cpf": 31231,
		    ”email": "joasdifjs@123.com",
		    "valor": 15,
		    "anos": 1
        }`
