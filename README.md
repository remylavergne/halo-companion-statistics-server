# Halo 5 Middleware API

- Framework : Ktor 
- IDE : Intellij + Ktor & Kotlin plugins
- Advanced Rest Client : https://install.advancedrestclient.com/install 

## But

Cette API a pour but de s'interfacer entre l'API Halo, et les clients. En effet, l'API de base est très brute, et expose
beaucoup de données. Les écrans des clients, et les fonctionnalités ont besoin d'informations plus condensées.

De plus une l'API Halo est limitée en nombre de requête (10 appels en 10 secondes max).
Une couche de persistence va donc être implémenté dans cette API pour éviter un trop grand nombre d'appels.

## Fonctionnement

### Variables d'environnement

Elle se trouve dans le fichier de configuration `resources/application.conf`.
On peut directement les mettre dans IntelliJ, ou les exporter dans l'environnement de développement.
Un fichier va être créer pour les déployer facilement.

⚠️ Pour consommer l'API Halo, il faut une clef développeur. Elle s'obtiennent en s'inscrivant sur le site officiel <https://developer.haloapi.com/>


### Démarrage du projet

Simplement via la fonction Intellij, via la classe **ApplicationKt**.


### Base de données MongoDb

Cette API utilise une base de données NoSQL MongoDB. Il faut la lancer, via le `docker-compose.yml`.

```terminal
$ docker-compose up -d
```
