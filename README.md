  This is a Server`s part of client-server application using Netty, Hibernate, MySQL,
      JSON Web Token, Hashing and Salting password.

  The application has a file repository. Users can receive a list of files, their description and
      download the selected file. The user can upload his files to the repository.

  The test files are located in the /FileRepositoryServer/files directory of server's computer.
  Uploaded files will be placed to the /FileRepositoryServer/files directory too.
  Downloaded files will be placed to the /FileTarget directory from the root of client`s computer.

  It is necessary:
- change hibernate.cfg.xml for your database.
- change repository.xbm.xml if you are not using MySQL.
- specify the path to resources/META-INF/persistence.xml file into CLASSPATH.
- create "repository" database.
- create tables USERS and FILES (there are schemes for creating and filling the tables
      USERS and FILES in the /setupfiles directory).
