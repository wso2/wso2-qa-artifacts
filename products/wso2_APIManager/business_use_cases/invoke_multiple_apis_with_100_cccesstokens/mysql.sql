drop database am160carbon;
create database am160carbon;
GRANT ALL ON am160carbon.* TO am160carbon@'%' IDENTIFIED BY "am160carbon";
GRANT ALL ON am160carbon.* TO am160carbon@'localhost' IDENTIFIED BY "am160carbon";

drop database am160db;
create database am160db;
GRANT ALL ON am160db.* TO am160db@'%' IDENTIFIED BY "am160db";
GRANT ALL ON am160db.* TO am160db@'localhost' IDENTIFIED BY "am160db";

