drop database regfiveREG;
create database regfiveREG;
GRANT ALL ON regfiveREG.* TO regfiveREG@'%' IDENTIFIED BY "regfiveREG";
GRANT ALL ON regfiveREG.* TO regfiveREG@'localhost' IDENTIFIED BY "regfiveREG";

drop database regfiveUM;
create database regfiveUM;
GRANT ALL ON regfiveUM.* TO regfiveUM@'%' IDENTIFIED BY "regfiveUM";
GRANT ALL ON regfiveUM.* TO regfiveUM@'localhost' IDENTIFIED BY "regfiveUM";