# Uparu Mountain Game

## The scenario
I decided to newly develop "Uparu Mountain," a game I had fun playing when I was young, using Java. Because the game is currently out of operation. As someone who loved this game, I'm going to release a game with a similar feel that uses the name Uparu Mountain to honor it. Uparu Mountain is a simple game that basically raises characters called uparu and makes money through uparu. In order to grow Uparu, there must be a habitat where Uparu can stay and a field to grow fruits that are food for Uparu. Since Uparus are also classified through a number of attributes, a habitat suitable for each attribute is needed. 
Here's the whole flow of the game you're currently thinking about. First, it basically offers 100 money and 100 fruits. Users purchase a habitat with the same property as the properties of Uparu they want to raise, and if they purchase a farm, they are ready to grow Uparu. Now, you can buy the desired Uparu and place it in its habitat, make money through it, or feed it to the Uparu to grow it. As it grows, its appearance changes, but since it currently only uses the CLI, I intend to show only the level-up message without changing its appearance. Classes for implementing this include main (Uparu Mountain), Uparu, Habitat, Farm, Inventory, Shops, Users, and enums for implementing property of uparus and habitats. In the main class, the main menu receives the user's information and connects user with the shop or other functions. The Uparu class includes the basic information of Uparu, such as name, property, level, productivity, and price, and can act on feeding and producing money. Habitat classes include names, property, uparu capacity, money capacity, etc. as attributes of the habitat, and can house uparu that has same property with the habitat and store the collected money. The farm class has attributes such as the name of the fruit grown in the farm, the time of fruit production, and the amount of fruit production, and there is a method of growing fruit. The inventory can contain money and fruits produced. At the store, you can purchase a variety of uparu, habitat, and fields. Users can access the store through the main class to purchase and raise the purchased Uparu, habitat, and farms.

## Design
I will create 14 classes for this project. Main class is UparuMountain, it has user and shop as attributes and menu method that has some methods for running application.
User class has inventory, farms, habitats, and basic information of user, like id and name, as attributes, and getter of each attribute, feeding, harvest money and fruits as method.
Inventory class has money and fruits as attributes, and getter, setter, save and consume methods for attributes.
Farms class inherits Records class, which has linkedlist of record, id to generate id and methods that are add, find, show and toString. It has some methods such as menu and selectFarm, and overrides add, find, show and toString from Records class.
Farm class inherits Record class, that has id and name and operates get, set, match, show and toString. It has harvest time, harvest amount and price, and operates set and harvest.
Habitats class inherits Records class. It has some methods such as menu, selectHabitat and overrides add, find, show and toString from Records class.
Habitat class inherits Record class. It has property, moneyCapacity, uparuCapacity, price and uparuInHabitat list and operates get, addUparu, totalMoneyOutput and harvest.
Uparus class inherits Records class. It overrides add, find, show and toString from Records class.
Uparu class inherits Record class. It has property, moneyPerSecond, price, eatenFruitNum and fruitsPerLevel
Property class is enum class for sorting uparu's property so it has various type of uparu like plant, earth, fire, water, etc.
Shop class has three lists for products, which are uparu, habitat and farm. Also, there are some methods for selling products.
In class is for using basic scanner In.

## Chellenges
### InputMismatchException
When another type is inputted by the user at the part where the value is inputted, a type error occurs and the system is terminated. To solve this problem, it catches when another type is received in the in-class, and shows a message to reset and re-enter the scanner. It also went through a lot of trials and errors over the course of two days to solve it, and in the end, it was important to reset the scanner.

### NullCheck
When a value exceeding the list is entered, a null value is stamped and an error occurs. If you create a method to check null and call it in the method of adding the value to the list, you can check the null of the received value and send a message according to the situation.

### ConcurrenctModificationException
This is an error that occurred in the process of removing values according to conditions while traveling through the list. If you remove the value, the index value of the list changes, causing a problem with the traversal. There are many ways to solve this problem, but I solved the simple method, for loop, by changing it to while loop. It's not a real solution, it's a bit of a trick, but I used it because it's a simple method. 


# Uparu Mountain Game GUI with JFrame

1. ~~Drawing ui design~~
2. ~~Coding view panel~~
3. ~~Including models each panel~~
4. ~~Connecting functions each panel~~
5. Design panels

## Requirements
[] Press enter key -> submit
[] Make CardPanel then inherite this to whole card layout and combine navListeners to one.

## Chellenge
[] How uparu list in habitat updates?
[O] if list size 0, buttons cannot visible.

2023/11/29
[O] Update readme
[O] Coding view panel

2023/12/01
[O] Connecting user info

2023/12/02
[O] ShopPanel
[O] Add first main panel

2023/12/04
[O] Add purchase label in ShopPanel
[O] Create NumberInputListener to control input number for various list
[O] Connecting HabitatPanel, FarmPanel and InventoryPanel
[O] Connecting show uparu function of HabitatPanel

2023/12/05
[O] Connecting harvest function of HabitatPanel
[O] Connecting harvest function of FarmPanel
