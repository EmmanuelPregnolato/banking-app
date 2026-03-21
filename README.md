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

# Known Issues & Warnings

## CVE-2026-29062 — jackson-core vulnerability
- **Severity:** 7.5 (High)
- **Status:** ⏳ Waiting for Spring Boot fix
- **Details:** `UTF8DataInputJsonParser` nesting depth constraint bypass
- **Fix:** Update Spring Boot when jackson-core 3.1.0+ is included