CREATE TABLE cart_items
(
    id         bigint IDENTITY (1, 1) NOT NULL,
    cart_id    bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity   int    NOT NULL,
    CONSTRAINT pk_cart_items PRIMARY KEY (id)
)
    GO

CREATE TABLE carts
(
    id     bigint IDENTITY (1, 1) NOT NULL,
    status varchar(255) NOT NULL,
    CONSTRAINT pk_carts PRIMARY KEY (id)
)
    GO

CREATE TABLE categories
(
    id          bigint IDENTITY (1, 1) NOT NULL,
    name        varchar(255) NOT NULL,
    description varchar(255),
    CONSTRAINT pk_categories PRIMARY KEY (id)
)
    GO

CREATE TABLE customers
(
    id      bigint IDENTITY (1, 1) NOT NULL,
    user_id bigint       NOT NULL,
    cart_id bigint       NOT NULL,
    status  varchar(255) NOT NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
)
    GO

CREATE TABLE employees
(
    id       bigint IDENTITY (1, 1) NOT NULL,
    user_id  bigint       NOT NULL,
    store_id bigint       NOT NULL,
    status   varchar(255) NOT NULL,
    CONSTRAINT pk_employees PRIMARY KEY (id)
)
    GO

CREATE TABLE orders
(
    id          bigint IDENTITY (1, 1) NOT NULL,
    customer_id bigint         NOT NULL,
    cart_id     bigint         NOT NULL,
    employee_id bigint         NOT NULL,
    created_at  datetime       NOT NULL,
    total_price decimal(10, 2) NOT NULL,
    status      varchar(255)   NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
)
    GO

CREATE TABLE product_category_links
(
    id          bigint IDENTITY (1, 1) NOT NULL,
    product_id  bigint NOT NULL,
    category_id bigint NOT NULL,
    CONSTRAINT pk_product_category_links PRIMARY KEY (id)
)
    GO

CREATE TABLE products
(
    id          bigint IDENTITY (1, 1) NOT NULL,
    supplier_id bigint         NOT NULL,
    name        varchar(255)   NOT NULL,
    price       decimal(10, 2) NOT NULL,
    quantity    int            NOT NULL,
    status      varchar(255)   NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
)
    GO

CREATE TABLE stores
(
    id            bigint IDENTITY (1, 1) NOT NULL,
    status        varchar(255) NOT NULL,
    location      varchar(255) NOT NULL,
    working_hours varchar(255),
    open_date     date         NOT NULL,
    CONSTRAINT pk_stores PRIMARY KEY (id)
)
    GO

CREATE TABLE suppliers
(
    id             bigint IDENTITY (1, 1) NOT NULL,
    name           varchar(255) NOT NULL,
    country        varchar(255) NOT NULL,
    contract_start date         NOT NULL,
    contract_end   date         NOT NULL,
    CONSTRAINT pk_suppliers PRIMARY KEY (id)
)
    GO

CREATE TABLE supplies
(
    id                   bigint IDENTITY (1, 1) NOT NULL,
    warehouse_manager_id bigint NOT NULL,
    supplier_id          bigint NOT NULL,
    date                 date   NOT NULL,
    CONSTRAINT pk_supplies PRIMARY KEY (id)
)
    GO

CREATE TABLE supply_items
(
    id         bigint IDENTITY (1, 1) NOT NULL,
    supply_id  bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity   int    NOT NULL,
    CONSTRAINT pk_supply_items PRIMARY KEY (id)
)
    GO

CREATE TABLE users
(
    id            bigint IDENTITY (1, 1) NOT NULL,
    email         varchar(255) NOT NULL,
    password      varchar(255) NOT NULL,
    role          varchar(255) NOT NULL,
    activity      varchar(255) NOT NULL,
    first_name    varchar(255) NOT NULL,
    last_name     varchar(255) NOT NULL,
    phone         varchar(255),
    registered_at datetime     NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
)
    GO

