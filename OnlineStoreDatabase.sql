use wileyDI001;

CREATE TABLE Product (
	PRODUCT_ID int AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_NAME varchar(30) NOT NULL,
    COST_PER_UNIT double NOT NULL,
    STOCK int NOT NULL
);

CREATE TABLE Buyer (
	BUYER_ID int AUTO_INCREMENT PRIMARY KEY,
    BUYER_NAME varchar(30) NOT NULL,
    BUYER_PASSWORD varchar(30) NOT NULL,
    BUYER_BALANCE double NOT NULL
);

INSERT INTO Product
VALUE(1, "Monitor", 450.75, 900),
(2, "Mouse", 25.50, 850),
(3, "Keyboard", 220.10, 800),
(4, "Chair", 350.55, 55);

INSERT INTO Buyer
VALUES(121, "Lorraine", "rainey", 7500.55),
(122, "Penelope", "loop", 5000),
(123, "Mona", "moon", 10760.45),
(124, "Nuu", "uuna", 2256.70),
(125, "Leigh", "lee", 44545.90);

SELECT PRODUCT_ID AS ID, PRODUCT_NAME "Product Name", COST_PER_UNIT AS Cost, STOCK AS Stock FROM Product;

SELECT BUYER_ID AS ID, BUYER_NAME AS Name, BUYER_PASSWORD AS Password, BUYER_BALANCE "Current Balance" FROM Buyer;
