# Product Service


## How to run:
its a Spring boot application, exposing Rest APIs.

### `Port: 9001`
API :
1.  `/api/product/addtoorder` -  add the list of products to Order
2.  `/api/product/orderproducts` -  gives back list of products for a given order ID , `orderid` is passed in query string

### Whats inside
1. H2 in memory DB
2. JPA Data
3. Lombok
4. Basic validations for fields
5. for simplicity, POJOs are not created, instead ENTITY are used throughout.
6. `src/test/resources/` has sample json file for `/addtoorder` API
7. Jdk11

# End of File
