$tourneyCreateBody = @{
    "admin"="patrick"
    "password"="fuckinaround"
}

Invoke-RestMethod -Uri http://localhost:8080/api/tournament -Method Get
