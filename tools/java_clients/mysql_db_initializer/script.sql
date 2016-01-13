drop database if exists amcarbondb;
create database amcarbondb;
GRANT ALL ON amcarbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amdb;
create database amdb;
GRANT ALL ON amdb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amregdb;
create database amregdb;
GRANT ALL ON amregdb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amuserdb;
create database amuserdb;
GRANT ALL ON amuserdb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amjagstore;
create database amjagstore;
GRANT ALL ON amjagstore.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amsocialcache;
create database amsocialcache;
GRANT ALL ON amsocialcache.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amsocialdb;
create database amsocialdb;
GRANT ALL ON amsocialdb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amgw2carbondb;
create database amgw2carbondb;
GRANT ALL ON amgw2carbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists ampubcarbondb;
create database ampubcarbondb;
GRANT ALL ON ampubcarbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amstoecarbondb;
create database amstoecarbondb;
GRANT ALL ON amstoecarbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amgw1carbondb;
create database amgw1carbondb;
GRANT ALL ON amgw1carbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

drop database if exists amidpcarbondb;
create database amidpcarbondb;
GRANT ALL ON amidpcarbondb.* TO amuser@'%' IDENTIFIED BY "wso2root";

