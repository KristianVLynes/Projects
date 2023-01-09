
-- tables¨
-- Table: User
CREATE TABLE User (
    Email varchar(20) NOT NULL, 
    Passw varchar(30) NOT NULL, 
    FullName varchar(30),
    StatisticsID int NOT NULL,
    PRIMARY KEY (Email),
    FOREIGN KEY (StatisticsID) REFERENCES CoffeeStatistics(StatisticsID)
);

-- Table: CoffeeStatistics
CREATE TABLE CoffeeStatistics (
    StatisticsID int NOT NULL,
    CoffeesTried int NOT NULL,
    Countries int NOT NULL,
    PRIMARY KEY (StatisticsID)
);

-- Table: CoffeeTasting
CREATE TABLE CoffeeTasting (
    TasteID int NOT NULL,
    Notes varchar(100),
    Points int NOT NULL,
    TasteDate date NOT NULL,
    Email varchar(30) NOT NULL,
    CoffeeRoastery varchar(20) NOT NULL,
    CoffeeName varchar(20) NOT NULL,
    PRIMARY KEY (TasteID),
    FOREIGN KEY (Email) REFERENCES User(Email),
    FOREIGN KEY (CoffeeRoastery) REFERENCES RoastedCoffee(Roastery),
    FOREIGN KEY (CoffeeName) REFERENCES RoastedCoffee(CoffeeName)
);

-- Table: RoastedCoffee
CREATE RoastedCoffee (
    Roastery varchar(20) NOT NULL,
    CoffeeName varchar(20) NOT NULL,
    RoastDegree varchar(6) NOT NULL,
    RoastDate date NOT NULL,
    KiloPrice int NOT NULL,
    CoffeeDescription varchar(200),
    PRIMARY KEY (Roastery),
    PRIMARY KEY (CoffeeName),
    FOREIGN KEY (Roastery) REFERENCES Roastery(RoasteryName),
    CONSTRAINT chk_RoastDegree CHECK (RoastDegree IN ('Dark', 'Medium', 'Light'))

);

-- Table: Roastery
CREATE Roastery (
    RoasteryName varchar(20) NOT NULL,
    City varchar(20) NOT NULL,
    Country varchar(20) NOT NULL, 
    PRIMARY KEY (RoasteryName)
);

-- Table: Batch
CREATE Batch (
    Farm varchar(20) NOT NULL, 
    HarvestYear int NOT NULL,
    KiloPriceUSD int NOT NULL, 
    ProcessingMethod varchar(20) NOT NULL,
    BeanType varchar(20) NOT NULL,
    PRIMARY KEY (Farm),
    PRIMARY KEY (HarvestYear),
    FOREIGN KEY (ProcessingMethod) REFERENCES ProcessingMethod(ProcessingName),
    FOREIGN KEY (Farm) REFERENCES Farm(FarmName),
    FOREIGN KEY (BeanType) REFERENCES BeanType(BeanType)
);

-- Table: Farm
CREATE Farm (
    FarmName varchar(20) NOT NULL,
    Height int NOT NULL, 
    Country varchar(20) NOT NULL,
    Region varchar(20) NOT NULL,
    PRIMARY KEY (FarmName)
);

-- Table: Bean
CREATE Bean (
    BeanType varchar(20) NOT NULL,
    PRIMARY KEY (BeanType)
)

-- Table: ProcessingMethod
CREATE ProcessingMethod (
    ProcessingName varchar(20) NOT NULL, 
    ProcessingDescription varchar(200),
    PRIMARY KEY (ProcessingName)
);

