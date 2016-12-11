# Cui-Cui
Un projet Spring de microbloging par VAN DE KADSYE Quentin et TANGHE Jérôme

## Mise en place

## API

### Avant-propos
La création et la suppression d'user n'ont volontairement pas été implémentées

### Users

L'API de gestion des utilisateurs est disponible grâce au chemin : ``` api/users/ ```

``` GET /``` permet d'obtenir la liste de tous les utilisateurs.

``` GET /id ``` permet d'obtenir les informations sur un utilisateur en particulier en fonction de l'identifiant

``` GET /get/username ``` Permet d'obtenir les informations d'un utilisateur en fonction de son ``` username ``` (pseudo)

``` PUT /obtainToken/{username}/{password} ``` Permet à l'utilisateur d'obtenir un token, pour pouvoir utiliser d'autres méthodes d'API

``` DELETE /deleteToken/{username}/{password}/{token} ``` Permet de supprimer son token

``` PUT /{username}/{newUsername}/{token}``` Permet de modifier son pseudo

### Messages

L'API de gestion des messages est disponible au chemin : ```api/messages/```

``` GET /``` Permet d'obtenir la liste de tous les messages

``` GET /id``` Permet d'obtenir le message ayant l'id correspondant

``` GET /hashtag/name``` Permet d'obtenir les messages ayant le hashtag 'name' 

``` GET /search/text ``` Permet d'obtenir les messages ayant *exactement* le texte text (le paramètre)

``` GET /token/message``` Permet d'envoyer un message, à condition d'avoir un token valide

``` DELETE /id ``` Permet d'effacer le message dont l'id est en parametre

