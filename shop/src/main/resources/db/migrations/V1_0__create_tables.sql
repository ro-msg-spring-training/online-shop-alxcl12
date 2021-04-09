CREATE TABLE IF NOT EXISTS `ProductCategory`(
    Id int not null AUTO_INCREMENT primary key,
    Name varchar(100),
    Description varchar(100)
);


CREATE TABLE IF NOT EXISTS `Supplier`(
    Id int not null AUTO_INCREMENT primary key,
    Name varchar(100)
);


CREATE TABLE IF NOT EXISTS `Customer`(
    Id int not null AUTO_INCREMENT primary key,
    FirstName varchar(100),
    LastName varchar(100),
    Username varchar(100),
    Password varchar(100),
    EmailAddress varchar(100)
);


CREATE TABLE IF NOT EXISTS `Location`(
    Id int not null AUTO_INCREMENT primary key,
    Name varchar(100),
    AddressCountry varchar(100),
    AddressCity varchar(100),
    AddressCounty varchar(100),
    AddressStreetAddress varchar(100)
);


CREATE TABLE IF NOT EXISTS `Revenue`(
    Id int not null AUTO_INCREMENT primary key,
    LocationId int,
    Date date,
    Sum bigint
);


CREATE TABLE IF NOT EXISTS `Order`(
    Id int not null AUTO_INCREMENT primary key,
    ShippedFromId int,
    CustomerId int,
    CreatedAt datetime,
    AddressCountry varchar(100),
    AddressCity varchar(100),
    AddressCounty varchar(100),
    AddressStreetAddress varchar(100)
);


CREATE TABLE IF NOT EXISTS `OrderDetail`(
    OrderId int not null,
    ProductId int not null,
    Quantity int,
    primary key(OrderId, ProductId)
);



CREATE TABLE IF NOT EXISTS `Stock`(
    ProductId int not null,
    LocationId int not null,
    Quantity int,
    primary key(ProductId, LocationId)
);


CREATE TABLE IF NOT EXISTS `Product`(
    Id int not null AUTO_INCREMENT primary key,
    Name varchar(100),
    Description varchar(100),
    Price bigint,
    Weight double,
    CategoryId int,
    SupplierId int,
    ImageUrl varchar(100)
);















