# superpac-api

https://github.com/user-attachments/assets/4392d0fc-291f-471c-b05a-6fe565b67a11


## Architecture 

```text
Angular (front)  <---- WebSocket / STOMP ---->  superpac-api
```

- `/app/input`, `/app/restart` : le front envoie les actions du joueur
- `/topic/game-state` : le backend diffuse l'état du jeu (JSON) en continu
- Le service reste **en veille** tant qu'aucune
  partie n'a été démarrée, et se rendort automatiquement à chaque game over.


## Lancer avec Docker

Depuis la racine du projet :

```bash
docker build -t pacman-api ./superpac-api
```

```bash
docker run -d --name pacman-api -p 8081:8081 pacman-api
```

