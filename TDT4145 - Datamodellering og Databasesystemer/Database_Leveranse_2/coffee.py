import sqlite3

con = sqlite3.connect('coffee.db')
cursor = con.cursor()

def insert_user():
    email = input("Email: ")
    password = input("Password: ")
    full_name = input("Full name: ")

    parameter = (email, password, full_name)

    cursor.execute("INSERT INTO User VALUES (?, ?, ?)", parameter)

def insert_coffee_tasting():
    taste_id = 1
    for rows in cursor.execute("SELECT * FROM CoffeeTasting"):
        taste_id += 1
    
    notes = input('Notes: ')
    points = input('Points: ')
    date = input('Taste date (YYYY-MM-DD): ')
    email = input('Email of user that tasted: ')
    coffee_id = input('Coffee ID: ')

    parameter = (taste_id, notes, points, date, email, coffee_id)

    cursor.execute("INSERT INTO CoffeeTasting VALUES (?, ?, ?, ?, ?, ?)", parameter)



def insert_roasted_coffee():
    coffee_id = 1
    for rows in cursor.execute("SELECT * FROM RoastedCoffee"):
        coffee_id += 1
    
    coffee_name = input('Coffee name: ')
    roast_degree = input('Roast degree (light, medium, dark): ')
    roast_date = input('Date roasted (YYYY-MM-DD): ')
    kilo_price = input('Price per kilo: ')
    coffee_description = input('Description of coffee: ')
    roastery = input('Roastery name: ')
    batch_id = input('Batch ID: ')

    parameter = (coffee_id, coffee_name, roast_degree, roast_date, kilo_price, coffee_description, roastery, batch_id)

    cursor.execute("INSERT INTO RoastedCoffee VALUES (?, ?, ?, ?, ?, ?, ?, ?)", parameter)

def insert_roastery():
    roastery = input('Roastery name: ')
    city = input('City: ')
    country = input('Country: ')

    parameter = (roastery, city, country)

    cursor.execute("INSERT INTO Roastery VALUES (?, ?, ?)", parameter)

def insert_batch():
    batch_id = 1
    for rows in cursor.execute("SELECT * FROM Batch"):
        batch_id += 1
    
    farm = input('Farm: ')
    harvest_year = input('Harvest year: ')
    kilo_price_usd = input('Price per kilo (USD): ')
    processing_method = input('Processing method: ')
    bean = input('Bean type: ')

    parameter = (batch_id, farm, harvest_year, kilo_price_usd, processing_method, bean)

    cursor.execute("INSERT INTO Batch VALUES (?, ?, ?, ?, ?, ?)", parameter)



def insert_farm():
    farm = input('Farm name: ')
    height = input('Altitude: ')
    country = input('Country: ')
    region = input('Region: ')

    parameter = (farm, height, country, region)

    cursor.execute("INSERT INTO Farm VALUES (?, ?, ?, ?)", parameter)


def insert_bean():
    bean = input('Bean type: ')

    parameter = (bean)

    cursor.execute("INSERT INTO Bean VALUES (?)", parameter)

def insert_processing_method():
    name = input('Processing name: ')
    description = input('Description: ')

    parameter = (name, description)

    cursor.execute("INSERT INTO ProcessingMethod VALUES (?, ?)", parameter)

print('Welcome to the coffee database!')

add_or_no = input('Do you want to add an entity to the database? (Y/N) ')

while add_or_no != 'N' and add_or_no == 'Y':
    table = input('Which table do you want to add to? (User, CoffeeTasting, RoastedCoffee, Roastery, Batch, Farm, Bean, ProcessingMethod) ')

    if table == 'User':
        insert_user()
    elif table == 'CoffeeTasting':
        insert_coffee_tasting()
    elif table == 'RoastedCoffee':
        insert_roasted_coffee()
    elif table == 'Roastery':
        insert_roastery()
    elif table == 'Batch':
        insert_batch()
    elif table == 'Farm':
        insert_farm()
    elif table == 'Bean':
        insert_bean()
    elif table == 'ProcessingMethod':
        insert_processing_method()
    
    add_or_no = input('Do you want to add more entities to the database? (Y/N)')
    con.commit()
    
    
user_story = input('What user story do you want to fulfill? (1-5, "q" to quit program) ')

