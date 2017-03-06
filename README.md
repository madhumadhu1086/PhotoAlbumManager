# PhotoAlbumManager

I have used Spring, hibernate, Mysql to create this Rest API. I havent taken the whole data from the given endpoints but if it is required to consume all fields in the given end points i can extend this project to consume all the fields.

I have mainly concentrated on performing REST calls and doing CRUD operations on the database.

#Steps To Execute
1. Import the project as Maven project
2.Change the following values in spring-servlet.xml file
<property name="url" value="jdbc:mysql://localhost:3306/photoManager" />
		<property name="username" value="root" />
		<property name="password" value="Live2life" />

3. Url for application is "http://localhost:2020/SpringRestHibernateExample" - click on three links provided(listUsers, listAlbums, listPhotos) on welcome page to get the data from the endpoints and store in our database connected
4. All CRUD operations can be done using Postman
5. Url for Crud operations on User are

http://localhost:2020/SpringRestHibernateExample/fetchAllUsers  -  to display all usres in Json format 
http://localhost:2020/SpringRestHibernateExample/user/{id}  - to get details of a specific user with id given in {id}
http://localhost:2020/SpringRestHibernateExample/user/add - to add a user
http://localhost:2020/SpringRestHibernateExample/user/delete/{id} - to delete a user with specific id
http://localhost:2020/SpringRestHibernateExample/user/update/{id} - to update a user with specific id

6. Url for CRUD operations on photos are

http://localhost:2020/SpringRestHibernateExample/fetchAllPhotos - to display all photos
http://localhost:2020/SpringRestHibernateExample/get/photo/{id} - to get a photo with specific id
http://localhost:2020/SpringRestHibernateExample/add/photo - to add a photo
http://localhost:2020/SpringRestHibernateExample/delete/photo/{id} - to delete a photo with specific id
http://localhost:2020/SpringRestHibernateExample/update/photo/{id} - to update a photo with specific id

7.Url for CRUD operations on Albums are

http://localhost:2020/SpringRestHibernateExample/fetchAllAlbums - to display all albums
http://localhost:2020/SpringRestHibernateExample/get/album/{id} - to get a album with specific id
http://localhost:2020/SpringRestHibernateExample/add/album - to add a album
http://localhost:2020/SpringRestHibernateExample/delete/album/{id} - to delete a album with specific id
http://localhost:2020/SpringRestHibernateExample/update/album/{id} - to update a album with specific id

