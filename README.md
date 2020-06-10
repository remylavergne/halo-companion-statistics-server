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

## Environnement de build standalone

Si tu souhaites te dispenser d'un IDE et de gérer le projet en CLI, tu es au bon endroit ! 🤓

### Installation native

Peu importe le système d'exploitation, il est nécessaire d'installer certains outils :

1. Installation de **Gradle**
2. Installation du **JDK**

### Image Docker

L'idée est d'utiliser l'[image Docker officielle de Gradle](https://hub.docker.com/_/gradle) pour compiler et exécuter l'application.
Cela évite de gérer les dépendances avec la **JVM**.

La solution la plus simple consiste à créer un **container** que l'on pourra réutiliser à volonté :

* Conservation des variables d'environnement
* Instantiation d'un seul daemon **Gradle**

> Bien évidemment, **Docker** est requis pour ce type d'installation. 🤠

#### Création du container

Il faut lancer un terminal à partir d'ici et exécuter les commandes suivantes :

```bash
# Création et connexion à un container Gradle nommé "gradle-env" :
# 1. Téléchargement de l'image `gradle:latest`
# 2. Création d'un volume partagé avec l'hôte pour accéder à l'arborescence du projet
# 3. Redirection du port `8080` vers celui de l`hôte
# 4. Connexion à la session `gradle`
# 5. Lancement d'un terminal `bash` en intéractif
docker run --name gradle-env -u gradle -it -v `pwd`:/home/gradle/project -w /home/gradle/project -p 8080:8080 gradle bash
# Debug de la CLI Gradle
gradle -v
# Se déconnecter de la session
exit
```

Le *container* `gradle-env` doit à présent se retrouver arrêté, on peut le vérifier comme suit :

```bash
# Affichage de tous les containers
docker ps -a
```

> Lorsque l'on se déconnecte de la session avec `exit`,le *container* s'arrête automatiquement.

#### Lancement et connexion au container

Une fois que le *container* `gradle-env` existe, on peut le relancer n'importe quand et de n'importe où :

```bash
# Lancement du container en mode détaché
docker start gradle-env
# Connexion au terminal du container
docker attach gradle-env
```

La CLI de `Gradle` est à nouveau opérationnelle.

### Initialisation du projet

```bash
# Clean-up du projet
gradle clean
# Initialisation des variables d'environnement
# NOTE: la clé de l'API doit être passée en paramètre !
source setenv.sh [API_KEY]
# Compilation du projet
gradle build
```

### Exécution de l'application

```bash
# Compilation (si nécessaire) et exécution de l'application sur la JVM
gradle run
```
