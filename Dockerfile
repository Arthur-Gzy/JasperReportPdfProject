FROM openjdk:11 as build
WORKDIR /app
RUN mkdir -p /app/jrxml
RUN mkdir -p /app/pdfreports
ADD build/libs/JasperReportPdfProject-0.0.1-SNAPSHOT.jar /app/app.jar
ADD src/main/resources/reports/JasperDesign.jrxml /app/jrxml/JasperDesign.jrxml
ENTRYPOINT ["java","-jar","app.jar"]