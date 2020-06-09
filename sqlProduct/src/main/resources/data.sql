DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  Price INT NOT NULL
);

INSERT INTO products (name, Price) VALUES
  ('product1', 20),
  ('product2', 15),
  ('product3', 7);