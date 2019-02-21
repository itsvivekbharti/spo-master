# Problem Statement
Build a workforce optimization tool for one of our cleaning partners! Our partner has contracts with
several structures all around Berlin. These structures are all of varying size (measured in rooms). The
workforce of our partner is made up of Senior Cleaners and Junior Cleaners. Senior Cleaners have a
higher work capacity than Junior Cleaners. Our partner is free to decide how many Senior and Junior
Cleaners are to be sent to clean a structure but there always needs to be at least one Senior cleaner at
every structure to lead the juniors. The goal is to minimize overcapacity at every structure.
Given an array of structure sizes (in no. of rooms) as well as work capacities of Junior and Senior
Cleaners, your program should present the optimal numbers of Juniors and Seniors for every structure.

## Input:
- array of rooms (int) for every structure
- cleaning capacity Junior Cleaner (int)
- cleaning capacity Senior Cleaner (int)

We do not have cleaning providers with more than 100 structures in their portfolio. None of the structures
will have more than 100 rooms.

## Output:
- array of maps which include the optimal number of Juniors and Seniors for every structure

Examples:
1)
In: { rooms: [35, 21, 17], senior: 10, junior: 6 }
Out: [ {senior: 3, junior: 1}, {senior: 1, junior: 2}, {senior: 2, junior: 0} ]
2)
In: { rooms: [24, 28], senior: 11, junior: 6 }
Out: [ {senior: 2, junior: 1}, {senior: 2, junior: 1} ]
Please provide a git repository where we can see the source code. Use Spring framework and Java 8.
Please write tests. Make your program accessible through a JSON API and provide some documentation
on how to use it.
--------------------------------------------------------------------------------------------------

# Solution Notes

The problem has been solved using Coin changing algorithm using Dynamic Programming.
The logic is to find all combinations of seniors and juniors integer value which can be used to get the desired rooms integer
and filtering the best one out of that.

## Technologies used:
Java, Spring, Lambok, JUnits

## Example request:

http://localhost:8080/workforce
HTTP Method: Post
Request Body: 
`{
  "rooms": [0,1,5,10,22,24,21,49, 73, 100], "senior": 10, "junior": 6
}`
## Headers:
content-type:application/json

## Test Coverage: 91.6%

