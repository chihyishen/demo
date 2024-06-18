# 使用 Maven 3.8.4 和 OpenJDK 17 的官方映像作為構建階段
FROM maven:3.8.4-openjdk-17 AS build

# 設置工作目錄
WORKDIR /app

# 複製 Maven 配置文件
COPY pom.xml .

# 下載依賴項以便它們可以緩存
RUN mvn dependency:go-offline -B

# 複製應用程序源代碼
COPY src ./src

# 使用 Maven 構建應用程序
RUN mvn clean package -DskipTests

# 使用 OpenJDK 17 的官方映像作為運行階段
FROM openjdk:17-jdk-slim

# 設置應用程序的工作目錄
WORKDIR /app

# 從構建階段複製生成的 JAR 文件
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# 暴露應用程序運行的端口
EXPOSE 8080

# 設置容器啟動時運行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]