$tourneyCreateBody = @{
    "admin"="patrick"
    "password"="fuckaroundfindout"
}

Invoke-RestMethod -Uri http://localhost:8080/tournament/foobar -Method Get

Invoke-RestMethod -Uri http://localhost:8080/tournament/create -Method Post `
-Body $tourneyCreateBody
