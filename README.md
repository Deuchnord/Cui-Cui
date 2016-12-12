# Cui-Cui
Un projet Spring de microbloging par VAN DE KADSYE Quentin et TANGHE Jérôme

## Mise en place

### Prérequis

Pour fonctionner, MongoDB doit être installé et configuré, et le service doit être lancé.

**Attention :** sur certains systèmes, il faudra également créer manuellement le répertoire `/data/dbd` :

```bash
sudo mkdir -p /data/dbd
```

### Compiler Cui-Cui

Pour compiler Cui-Cui, taper simplement la commande suivante dans le terminal :
 
```bash
mvn package
```

### Exécuter le serveur

Une fois que la compilation est terminée, il suffit alors de compiler le fichier JAR généré :

```bash
java -jar target/gs-serving-web-content-0.1.0.jar
```

Le serveur va alors être lancé et les pages Web seront accessibles sur [localhost:8080](http://localhost:8080).

### Tests unitaires

Le projet contient un certain nombre de tests unitaires. Ils permettent de valider le bon fonctionnement de certaines méthodes un peu complexes.

Pour lancer les tests unitaires, il suffit de taper la commande suivante dans le terminal :

```bash
mvn test
```

## API

### Avant-propos
La création et la suppression d'user n'ont volontairement pas été implémentées

### Users

L'API de gestion des utilisateurs est disponible grâce au chemin : `/api/users/`.

- `GET /` : permet d'obtenir la liste de tous les utilisateurs.
- `GET /id` : permet d'obtenir les informations sur un utilisateur en particulier en fonction de l'identifiant
- `GET /get/username` : permet d'obtenir les informations d'un utilisateur en fonction de son `username` (pseudo)
- `PUT /obtainToken/{username}/{password}` : permet à l'utilisateur d'obtenir un token, pour pouvoir utiliser d'autres méthodes d'API
- `DELETE /deleteToken/{username}/{password}/{token}` : permet de supprimer son token
- `PUT /{username}/{newUsername}/{token}` : permet de modifier son pseudo

### Messages

L'API de gestion des messages est disponible _via_ le chemin : `api/messages/`
- `GET /` : permet d'obtenir la liste de tous les messages
- `GET /id` : permet d'obtenir le message ayant l'id correspondant
- `GET /hashtag/name` : permet d'obtenir les messages ayant le hashtag 'name' 
- ` GET /search/text` : permet d'obtenir les messages ayant *exactement* le texte text (le paramètre)
- `GET /token/message` : permet d'envoyer un message, à condition d'avoir un token valide
- `DELETE /id` : permet d'effacer le message dont l'id est en parametre

