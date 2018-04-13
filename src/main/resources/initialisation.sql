-- Create record on an empty base
-- WARNING : ERASE exisiting datas

-- Cleaning ...
Delete from INGREDIENT_GROUP_INGREDIENT;
Delete from INGREDIENT;
Delete from TYPE_INGREDIENT;
Delete from GROUP_INGREDIENT;

-- Inserting ...
INSERT INTO GROUP_INGREDIENT VALUES (1,'Entrée');
INSERT INTO GROUP_INGREDIENT VALUES (2,'Plat - Viande');
INSERT INTO GROUP_INGREDIENT VALUES (3,'Plat - Accompagnement');
INSERT INTO GROUP_INGREDIENT VALUES (4,'Dessert');

INSERT INTO TYPE_INGREDIENT VALUES (1,'Viande');
INSERT INTO TYPE_INGREDIENT VALUES (2,'Légume');
INSERT INTO TYPE_INGREDIENT VALUES (3,'Féculent');
INSERT INTO TYPE_INGREDIENT VALUES (4,'Produit laitier');
INSERT INTO TYPE_INGREDIENT VALUES (5,'Poisson');
INSERT INTO TYPE_INGREDIENT VALUES (6,'Fruit');

INSERT INTO INGREDIENT VALUES (1,'Tournedos de boeuf charolais',1);
INSERT INTO INGREDIENT VALUES (2,'Aiguillettes de canard',1);
INSERT INTO INGREDIENT VALUES (3,'Jambon blanc',1);
INSERT INTO INGREDIENT VALUES (4,'Brocolis',2);
INSERT INTO INGREDIENT VALUES (5,'Haricots verts',2);
INSERT INTO INGREDIENT VALUES (6,'Courgettes',2);
INSERT INTO INGREDIENT VALUES (7,'Purée de pommes de terre',3);
INSERT INTO INGREDIENT VALUES (8,'Riz basmati',3);
INSERT INTO INGREDIENT VALUES (9,'Coquillettes',3);
INSERT INTO INGREDIENT VALUES (10,'Yaourt nature sucré',4);
INSERT INTO INGREDIENT VALUES (11,'Fromage blanc 0%',4);
INSERT INTO INGREDIENT VALUES (12,'Riz au lait',4);
INSERT INTO INGREDIENT VALUES (13,'Pavé de bar sauvage',5);
INSERT INTO INGREDIENT VALUES (14,'Thon',5);
INSERT INTO INGREDIENT VALUES (15,'Poisson pané',5);
INSERT INTO INGREDIENT VALUES (16,'Carottes',2);
INSERT INTO INGREDIENT VALUES (17,'Concombre',2);
INSERT INTO INGREDIENT VALUES (18,'Cerises',6);
INSERT INTO INGREDIENT VALUES (19,'Bananes',6);
INSERT INTO INGREDIENT VALUES (20,'Fraises',6);
INSERT INTO INGREDIENT VALUES (21,'Pomme',6);
INSERT INTO INGREDIENT VALUES (22,'Poire',6);

INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (16,1);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (16,3);

INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (17,1);

INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (1,2);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (2,2);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (3,2);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (13,2);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (14,2);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (15,2);

INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (4,3);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (5,3);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (6,3);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (7,3);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (8,3);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (9,3);

INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (10,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (11,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (12,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (18,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (19,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (20,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (21,4);
INSERT INTO INGREDIENT_GROUP_INGREDIENT VALUES (22,4);

