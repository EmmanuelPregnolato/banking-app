# Dev Environment Setup

## MySQL

### 📺 Tutorial
https://www.youtube.com/watch?v=fq04bXwKEUM

### Installation
```bash
brew install mysql
brew install --cask mysqlworkbench
```

### Commands
```bash
# Start
brew services start mysql

# Stop
brew services stop mysql

# Open Workbench
open -a "MySQLWorkbench"
```

### SQL
```sql
CREATE DATABASE banking_app;
```