# Usando uma imagem base do Java 11
FROM adoptopenjdk:11-jre-hotspot

# Definindo o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando o arquivo JAR da aplicação para o contêiner
COPY ./build/libs/lisbeer-0.1.jar app.jar

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
