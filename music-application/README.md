# Music Library and Shopping Application

Introducing a sophisticated Music Library and Shopping Application designed to seamlessly engage with a comprehensive 
database. The `Music Store Application`, initially a console-based music database management system, 
now integrates connectivity with external APIs to expand its functionality. 
Designed to interact seamlessly with a PostgreSQL database named `musicDB`, 
the application offers a user-friendly interface for managing albums, artists, and related information. 
The existing implementation utilizes the JDBC (Java Database Connectivity) API to establish a secure connection to the database, 
coupled with Apache Commons DBCP2 for efficient connection pooling.

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

### For example: 

#### `JdbcAlbumDao`
* the `JdbcAlbumDao` method _deleteAlbumById(int albumId)_ searches through the database for the _album_id_
then deletes it from its respective tables (line_item and sale).

#### `JdbcCustomerDao`
* the `JdbcCustomerDao` method _getCustomers()_ goes directly to the customer table, while using the `Customer` to then
"print" out a string of the customers info (their id, name, etc.).


## `Application`

### NEW AND IMPROVED!!!

The application has achieved seamless integration with both a database and an API. Utilizing dedicated controllers such as: 
AlbumController and ArtistController (with additional controllers in the pipeline), the application adeptly manages the exchange of requests.

Users can now effortlessly establish connections to the database, enabling them to access comprehensive information about their preferred artists. 
Moreover, the application empowers users to augment their personal library by adding selected artists, enhancing the overall user experience.


