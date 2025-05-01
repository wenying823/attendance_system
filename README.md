
# 🕒 員工出勤與請假管理系統(API)

本專案是一個使用 Java、Spring Boot、MyBatis 實作的簡易出勤與請假管理系統，提供 RESTful API 介面供前端串接，支援員工資料管理與出勤打卡紀錄功能。

---

## 🚀 專案技術

- Java 17+
- Spring Boot
- MyBatis
- ZK Framework (前端 UI)
- MySQL 資料庫

---

## 🔧 開發環境設定

1. 安裝 MySQL，建立資料庫：
    ```sql
    CREATE DATABASE attendance_system;
    ```

2. 在 `application.properties` 設定資料庫連線：
    ```properties
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/attendance_system
    spring.datasource.username=root
    spring.datasource.password=123456
    ```

3. 編譯並啟動後端：
    ```bash
    ./mvnw spring-boot:run
    ```

4. 預設 API Server 啟動於：
    ```
    http://localhost:8080
    ```

---

## 📘 API 文件

### 🌐 Base URL
```
http://localhost:8080/api
```

---

## 👨‍💼 員工 API

### 🔹 取得指定員工資訊
- **GET** `/employees/{id}`
- **成功回應範例**
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "hireDate": "2025-05-01"
    }
    ```

### 🔹 取得所有員工清單
- **GET** `/employees`
- **成功回應範例**
    ```json
    [
      {
        "id": 1,
        "name": "John Doe",
        "email": "john.doe@example.com",
        "hireDate": "2025-05-01"
      },
      {
        "id": 2,
        "name": "Jane Smith",
        "email": "jane.smith@example.com",
        "hireDate": "2025-04-15"
      }
    ]
    ```

### 🔹 新增員工
- **POST** `/employees`
- **請求範例**
    ```json
    {
      "name": "Test Wang",
      "email": "test.wang@example.com",
      "hireDate": "2025-05-01"
    }
    ```
- **成功回應範例**
    ```json
    {
      "message": "Employee created successfully",
      "employee": {
        "id": 3,
        "name": "Test Wang",
        "email": "test.wang@example.com",
        "hireDate": "2025-05-01"
      }
    }
    ```

### 🔹 更新員工資料
- **PUT** `/employees/{id}`
- **請求範例**
    ```json
    {
      "name": "Test Wang",
      "email": "test.wang@example.com",
      "hireDate": "2025-05-01"
    }
    ```
- **成功回應範例**
    ```json
    {
      "message": "Employee updated successfully",
      "employee": {
        "id": 3,
        "name": "Test Wang",
        "email": "test.wang@example.com",
        "hireDate": "2025-05-01"
      }
    }
    ```

---

## ⏱️ 出勤 API

### 🔹 上班打卡
- **POST** `/attendance/checkin?employeeId={id}`
- **成功回應範例**
    ```json
    {
      "message": "Check-in successful!"
    }
    ```

### 🔹 下班打卡
- **POST** `/attendance/checkout?employeeId={id}`
- **成功回應範例**
    ```json
    {
      "message": "Check-out successful!"
    }
    ```

### 🔹 查詢出勤紀錄（條件式）
- **GET** `/attendance`
- **Query 參數：**
    - `employeeId` (可選)
    - `date` (可選，格式：yyyy-MM-dd)
- **成功回應範例**
    ```json
    [
      {
        "employeeId": 1,
        "date": "2025-05-01",
        "checkIn": "2025-05-01T09:00:00",
        "checkOut": "2025-05-01T18:00:00"
      }
    ]
    ```

### 🔹 查詢所有出勤紀錄
- **GET** `/attendance/all`
- **成功回應範例**
    ```json
    [
      {
        "employeeId": 1,
        "date": "2025-05-01",
        "checkIn": "2025-05-01T09:00:00",
        "checkOut": "2025-05-01T18:00:00"
      },
      {
        "employeeId": 2,
        "date": "2025-05-01",
        "checkIn": "2025-05-01T08:30:00",
        "checkOut": "2025-05-01T17:30:00"
      }
    ]
    ```

---

## 📦 專案結構

```
employee-attendance-leave-system/
├── controller/
├── service/
├── model/
├── repository/
├── resources/
│   └── application.properties
└── EmployeeAttendanceLeaveSystemApplication.java
```

---

## ✍️ 作者

Wen Ying
