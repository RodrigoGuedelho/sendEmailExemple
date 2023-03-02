# Send Email Exemple



## Sobre

API(Application Programming Interface) que fornece o serviço de envio de emails por meio de uma rota.


## Requisitos de software 

![java version](https://img.shields.io/badge/java-^11-blue) ![maven version](https://img.shields.io/badge/maven-3.0.6-red) 



## Procedimentos de execução



Clone o projeto

```bash
git clone https://github.com/RodrigoGuedelho/sendEmailExemple.git
```



Com o projeto clonado, acesse o diretório e instale todas as dependências necessárias

```bash
cd sendEmailExemplo
mvn clean install 
```

```bash
./mvnw spring-boot:run
```

### Procedimentos de execução com docker



Para gerar o build da aplicação:

```bash
mvn clean install
```



Após o build, para iniciar o contâiner, execute:

```bash
docker-compose build 
```

Para iniciar o contâiner em modo background, execute:

```
docker-compose up -d 
