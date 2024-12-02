# ProjetoMuralisSpringBoot
# Introdução
Eu chamei este projeto de "ProjetoMuralisSpringBoot", por ser um desafio de desenvolvimento de uma API Restful com SpringBoot pela empresa Muralis Tecnologia. Ele basicamente vai permitir o cadastramento de clientes, além de sua consulta, listagem, pesquisa, alteração e exclusão do mesmo.
# Descrição
Inicialmente, este projeto foi requerido dia 26 de novembro como um dos desafios técnicos, uma etapa fundamental para o processo seletivo como estagiária na Muralis Tecnologia. E, sendo necessário o cumprimento da utilização de três itens:
- Ser uma API Restful
- Usar DTO
- Usar Mapper

Assim sendo, preciso implementar as funcionalidades previstas na introdução seguindo a seguinte modelagem:

![image](https://github.com/user-attachments/assets/671fb64b-bf78-4954-ba4b-bfc66161d419)

# Especificações 

Antes de darmos prosseguimento, irei falar sobre algumas das principais especificações do projeto, que define as versões e dependências essenciais para o funcionamento correto da aplicação.
Framework Principal: Spring Boot 3.4.0
Linguagem: Java 21
Gerenciador de Dependências: Maven
Banco de Dados: MySQL (conector mysql-connector-j)
Dependências:
- spring-boot-starter-web para criação de APIs RESTful.
- spring-boot-starter-data-jpa gerencia a comunicação com o banco de dados.
- spring-boot-devtools para agilizar o desenvolvimento do código.
- lombok para reduzir o código boilerplate.
- spring-boot-starter-test para testes automatizados.

# Pré-requisitos

1. Instalação do Maven
   
   Linux (Ubuntu/Debian):
   - sudo apt update
   - sudo apt install maven
   - mvn -version

   Windows:
   - Baixe o Maven no site oficial: [Apache Maven.](https://maven.apache.org/download.cgi).
   - Extraia o conteúdo e adicione o caminho da pasta bin às variáveis de ambiente
   - Verifique a instalação pelo terminal: mvn -version

2. Instalação MySQL

   Linux (Ubuntu/Debian):
   - sudo apt update
   - sudo apt install mysql-server
   - sudo service mysql start
   - mysql -u root -p


   Windows:
   - Baixe o instalador do MySQL: [MySQL Downloads.](https://dev.mysql.com/downloads/installer/)
   - Execute o instalador e siga as instruções para instalar o MySQL Server.
   - Inicie o serviço: net start mysql

# Testes no Insomnia 

Para demontrar o funcionamento da API realizei testes no Insomnia, para ve-los com maior detalhamento clique no link abaixo, assim você será redirecionado para o documento em questão

👉 [Documento de teste](https://github.com/rafaseara/ProjetoMuralisSpringBoot/edit/main/doc/insomnia-tests.md)

# Aprendizado

Realizar este projeto me trouxe diversos novos aprendizados, entre os principais gostaria de comentar sobre o conceito da aplicação de uma arquitetura Restful, que não sabia a diferença clara na hora de implementar entre esta arquitetura e apenas um API Rest. Além do mais, pesquisei mais sobre alguma boas práticas e pude criar uma classe especificamente para tratar de exceções. E, a partir de um curso que realizei para saber melhor os conceitos e a prática desta API, pude aprender sobre a classe record, que acabou sendo muito útil e mais simples, uma funcionalidade que não havia antes visto. Apesar de, neste caminho para a conclusão do meu projeto ter encontrado algumas dificuldades, como garantir que cada camada (padrão CSR) tivesse uma responsabilidade específica, e a boa implementação do Mapper, tornando o código mais fácil de gerenciar, testar e dimensionar. Gostaria ja de aproveitar para agradecer [Muralis Tecnologia](https://www.muralis.com.br/) que me deu esta oportunidade de demonstrar meus conhecimentos técnicos, a plataforma [Alura](https://www.alura.com.br/) que me disponibilizou conteúdo de qualidade para que eu pudesse entender melhor como desenvolver uma API Restful em Java, ao meu colega [Leonardo](https://github.com/Pokernol) que me auxilio com algumas das minhas dúvidas e por último ao [Ruan](https://github.com/ruann-fernandess) que foi um ótimo companheiro durante todo este percurso.

# Melhorias

Neste tópico de melhorias, eu gostaria de descrever possíveis acertos que poderiam ser feitos e funcionalidades extras que poderiam ser implementadas para um melhor aproveitamento deste projeto.  Ainda mais, levando em conta a minha proeficiência básica nesta linguagem, podem existir mudanças que melhorarão o desempenho geral do projeto, como:
- Melhorar a implementação do Mapper
- Implementar uma página HTML para uma interação com o usuário.
- Realizar a dockerização para facilitar a distribuição e o deploy da aplicação em qualquer ambiente.
- Colocar mais mensagens de confirmação a cada alteração

# Feedback
Se houver algum feedback sobre meu projeto, por favor compartilhe comigo, deixo abaixo meu e-mail para que me deixe sabendo

<a href = "mailto:contatorafaseara257@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
