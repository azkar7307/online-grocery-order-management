# online-grocery-order-management

## 1. SQL Query for creating New User & Setting Password
```sql
CREATE USER 'superuser'@'localhost' IDENTIFIED BY 'super';
```

## 2. Grant Privileges to Specific Database
```sql
GRANT ALL PRIVILEGES ON grocery_db.* TO 'superuser'@'localhost';
FLUSH PRIVILEGES;
```

## 3. Verify User Creation
```sql
SELECT user, host FROM mysql.user;
```

## 4. Verify Database Privileges
```sql
SHOW GRANTS FOR 'buybuddy_user'@'localhost';
```