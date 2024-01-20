# Orders Service

## Order API Documentation

## Get All Orders

### Request

- **Endpoint:** `GET /api/v1/orders/{orderId}`
- **Description:** Get details for a specific order.

### Response

- **Status Code:** 200 OK
- **Body:**
```json
  {
    "orderId": 1001,
    "user": {
        "userId": 2,
        "userName": "Jane Smith",
        "email": "jane@example.com",
        "address": "456 Oak Ave"
    },
    "products": [
        {
            "productId": 108,
            "productName": "Product H",
            "price": 69.99,
            "name": "Description for Product H"
        },
        //... other orders
    ],
    "orderDate": 20231213,
    "quantity": 3,
    "totalAmount": 12.23
}
```

## Create a New Order

### Request

- **Endpoint:** `POST /api/v1/orders`
- **Description:** Create a new order

## Request Body

```json 
{
  "userId": 3,
  "productIds": [2003, 2004],
  "orderDate": 20220122,
  "quantity": 3,
  "totalAmount": 89.97
}
```
### Response

- **Status Code:** 201 CREATED
- **Body:**
```json
{
  "orderId": 1001,
  "user": {
    "userId": 3,
    "userName": "Jane Smith",
    "email": "jane@example.com",
    "address": "456 Oak Ave"
  },
  "products": [
    {
      "productId": 2003,
      "productName": "Product H",
      "price": 69.99,
      "name": "Description for Product H"
    },
    {
      "productId": 2004,
      "productName": "Product K",
      "price": 69.99,
      "name": "Description for Product H"
    }
  ],
  "orderDate": 20231213,
  "quantity": 3,
  "totalAmount": 89.97
}
```

## Update an Existing Order

### Request

- **Endpoint:** `PUT /api/v1/orders/{orderId}`
- **Description:** Update an existing order.

#### Request Body

```json
{
  "orderId": 1002,
  "userId": 3,
  "productIds": [2003, 2004],
  "orderDate": 20220122,
  "quantity": 5,
  "totalAmount": 149.95
}
```

### Response
- **Status Code:** 200 OK
- **Body:** The updated order object


## Delete an Order

### Request

- **Endpoint:** `DELETE /api/v1/orders/{orderId}`
- **Description:** Delete an existing order.

- **Path Parameters:**
  - `orderId` (integer, required): The ID of the order to be deleted.

### Response

- **Status Code:** 204 No Content
- **Body:** (No Content)


## Other API
