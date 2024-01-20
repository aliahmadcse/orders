# Orders Service

---

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


## Stat APIs

## Get Top 3 Users by Ordered Products

### Request

- **Endpoint:** `GET /api/v1/users/top-users`
- **Description:** Get the top 3 users who have ordered the most products based on the count of products in their orders.

### Response

- **Status Code:** 200 OK
- **Body:**
```json
  [
    {
      "userId": 1,
      "userName": "John Doe",
      "totalOrderedProducts": 123
    },
    {
      "userId": 2,
      "userName": "Jane Smith",
      "totalOrderedProducts": 121
    },
    {
      "userId": 3,
      "userName": "Alice Johnson",
      "totalOrderedProducts": 120
    }
  ]
```

## Get Top 3 Most Ordered Products

### Request

- **Endpoint:** `GET /api/v1/product/top`
- **Description:** Get the top 3 most ordered products based on the number of all orders.

### Response

- **Status Code:** 200 OK
- **Body:**
```json
  [
    {
      "productId": 1001,
      "productName": "Product A",
      "totalOrders": 25
    },
    {
      "productId": 1002,
      "productName": "Product B",
      "totalOrders": 20
    },
    {
      "productId": 1003,
      "productName": "Product C",
      "totalOrders": 18
    }
  ]
```


## Get Top 3 Most Reordered Products

### Request

- **Endpoint:** `GET /api/v1/products/top/reordered`
- **Description:** Get the top 3 most reordered products based on each user's first order.

### Response

- **Status Code:** 200 OK
- **Body:**
```json
  [
    {
      "productId": 1001,
      "productName": "Product A"
    },
    {
      "productId": 1002,
      "productName": "Product B"
    },
    {
      "productId": 1003,
      "productName": "Product C"
    }
  ]
```
