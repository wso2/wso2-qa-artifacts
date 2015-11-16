#Overview#

DB Initializer is java client that can be used to run .sql scripts agaist MYSQL DB. This can be used when automating deployments etc.

**Project Structure**
```
mysql_db_initializer
    ├── build.xml
    ├── lib
    │   └── mysql-connector-java-5.1.31-bin.jar
    ├── README
    ├── README~
    ├── script.sql
    └── src
        ├── clusterDB.java
        └── ScriptRunner.java
```

#How to Run#

1. Copy MYSQL driver to lib directory in the root of the project, If the directory doesn't exist create it.
2. Add the necessary sql queries you need to run in the script.sql file in the root of the project.
3. Now open "src/clusterDB.java" and add database URL and necessary credentials (Username & Password)
4. Now navigate to the root directory and execute the command "ant" (Make sure you have appache ant installed)


