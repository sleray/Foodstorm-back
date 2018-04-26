-- Create record on an empty base
-- WARNING : ERASE exisiting datas

-- Cleaning ...
Delete from INGREDIENT_GROUP_INGREDIENT;
Delete from INGREDIENT;
Delete from TYPE_INGREDIENT;
Delete from GROUP_INGREDIENT;
Delete from MEMBER_ROLE;
Delete from MEMBER;
Delete from ROLE;
Delete from FAMILY;

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

INSERT INTO INGREDIENT VALUES (1,'Steak de boeuf charolais',1,'https://openclipart.org/detail/8637/steak');
INSERT INTO INGREDIENT VALUES (2,'Poulet',1, 'https://openclipart.org/detail/21738/chiken');
INSERT INTO INGREDIENT VALUES (3,'Jambon blanc',1, 'https://openclipart.org/detail/8649/ham-2');
INSERT INTO INGREDIENT VALUES (4,'Brocolis',2, 'https://openclipart.org/detail/247825/broccoli');
INSERT INTO INGREDIENT VALUES (5,'Poivrons',2, 'https://openclipart.org/detail/21365/vegetables-set');
INSERT INTO INGREDIENT VALUES (6,'Courgettes',2, 'https://openclipart.org/detail/276879/courgette');
INSERT INTO INGREDIENT VALUES (7,'Pommes de terre',3, 'https://openclipart.org/detail/291193/potato');
INSERT INTO INGREDIENT VALUES (8,'Riz basmati',3, 'https://openclipart.org/detail/176181/white-rice');
INSERT INTO INGREDIENT VALUES (9,'Spaghetti',3, '"https://openclipart.org/detail/176179/uncooked-noodles');
INSERT INTO INGREDIENT VALUES (10,'Yaourt nature sucré',4, 'https://openclipart.org/detail/216963/some-tweakes-to-get-the-traditional-can-look');
INSERT INTO INGREDIENT VALUES (11,'Fromage blanc 0%',4, 'https://openclipart.org/detail/216963/some-tweakes-to-get-the-traditional-can-look');
INSERT INTO INGREDIENT VALUES (12,'Riz au lait',4, 'Image Not Found');
INSERT INTO INGREDIENT VALUES (13,'Pavé de bar sauvage',5, 'https://openclipart.org/detail/518/fish');
INSERT INTO INGREDIENT VALUES (14,'Thon',5, 'https://openclipart.org/detail/252399/stylized-fish-silhouette-rotated');
INSERT INTO INGREDIENT VALUES (15,'Poisson pané',5, 'Image Not Found');
INSERT INTO INGREDIENT VALUES (16,'Carottes',2, 'https://openclipart.org/detail/209536/food-carrot');
INSERT INTO INGREDIENT VALUES (17,'Concombre',2, 'https://openclipart.org/detail/267379/cucumber');
INSERT INTO INGREDIENT VALUES (18,'Cerises',6, 'https://openclipart.org/detail/14695/fruit-cherries');
INSERT INTO INGREDIENT VALUES (19,'Bananes',6, 'https://openclipart.org/detail/244966/banana---coloured');
INSERT INTO INGREDIENT VALUES (20,'Fraises',6, 'https://openclipart.org/detail/23540/strawberry');
INSERT INTO INGREDIENT VALUES (21,'Pomme',6 , 'https://openclipart.org/detail/24006/another-apple');
INSERT INTO INGREDIENT VALUES (22,'Poire',6, 'https://openclipart.org/detail/169007/pear');
INSERT INTO INGREDIENT VALUES (23,'Sushi de Saumon rose de Norvège',5, 'https://openclipart.org/detail/284173/salmon-sushi-nigiri');

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

INSERT INTO ROLE VALUES (1,'MEMBER');
INSERT INTO ROLE VALUES (2,'CHIEF_FAMILY');
INSERT INTO ROLE VALUES (3,'ADMINISTRATOR');
