DROP TABLE IF EXISTS custvehicle;
  
CREATE TABLE custvehicle ( 
vin VARCHAR(250) NOT NULL,
regnr VARCHAR(250) NOT NULL,
vname VARCHAR(250) NOT NULL,
custname VARCHAR(250),
custaddr VARCHAR(250),
vstatus VARCHAR(250)
);