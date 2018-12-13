--------------Catalogue--------------------
INSERT INTO catalogue (id_offre, offre) VALUES (1,'OKAYO');
INSERT INTO catalogue (id_offre, offre) VALUES (2,'BIENVENUE');

--------------prestation--------------------
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (1,'Description0','50',1);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (2,'Description1','100',1);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (3,'Description2','150',1);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (4,'Description3','200',1);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (5,'Prestation0','150',2);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (6,'Prestation1','100',2);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (7,'Prestation2','50',2);
INSERT INTO prestation (id_prestation, intitule, prix, id_offre) VALUES (8,'Prestation3','200',2);

--------------TVA--------------------
INSERT INTO tva (id_tva, date_debut, date_fin, taux_tva) VALUES (1,CURDATE(), CURDATE(),19.6);
INSERT INTO tva (id_tva, date_debut, date_fin, taux_tva) VALUES (2,CURDATE(), CURDATE(),20.6);
--------------Client--------------------
INSERT INTO client (id_client, adresse,code_client,raison_sociale,telephone) VALUES (1, '1 rue SansFin, Paris','CU17.1-0001', '2MA', '01.02.08.09');
INSERT INTO client (id_client, adresse,code_client,raison_sociale,telephone) VALUES (2, '25 avenue de la marne, Paris','CU17.1-0011', 'W2S', '02.02.18.39');

--------------Facture--------------------
INSERT INTO facture(id_facture, date_echeance, date_facturation, id_client) VALUES (1 ,CURDATE(), CURDATE(), 1);
INSERT INTO facture(id_facture, date_echeance, date_facturation, id_client) VALUES (2 ,CURDATE(),  CURDATE(), 2);

--------------lignefacture--------------------
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (1,1,0,1);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (2,1,0,1);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (3,1,0,1);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (4,1,0,1);

INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (5,1,0,2);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (6,1,0,2);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (7,1,0,2);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (8,-1,0,2);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (9,1,0,2);
INSERT INTO ligne_facture (id_lig_facture, quantite, reduction, id_facture)  VALUES (10,1,0,1);
--------------ligne facture catalogue-------------------
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(1,1);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(2,1);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(3,1);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(4,1);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(5,2);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(6,2);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(7,2);
INSERT INTO ligne_facture_catalogue(id_lig_facture, id_offre)VALUES(8,2);
--------------ligfactprestation--------------------
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (1,1,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (2,2,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (3,3,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (4,4,CURDATE());

INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (5,5,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (6,6,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (7,7,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation)  VALUES (8,8,CURDATE());

INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation) VALUES (8,9,CURDATE());
INSERT INTO ligne_facture_prestation (id_prestation, id_lig_facture, date_facturation) VALUES (6,10,CURDATE());


--------------TvaPrestation--------------------
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (1,1,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (2,1,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (3,1,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (4,1,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (5,2,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (6,2,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (7,2,CURDATE());
INSERT INTO tva_Prestation (id_prestation, id_tva, date_facturation) VALUES (8,2,CURDATE());
















