# CSC120-FinalProject

Description of layout:

The world is created with a graph data structure, meaning that locations are accessible based on proximity. The game starts with the player at the spaceship location, and the field location and forest location are accessible from that. The field is only connected to the spaceship. The forest serves as a base that is connected to three locations: the spaceship, the lake, and the mountain. The mountain then connects to the cave location.

Reflection/description of alternative design:

I initially had trouble figuring out which data structure to use for my map. I landed on a graph because I liked how that could allow the locations to interact with one another and felt that it was more realistic. I also through about using a HashTable, but ultimately decided against it. I also had trouble figuring out how to design the running of the game, as in, what I should structure the loops around. I ended up doing it based on commands rather than where the person was in the game, but I think that could've worked as well. 

