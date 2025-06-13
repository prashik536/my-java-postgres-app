-- init.sql
CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DECIMAL
);

INSERT INTO employees (name, position, salary) VALUES
('John Doe', 'Software Engineer', 90000),
('Jane Smith', 'Project Manager', 95000);
