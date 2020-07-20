# Order Service


## How to run:
its a Spring boot application, exposing Rest APIs.

### `Port: 9001`
API :
1.  `/api/order/create` -  adds Order to order service and , calls product service to store product in order
2.  `/api/order/{orderId}` -  fetched order details for given order, getes data from order service , calls product service with orderId to fetch the products associated with this order.

### Whats inside
1. H2 in memory DB
2. JPA Data
3. Lombok
4. Basic validations for fields
5. `src/test/resources/` has sample json file for `/addtoorder` API
6. Jdk11


### execution.
1. take the request from `test\resources\order_req.json` POST to  `/api/order/create` api. an order with orderID=1 will get created.
2. GET `/api/order/1` , you should see the stored data in earlier call.
# End of File
