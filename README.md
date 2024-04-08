Design Problem:
You are in charge of making the lines at airport security run smoothly. Every day thousands of people pass through security. There are 3 main types of people who go through this line: economy class passengers, VIP passengers, and flight staff. There is one line but some people have the ability to cut through. The system should allow VIPs and flight staff go straight to the scanners. They are rare occurrences and only appear 1 in every 100 people.

Information about who has more priority out of the Staff or VIP was missing so I assumed that the staff would have more priority, a clarification on this from the client would have been helpful.

How much detail about the passenger should be stored was another question I had. The current requirements could be fulfilled by just using the passenger type but I also added the name of the passenger in the passenger class.

I used a priority queue for the implementation, however, after our discussion on Friday I looked into how priority queues implemented the order of items with the same priority. The items with the same priority do not have a set order and there is some variability in their position in the queue. To address this issue I also added a sequence number to the Passenger class which is updated like a counter to implement a FIFO system for passengers in the same priority classification.
