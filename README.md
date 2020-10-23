# hotel management system
This system is used to manage an entire hotel with unlimited number of rooms and guests. Before any more explanation, it is necessary to mention two main limitations of this system:
1- Each guest can reserve the same room for only one period; Meaning that it can reserve two different rooms for any period, but can not book the same room for 2 different periods.
2- By reservation period, we mean start date, finish date and number of days to stay. For example, 20200105 can be start, 20200107 be finish and 2 can stand for number of days to stay. The logic behind the reservation system must prevent us from reserving the same room for a specific period.  Another limitation of the system is that it can not recognize periods completely and parallel reservations of the same room may occur in some cases!  But we guarantee that if all period parameters (start, finish and days to stay) were the same, the system would function properly and without any bugs.
Now let’s take a look at the system and its classes. Documentation is available in the code as well.

There are 7 classes and enums in this program:
1- Main class which performs a command interface for the system user
2- Room class which represents a room in the hotel
3- Guest class which represents a guest in the hotel
4- Date class which represents a reservation period
5- View enum which specifies the room view
6- Type enum which specifies the room type
7- Hotel class which represents an entire hotel