CREATE TABLE warehouse_managers
(
    id       bigint IDENTITY (1, 1) NOT NULL,
    user_id  bigint       NOT NULL,
    store_id bigint       NOT NULL,
    status   varchar(255) NOT NULL,
    CONSTRAINT pk_warehouse_managers PRIMARY KEY (id)
)
    GO

ALTER TABLE product_category_links
    ADD CONSTRAINT uc_bea2a55117588734553f89177 UNIQUE (product_id, category_id)
    GO

ALTER TABLE categories
    ADD CONSTRAINT uc_categories_name UNIQUE (name)
    GO

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_cart UNIQUE (cart_id)
    GO

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_user UNIQUE (user_id)
    GO

ALTER TABLE cart_items
    ADD CONSTRAINT uc_e020537f6d07b2305eddbe2b3 UNIQUE (cart_id, product_id)
    GO

ALTER TABLE supply_items
    ADD CONSTRAINT uc_ed00db5e04328c4ba00e9f3fc UNIQUE (supply_id, product_id)
    GO

ALTER TABLE employees
    ADD CONSTRAINT uc_employees_user UNIQUE (user_id)
    GO

ALTER TABLE orders
    ADD CONSTRAINT uc_orders_cart UNIQUE (cart_id)
    GO

ALTER TABLE products
    ADD CONSTRAINT uc_products_name UNIQUE (name)
    GO

ALTER TABLE stores
    ADD CONSTRAINT uc_stores_location UNIQUE (location)
    GO

ALTER TABLE suppliers
    ADD CONSTRAINT uc_suppliers_name UNIQUE (name)
    GO

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email)
    GO

ALTER TABLE warehouse_managers
    ADD CONSTRAINT uc_warehouse_managers_user UNIQUE (user_id)
    GO

ALTER TABLE cart_items
    ADD CONSTRAINT FK_CART_ITEMS_ON_CART FOREIGN KEY (cart_id) REFERENCES carts (id)
    GO

ALTER TABLE cart_items
    ADD CONSTRAINT FK_CART_ITEMS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id)
    GO

ALTER TABLE customers
    ADD CONSTRAINT FK_CUSTOMERS_ON_CART FOREIGN KEY (cart_id) REFERENCES carts (id)
    GO

ALTER TABLE customers
    ADD CONSTRAINT FK_CUSTOMERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id)
    GO

ALTER TABLE employees
    ADD CONSTRAINT FK_EMPLOYEES_ON_STORE FOREIGN KEY (store_id) REFERENCES stores (id)
    GO

ALTER TABLE employees
    ADD CONSTRAINT FK_EMPLOYEES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id)
    GO

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CART FOREIGN KEY (cart_id) REFERENCES carts (id)
    GO

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id)
    GO

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id)
    GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES suppliers (id)
    GO

ALTER TABLE product_category_links
    ADD CONSTRAINT FK_PRODUCT_CATEGORY_LINKS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id)
    GO

ALTER TABLE product_category_links
    ADD CONSTRAINT FK_PRODUCT_CATEGORY_LINKS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id)
    GO

ALTER TABLE supplies
    ADD CONSTRAINT FK_SUPPLIES_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES suppliers (id)
    GO

ALTER TABLE supplies
    ADD CONSTRAINT FK_SUPPLIES_ON_WAREHOUSE_MANAGER FOREIGN KEY (warehouse_manager_id) REFERENCES warehouse_managers (id)
    GO

ALTER TABLE supply_items
    ADD CONSTRAINT FK_SUPPLY_ITEMS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id)
    GO

ALTER TABLE supply_items
    ADD CONSTRAINT FK_SUPPLY_ITEMS_ON_SUPPLY FOREIGN KEY (supply_id) REFERENCES supplies (id)
    GO

ALTER TABLE warehouse_managers
    ADD CONSTRAINT FK_WAREHOUSE_MANAGERS_ON_STORE FOREIGN KEY (store_id) REFERENCES stores (id)
    GO

ALTER TABLE warehouse_managers
    ADD CONSTRAINT FK_WAREHOUSE_MANAGERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id)
    GO