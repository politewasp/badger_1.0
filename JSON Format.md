## Basic Json File Format
### Goal storage

```
{"GoalList": [
	{“name” : “name of goal 1”,
	 “category” : “category from list”,
	 “Description”: “description”,
	 “Start date” : “mm/dd/yyyy”,
	 “Completed”: t/f,
	 “short/long”: s/l ,
	 “Good/bad”: “g/b”,
	 "Habit1":{
  	 	“DaysOfTheWeek”:[1,3,6],(max value 6)
		“message”: “question of data to be logged”,
		“endDate”: “N/A or mm/dd/yyyy”}},
	{“name” : “name of goal 1”,
	 “category” : “category from list”,
	 “Description”: “description”,
	 “Start date” : “mm/dd/yyyy”,
	 “Completed”: t/f,
	 “short/long”: s/l ,
	 “Good/bad”: “g/b”,
	 "Habit1":{
  	 	“DaysOfTheWeek”:[1,3,6],(max value 6)
		“message”: “question of data to be logged”,
		“endDate”: “N/A or mm/dd/yyyy”}}]}
```
### Category storage
```
{“CategoryList”:[
	{“cat name” : “fitness”
	 “Image” : “image data”}
	{“cat name” : “money”
	 “Image” : “image data”}]}
```

