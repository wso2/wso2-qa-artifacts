drop database regfiveREG1;
create database regfiveREG;
GRANT ALL ON regfiveREG1.* TO regfiveREG1@'%' IDENTIFIED BY "regfiveREG1";
GRANT ALL ON regfiveREG1.* TO regfiveREG1@'localhost' IDENTIFIED BY "regfiveREG1";

drop database regfiveUM;
create database regfiveUM;
GRANT ALL ON regfiveUM.* TO regfiveUM@'%' IDENTIFIED BY "regfiveUM";
GRANT ALL ON regfiveUM.* TO regfiveUM@'localhost' IDENTIFIED BY "regfiveUM";