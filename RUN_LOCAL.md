# Run locally

## Backend

### 1) MongoDB (website database)

MongoDB Compass connection string:

```text
mongodb://localhost:27017/Travel_Explore
```

### 2) Start the backend

Open PowerShell and run:

```powershell
cd 'D:\My Website backend\travel_explore_backend'
Remove-Item Env:\MAVEN_USER_HOME -ErrorAction SilentlyContinue

# Optional override (defaults to mongodb://localhost:27017/Travel_Explore)
# $env:MONGODB_URI="mongodb://localhost:27017/Travel_Explore"

.\mvnw.cmd spring-boot:run
```

Then open:

- `http://localhost:8080/api/content`

Note: Backend content is stored in MongoDB only. If the database is empty, `/api/content` will return an empty response.
