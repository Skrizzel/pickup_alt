-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into myentity (id, field) values(1, 'field-1');
insert into myentity (id, field) values(2, 'field-2');
insert into myentity (id, field) values(3, 'field-3');
alter sequence myentity_seq restart with 4;
insert into booking (id) values(3);

INSERT INTO address (latitude,longitude,id,city,country,housenumber,postalcode,street) VALUES
	 (50.870300900000004,9.676052825304854,4,'Bad Hersfeld','Deutschland','1','36251','Hof Meisebach'),
	 (52.5579514,13.4133281,5,'Berlin','Deutschland','56','10115','Berliner Straße'),
	 (48.72985004799395,9.112539310895167,6,'Stuttgart','Deutschland','87','70173','Hauptstraße'),
	 (53.66070259999999,10.1348359,7,'Hamburg','Deutschland','12','20095','Lindenweg'),
	 (49.412521999999996,8.710606021002476,8,'Heidelberg','Deutschland','8','69117','Marktplatz'),
	 (48.19142085,11.646570829045759,9,'München','Deutschland','22','80335','Bahnhofstraße'),
	 (50.8860429,7.061339980701851,10,'Köln','Deutschland','45','50667','Friedrichstraße'),
	 (50.11483183533683,8.678555085547087,11,'Frankfurt am Main','Deutschland','78','60313','Schillerstraße'),
	 (51.3580524,12.355945350000002,12,'Leipzig','Deutschland','9','04109','Rosenweg'),
	 (49.4461311,11.0647777,13,'Nürnberg','Deutschland','5','90403','Gartenstraße');
INSERT INTO address (latitude,longitude,id,city,country,housenumber,postalcode,street) VALUES
	 (51.0383605,13.7284169,14,'Dresden','Deutschland','16','01067','Bergstraße'),
	 (53.17115295,8.62590885,15,'Bremen','Deutschland','4','28195','Hafenstraße'),
	 (52.4618716,9.8170253,16,'Isernhagen','Deutschland','63','30159','Kirchweg'),
	 (52.39551965728557,13.057744013135581,18,'Potsdam','Deutschland','21','14467','Schlossstraße'),
	 (46.864469799999995,7.258227358206913,21,'Freiburg','Deutschland','3','79098','Sonnenweg'),
	 (50.0631726,8.2265112,22,'Wiesbaden','Deutschland','30','65183','Birkenstraße');
