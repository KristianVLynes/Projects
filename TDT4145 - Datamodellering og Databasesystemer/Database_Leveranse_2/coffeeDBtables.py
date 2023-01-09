import sqlite3 

#pyhton script that creates .db file with all tables, we run this at the start of task 2 c)

con = sqlite3.connect('coffee.db')
cursor = con.cursor()

cursor.execute('''
CREATE TABLE User (
    Email varchar(20) NOT NULL, 
    Passw varchar(30) NOT NULL, 
    FullName varchar(30),
    PRIMARY KEY (Email)
);''')

cursor.execute('''
CREATE TABLE CoffeeTasting (
    TasteID int NOT NULL,
    Notes varchar(100),
    Points int,
    TasteDate date,
    Email varchar(30),
    CoffeeID int,
    PRIMARY KEY (TasteID),
    FOREIGN KEY (Email) REFERENCES User(Email),
    FOREIGN KEY (CoffeeID) REFERENCES RoastedCoffee(CoffeeID)
);''')

cursor.execute('''
CREATE TABLE RoastedCoffee (
    CoffeeID int,
    CoffeeName varchar(20),
    RoastDegree varchar(7),
    RoastDate date,
    KiloPrice int,
    CoffeeDescription varchar(200),
    RoasteryName varchar(20) NOT NULL,
    BatchID int NOT NULL,
    PRIMARY KEY (CoffeeID),
    FOREIGN KEY (RoasteryName) REFERENCES Roastery(RoasteryName),
    FOREIGN KEY (BatchID) REFERENCES Batch(BatchID)
    CONSTRAINT chk_RoastDegree CHECK (RoastDegree IN ('dark', 'medium', 'light', NULL))
);''')

cursor.execute('''
CREATE TABLE Roastery (
    RoasteryName varchar(20) NOT NULL,
    City varchar(20) NOT NULL,
    Country varchar(20), 
    PRIMARY KEY (RoasteryName)
);''')

cursor.execute('''
CREATE TABLE Batch (
    BatchID NOT NULL,
    Farm varchar(20) NOT NULL, 
    HarvestYear int NOT NULL,
    KiloPriceUSD int NOT NULL, 
    ProcessingMethod varchar(20) NOT NULL,
    BeanType varchar(20) NOT NULL,
    PRIMARY KEY (BatchID),
    FOREIGN KEY (ProcessingMethod) REFERENCES ProcessingMethod(ProcessingName),
    FOREIGN KEY (Farm) REFERENCES Farm(FarmName),
    FOREIGN KEY (BeanType) REFERENCES BeanType(BeanType)
);''')

cursor.execute('''
CREATE TABLE Farm (
    FarmName varchar(20) NOT NULL,
    Height int NOT NULL, 
    Country varchar(20) NOT NULL,
    Region varchar(20) NOT NULL,
    PRIMARY KEY (FarmName)
);''')

cursor.execute('''
CREATE TABLE Bean (
    BeanType varchar(20) NOT NULL,
    PRIMARY KEY (BeanType)
);''')

cursor.execute('''
CREATE TABLE ProcessingMethod (
    ProcessingName varchar(20) NOT NULL, 
    ProcessingDescription varchar(200),
    PRIMARY KEY (ProcessingName)
);''')

con.commit()

con.close()