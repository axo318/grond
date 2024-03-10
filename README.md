# grond

## Start localhost postgres in docker
```bash
docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=catalog -p 5432:5432 -d postgres
```