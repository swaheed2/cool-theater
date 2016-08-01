# Cool Theater

A sample modern web application built with JSF and JPA and deployed on Heroku.

To run locally:

You can't. This application uses a Postgres database from heroku. For security purposes, persistence.xml is hidden and not included in the code.

Here is what persistence.xml looks like if you want to use your own credentials:

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
    <persistence-unit name="theaterPU" transaction-type="RESOURCE_LOCAL">
        <!--    <non-jta-data-source>theaterPUS</non-jta-data-source>-->

        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://ec2-23-21-55-25.compute-1.amazonaws.com:5432/dfts3qj1jiad91?requireSSL=true;useSSL=true;sslfactory=org.postgresql.ssl.NonValidatingFactory"/>
            <property name="javax.persistence.jdbc.user" value="xxxx"/>
            <property name="javax.persistence.jdbc.password" value="xxxx"/> 
        </properties>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
        <properties>
            <property name="javax.persistence.schema-generation.database.action" value="create"/>
        </properties>
    </persistence-unit>
</persistence> 

```
