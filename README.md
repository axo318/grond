# Grond 🐺
K8s-native build system.

## Setup Java Formatting
- Install the Intellij [palantir-java-format](https://plugins.jetbrains.com/plugin/13180-palantir-java-format) plugin
- The plugin will be disabled by default on new projects, but if using the plugin, it will be recommended in IntelliJ, and automatically configured.
- To manually enable it in the current project, go to File→Settings...→palantir-java-format Settings (or IntelliJ IDEA→Preferences...→Other Settings→palantir-java-format Settings on macOS) and check the Enable palantir-java-format checkbox.


## Run catalog
### Start postgres db in docker
```bash
docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=catalog -p 5432:5432 -d postgres
```
### Wipe postgres db and restart
```bash
docker stop my-postgres && docker rm my-postgres && docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=catalog -p 5432:5432 -d postgres
```

## Run object store
### Start mongoDB in docker
```bash
docker run --name my-mongodb -d -p 27017:27017 mongo
```
### Wipe mongoDB and restart
```bash
docker stop my-mongodb && docker rm my-mongodb && docker run --name my-mongodb -d -p 27017:27017 mongo
```


## Run configurations
Run configurations must have an environmental variable `GROND_CONFIG_PATH` set. This variable is used by all components 
to discover the `grond-configuration.yml` file.

1. Edit Configurations...
2. Select the required configuration
3. Click modify options
4. Select Environment Variables
5. Edit the environment variable bar that appears
6. Click +
7. Set the following 
   - Name=`GROND_CONFIG_PATH`
   - Value=`{{absolute path to file}}`
     - This can be copied by right-clicking the `grond-configuration.yml`
     - Click `Copy Path/Reference...`
     - Select `Absolute Path`