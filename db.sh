docker run -e ACCEPT_EULA=Y -e SA_PASSWORD=Admin@123 -p 1433:1433 --name sql_server_container -d mcr.microsoft.com/mssql/server:2022-latest
