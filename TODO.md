# TODO ViaFa application

##### Database MySql

 [X] Creare utenza, db e tabelle necessarie per applicazione

##### Structure eclipse project

com.babo.bmbtrasporti.viafa
com.babo.bmbtrasporti.viafa.dao
com.babo.bmbtrasporti.viafa.entity
com.babo.bmbtrasporti.viafa.rest
com.babo.bmbtrasporti.viafa.service

##### List of REST Api

- Driver

  Http Method |	 		API            |  Action
  ------------|------------------------|-------------------------
  POST        | /api/drivers           | Create a new driver
  GET         | /api/drivers           | Read a list of drivers
  GET         | /api/drivers/{driverId}| Read a single driver
  PUT         | /api/drivers           | Update an existing driver
  DELETE      | /api/drivers/{driverId}| Delete an existing driver
  
  
  Driver REST Controller => Driver Service => Driver DAO (Hibernate) => DB (MySql)
  
  [X] Creazione Entity
  [ ] Creazione Service (DriverService, DriverServiceImpl)
  [ ] Creazione DAO (DriverDAO, DriverDAOImpl)
  [ ] Creazione REST (DriverRestController)
  
- Truck
  