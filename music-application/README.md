# Music Library and Shopping Application

Introducing a sophisticated Music Library and Shopping Application designed to seamlessly engage with a comprehensive 
database. This database encompasses intricate details about albums, musicians, labels, customers, and the nuanced 
aspects of their orders. By doing so, the application offers a holistic perspective into the dynamic realms of both 
music and sales.

## Database Design


This is the meticulously crafted design of the `musicDB.sql` database, where Primary and Foreign keys are thoughtfully 
assigned to emphasize dependencies. This showcases the significance of relationships, whether they unfold as one-to-one 
connections or intricate one-to-many associations.

![DataBase design](/Users/jacknichols/Desktop/database-design.png)

## Methods 

This application encompasses a diverse range of methods. Initially, the JdbcDao methods serve the purpose of retrieving, 
updating, creating, and deleting data stored within the musicDB database. Subsequently, both the App and AppService 
components house methods enabling users to perform analogous operations of pulling, updating, creating, and deleting 
data within the musicDB database.


## `Application`

The Application holds collection of Menu options, prompts and functions. It ties together everything from the database to the `Dao` methods. 
The `structure-of-application-window-prompts` holds the layout of every menu. This is the reference for the Applications ease of use.
The user can have the items and their respective information displayed for them or they can filter their searches to particular details that pertain
to each "Item" in the database, such as: Id's, titles, or even names.

### !! Feel free to download and play with the application. Be aware that it is necessary to utilize the `musicDB.sql` to create the database on your system 
### in order to witness the fun that is this application !!