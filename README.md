# SuperPac 🎮👾

https://github.com/user-attachments/assets/4392d0fc-291f-471c-b05a-6fe565b67a11
 
## Description 📝
SuperPac est une version modernisée du célèbre jeu Pacman architecturée selon les design patterns **MVC** (Modèle-Vue-Contrôleur) et **State**.
Le joueur collecte des **super gommes** offrant des pouvoirs spéciaux tels que :
- Devenir **invisible** 👻
- Changer de **map** 🔄
- Devenir un **super Pacman** qui peut manger les **fantômes** 👹

### 🍎 Objets spéciaux et effets :
- **PommeBlanche** ⚪ : +100 points  
- **Pomme speciale rose** 💗 : +300 points — Pacman devient **invisible** pour les fantômes, change de couleur en **rose** et peut les croiser sans perdre de vie.
- **Pomme speciale verte** 💚 : +1000 points — **Change la map**
- **Pomme speciale orange** 🧡 : +500 points — Pacman devient un **SuperPacman**, se déplace **2x plus vite**, les fantômes deviennent **blancs** et peuvent être **mangés**.  
  Lorsqu’un fantôme est mangé, il **réapparaît au centre de la map**.   

🕒 Les effets des super gommes speciales durent **10 secondes**.  

❤️ Le jeu commence avec **3 vies**, et tu gagnes **1 vie tous les 5000 points**.  
🎯 Le jeu se termine lorsque :  
- Toutes les pacgommes sont mangées ✅  
- Tu perds toutes tes vies ❌  

---

### 🔑 Commandes de déplacement :
Pour jouer, il suffit d'utiliser ton clavier en minuscule :
- **z** : Aller **en haut** ⬆️
- **q** : Aller **à gauche** ⬅️
- **s** : Aller **en bas** ⬇️
- **d** : Aller **à droite** ➡️

### 📜 Instructions d'installation et d'exécution :
1. **Cloner le projet** :
   ```bash
   git clone https://github.com/votre-utilisateur/SuperPac.git
   cd SuperPac
   ```

2. **Compiler avec javac** :
   - Compile les fichiers Java avec la commande suivante :
     ```bash
     javac -d bin -encoding UTF-8 src/entites/*.java src/jeu/*.java src/ressources/*.java
     ```

3. **Exécuter le projet** :
   ```bash
   java -cp bin jeu.App
   ```

### 📜 Importer dans Eclipse :
- Ouvre Eclipse.
- Sélectionne **File** > **Import**.
- Choisis **Existing Projects into Workspace**.
- Sélectionne le dossier du projet que tu as cloné.

### ⚙️ Pré-requis :
- **Java 8 ou supérieur** ☕
- **Eclipse IDE** pour importer facilement le projet 🖥️

### 🎉 Profite du jeu et n'oublie pas de manger des fantômes ! 👾