while user_story != 'q':
    if user_story == "1":
        coffee_name = input('Name of roasted coffee tasted: ')
        roastery_name = input('Name of roastery that roasted the coffee: ')
        roast_date = input('Date roasted (YYYY-MM-DD): ')
        notes = input('Comments on the tasting: ')
        points = input('Amount of points given: ')

        taste_id = 1
        for rows in cursor.execute("SELECT * FROM CoffeeTasting"):
            taste_id += 1
        
        coffee_id = 1
        for rows in cursor.execute("SELECT * FROM RoastedCoffee"):
            coffee_id += 1

        batch_id = 1
        for rows in cursor.execute("SELECT * FROM Batch"):
            batch_id += 1
        
        parameter = (taste_id, notes, points, coffee_id)

        cursor.execute("INSERT INTO CoffeeTasting VALUES (?, ?, ?, NULL, NULL, ?)", parameter)

        parameter = (coffee_id, coffee_name, roast_date, roastery_name, batch_id)

        cursor.execute('''INSERT INTO RoastedCoffee VALUES (?, ?, 'light', ?, 600, 'A tasty and complex coffee for polar nights', ?, ?)''', parameter)

        cursor.execute('''INSERT INTO Farm VALUES ('Nombre de Dios', 1500, 'El Salvador', 'Santa Ana')''')

        parameter = (roastery_name)

        cursor.execute('''INSERT INTO Roastery VALUES (?, 'Trondheim', 'Norway')''', (parameter,))

        parameter = (batch_id)

        cursor.execute('''INSERT INTO Batch VALUES (?, 'Nombre de Dios', 2021, 8, 'natural', 'arabica')''', (parameter,))

        con.commit()
    
    elif user_story == "2":
        cursor.execute("SELECT FullName, COUNT(DISTINCT CoffeeID) AS TasteCount \
        FROM User NATURAL JOIN CoffeeTasting \
        WHERE TasteDate LIKE '2022%' \
        GROUP BY FullName \
        ORDER BY TasteCount DESC")
        # fetch all the matching rows 
        result = cursor.fetchall()
        
        # loop through the rows
        for row in result:
            print(row)
            print("\n")

    elif user_story == "3":
        cursor.execute("SELECT Roastery.RoasteryName, RoastedCoffee.CoffeeName, RoastedCoffee.KiloPrice, AVG(CoffeeTasting.Points) AS AVGPoints \
        FROM (Roastery JOIN RoastedCoffee ON (Roastery.RoasteryName = RoastedCoffee.RoasteryName) \
        JOIN CoffeeTasting ON (CoffeeTasting.CoffeeID = RoastedCoffee.CoffeeID)) \
        ORDER BY AVGPoints \
        ")

        # fetch all the matching rows 
        result = cursor.fetchall()
        
        # loop through the rows
        for row in result:
            print(row)
            print("\n")

    elif user_story == "4":
        cursor.execute("SELECT Roastery.RoasteryName, RoastedCoffee.CoffeeName \
        FROM (Roastery JOIN RoastedCoffee ON (RoastedCoffee.RoasteryName = Roastery.RoasteryName)) JOIN CoffeeTasting ON (RoastedCoffee.CoffeeID = CoffeeTasting.CoffeeID) \
        WHERE Notes LIKE '%floral%' OR CoffeeDescription = '%floral%'")

        # fetch all the matching rows 
        result = cursor.fetchall()
        
        # loop through the rows
        for row in result:
            print(row)
            print("\n")

    elif user_story == "5":
        cursor.execute("SELECT Roastery.RoasteryName, RoastedCoffee.CoffeeName \
        FROM Farm JOIN Batch ON (Farm.FarmName = Batch.Farm) \
        JOIN RoastedCoffee ON (RoastedCoffee.BatchID = Batch.BatchID) \
        JOIN Roastery ON (Roastery.RoasteryName = RoastedCoffee.RoasteryName) \
        WHERE Batch.ProcessingMethod <> 'washed' AND Farm.Country = 'Rwanda' OR Batch.ProcessingMethod <> 'washed' AND Farm.Country = 'Colombia' ")

        # fetch all the matching rows 
        result = cursor.fetchall()
        
        # loop through the rows
        for row in result:
            print(row)
            print("\n")

    user_story = input('What user story do you want to fulfill? (1-5, "q" to quit program) ')



con.commit()
con.close()


