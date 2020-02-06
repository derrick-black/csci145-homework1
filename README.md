# csci145-homework1
Names: Derrick Black, Gavin Roberts, Evan Palm

Due: February 16

About: This program is a turn-based computer game. The player explores a dungeon, encountering monsters and finding loot. The player can choose from two different classes: warrior and thief. The warrior has higher damage and health, while the thief receives 20% more gold. 

The player starts at the top-left corner of the dungeon. A map of the dungeon is displayed showing current location, walls, and visited rooms, as well as the current health and gold. They can move up, down, left, or right and can enter visited and unvisited rooms, but not walls.

When a player enters a room, they will encounter one of a monster, an health elixir, or a bag of gold. If they encounter a monster, they can choose to fight or run. If they fight, the monster deals damage to them, then the player does damage to the monster. If the player runs away, the monster deals damage to the player, then the encounter ends. The combat ends when either the player or monster no longer have positive health or the player runs away. If the player encounters a health elixir or a bag of gold, they gain a random amount of health and a random of gold, respectively. 

If the player's health drops to 0, the player dies and the game is over.
The objective of the game is to reach 100 gold to pay the evil professor to be let out of the dungeon before the player reaches 0 health. Once the player has at least 100 gold, they win the game.

https://docs.google.com/document/d/1puNQXw638es_e8QYSypIj-OanlhlhsKODKSaI_VI5d4/edit
