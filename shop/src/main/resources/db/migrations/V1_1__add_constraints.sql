ALTER TABLE Revenue
ADD FOREIGN KEY (LocationId) REFERENCES Location (Id);

ALTER TABLE `Order`
ADD FOREIGN KEY (ShippedFromId) REFERENCES Location (Id);

ALTER TABLE `Order`
ADD FOREIGN KEY (CustomerId) REFERENCES Customer (Id);

ALTER TABLE OrderDetail
ADD FOREIGN KEY (OrderId) REFERENCES `Order` (Id);

ALTER TABLE OrderDetail
ADD FOREIGN KEY (ProductId) REFERENCES Product (Id);

ALTER TABLE Stock
ADD FOREIGN KEY (LocationId) REFERENCES Location (Id);

ALTER TABLE Stock
ADD FOREIGN KEY (ProductId) REFERENCES Product (Id);

ALTER TABLE Product
ADD FOREIGN KEY (CategoryId) REFERENCES ProductCategory (Id);

ALTER TABLE Product
ADD FOREIGN KEY (SupplierId) REFERENCES Supplier (Id);

