-- Create the database
CREATE DATABASE IF NOT EXISTS expense_tracker_indigo;

-- Use the database
USE expense_tracker_indigo;

-- Table for user roles
CREATE TABLE user_role
(
    role_id     VARCHAR(20) PRIMARY KEY,
    role_name   VARCHAR(100),
    description TEXT
);

-- Table for users
CREATE TABLE user
(
    user_id      VARCHAR(50) PRIMARY KEY,
    username     VARCHAR(100) NOT NULL,
    password     VARCHAR(100) NOT NULL,
    email        VARCHAR(100),
    phone_number VARCHAR(20),
    role_id      VARCHAR(20),
    FOREIGN KEY (role_id) REFERENCES user_role (role_id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- Table for categories
CREATE TABLE category
(
    category_id VARCHAR(50) PRIMARY KEY,
    name        VARCHAR(100),
    description TEXT
);

-- Table for expenses
CREATE TABLE expense
(
    expense_id  VARCHAR(50) PRIMARY KEY,
    user_id     VARCHAR(50),
    amount      DECIMAL(10, 2),
    date        DATE,
    description TEXT,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Linking table for expense and category (many-to-many)
CREATE TABLE expensecategory
(
    expense_id  VARCHAR(50),
    category_id VARCHAR(50),
    PRIMARY KEY (expense_id, category_id),
    FOREIGN KEY (expense_id) REFERENCES expense (expense_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (category_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table for reports
CREATE TABLE report
(
    report_id  VARCHAR(50) PRIMARY KEY,
    role_id    VARCHAR(20),
    user_id    VARCHAR(50),
    start_date DATE,
    end_date   DATE,
    format     VARCHAR(50),
    FOREIGN KEY (role_id) REFERENCES user_role (role_id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);


-- Insert into category
INSERT INTO category (category_id, name, description)
VALUES ('cat001', 'Travel', 'Expenses related to business travel'),
       ('cat002', 'Food', 'Meals and snacks'),
       ('cat003', 'Office Supplies', 'Stationery and equipment'),
       ('cat004', 'Entertainment', 'Client entertainment expenses');

-- Insert into user_role
INSERT INTO user_role (role_id, role_name, description)
VALUES ('role001', 'Admin', 'System Administrator'),
       ('role002', 'RegularUser', 'Regular User');

-- Insert into user
INSERT INTO user (user_id, username, password, email, phone_number, role_id)
VALUES ('user001', 'thaiphan', '1234', 'johndoe@example.com', '1234567890', 'role002'),
       ('user002', 'jasmine', '1234', 'janedoe@example.com', '2345678901', 'role002'),
       ('user003', 'adminuser', 'adminpass', 'admin@example.com', '3456789012', 'role001');

-- Insert into expense
INSERT INTO expense (expense_id, user_id, amount, date, description)
VALUES ('exp001', 'user001', 150.00, '2025-04-01', 'Flight to New York'),
       ('exp002', 'user002', 35.50, '2025-04-02', 'Lunch with client'),
       ('exp003', 'user001', 12.00, '2025-04-03', 'Office pen and paper'),
       ('exp004', 'user003', 200.00, '2025-04-04', 'System maintenance event');

-- Insert into expensecategory (many-to-many)
INSERT INTO expensecategory (expense_id, category_id)
VALUES ('exp001', 'cat001'),
       ('exp002', 'cat002'),
       ('exp003', 'cat003'),
       ('exp004', 'cat004');

-- Insert into report
INSERT INTO report (report_id, role_id, user_id, start_date, end_date, format)
VALUES ('rep001', 'role001', 'user001', '2025-04-01', '2025-04-15', 'PDF'),
       ('rep002', 'role001', 'user002', '2025-04-01', '2025-04-10', 'Excel'),
       ('rep003', 'role001', 'user003', '2025-04-01', '2025-04-05', 'HTML');

