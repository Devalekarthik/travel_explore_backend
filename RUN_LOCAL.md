# Run locally

## Backend

Open PowerShell and run:

```powershell

cd 'D:\My Website backend\travel_explore_backend'
$env:MAVEN_USER_HOME="$PWD\.m2"
cmd /c "mvnw.cmd spring-boot:run"

```

Then open:

- `http://localhost:8080/api/content`

