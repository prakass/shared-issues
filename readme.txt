This application uses Jetty server as web container, Spring framework for bean container and Hibernate for ORM.
This application depends on MySql server. You should set host, port and login credential of mysql to shared-issues.properties file

To start this application the main class is com.sharedissues.all.common.JettyServer
This class takes two command line argument 
#First one is for mode 
mode can have two values prod or dev

#Second is port. Remember that the port you give should not be used by other application in the system.
Port must be integer value.

#The scripts build.sh and start.sh are specific for my production server and they might not be useful for general purpose


#DB properties
db.host=localhost
db.db=orientation
db.username=root
db.password=root

#DB schema creation
schema.create=create
