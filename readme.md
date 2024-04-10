### Auth Api

API para autenticação de serviços, pode ser utilizada como um microserviço de autenticação.
Função primaria seria utilizar para autenticar demais serviços, sejam outros microserviços ou aplicações.

Funcionamento é bem simples, utiliza Tokens `JWT` para login e armazena os usuários e recursos no banco de dados Postgres. 
Cada recurso seria um serviço que o usuário tem acesso, para fazer o vinculo entre usuário e recurso é necessário
Utilizar a rota de vinculo `user-resource` assim o usuário ao fazer o login informa o recurso que quer acessar e se o vinculo
existir o token é gerado.

As rotas criadas e utilizadas estão em uma `collection` do Postman para ser baixada junto ao repo.

## Contribuições

Este projeto fiz com o intuido de ser usado por minhas próprias aplicações online, mas como pode ser utilizado por N projetos
que possuem autenticação, sendo necessário apenas mudar as variáveis de ambiente. 
Acredito que pode ser um bom projeto para `open-source` pois pode ser baixado e costumizado ou adicionar novas features com tempo.
Projeto esta aberto para melhorias e novas features por meio de PR.
>O PR pode ser simples, só definir a intenção da nova feature e o motivação para tal que vou avaliar. :)
>O PR tem um modelinho a ser seguido pode só preencher sem dor de cabeça.

## To run
Alterar as variaveis de ambiente que estão no arquivo `application.properties.exemplo` e mudar o nome para `application.properties`.

É necessário também um Postgres com essas informações { user: 'postgres', password: 'mysecretpassword', database: 'auth-db', host: 'localhost', }

Fiz utilizando o docker depois de baixar o postgres do docker hub.

Comando para startar postgres container: 'sudo docker run --network=host -e POSTGRES_PASSWORD=mysecretpassword -d postgres'.

##To stop
sudo kill -9 $(lsof -t -i:8080)