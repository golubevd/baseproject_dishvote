Test AdminRestaurantsRestController (application deployed in application context dishvote).

    For windows use Git Bash

get All Restaurants

curl -s http://localhost:8080/dishvote/rest/admin/restaurants --user admin@gmail.com:admin
get Restaurant 200001

curl -s http://localhost:8080/dishvote/rest/admin/restaurants/200001 --user admin@gmail.com:admin
delete Restaurant

curl -s -X DELETE http://localhost:8080/dishvote/rest/admin/restaurants/200001 --user admin@gmail.com:admin
create Restaurant

curl -s -X POST -d '{"title":"craft-pizza'\''s restaurant","address":"Voronezh, 18 Cucigina str.","email":"craft-pizza@mail.ru","site":"craft-pizza.ru"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/dischvote/rest/admin/restaurants --user admin@gmail.com:admin
update Restaurant

curl -s -X PUT -d '{"title":"craft&pizza","address":"Voronezh, 18a Cucigina str.","email":"craft-pizza@mail.ru","site":"craft-pizza.ru"}' -H 'Content-Type: application/json' http://localhost:8080/dishvote/rest/admin/restaurants/200003 --user admin@gmail.com:admin#### update Restaurant
Test AdminDishesRestController (application deployed in application context dishvote).
get All Dishes

curl -s http://localhost:8080/dishvote/rest/admin/dishes --user admin@gmail.com:admin
get Dish 300001

curl -s http://localhost:8080/dishvote/rest/admin/dishes/300001 --user admin@gmail.com:admin
delete Dish

curl -s -X DELETE http://localhost:8080/dishvote/rest/admin/dishes/300001 --user admin@gmail.com:admin
create Dish

curl -s -X POST -d '{"name":"lobster2","price":12000,"restaurant_id":200001}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/dishvote/rest/admin/dishes --user admin@gmail.com:admin
update Dish

curl -s -X PUT -d '{"id":300006,"name":"lobbbbf","price":13000,"registered":"2017-10-01T07:57:48.776+0000","restaurant_id":200001}' -H 'Content-Type: application/json' http://localhost:8080/dishvote/rest/admin/dishes/300006 --user admin@gmail.com:admin#### update Dish
Test AdminDishesOfDayRestController (application deployed in application context dishvote).
get All DishesOfDay

curl -s http://localhost:8080/dishvote/rest/admin/dishesofday --user admin@gmail.com:admin
get DishesOfDay 1

curl -s http://localhost:8080/dishvote/rest/admin/dishesofday/1 --user admin@gmail.com:admin
delete DishesOfDay

curl -s -X DELETE http://localhost:8080/dishvote/rest/admin/dishesofday/1 --user admin@gmail.com:admin
create Dish

curl -s -X POST -d '{"datelunch":"2017-10-01T06:00:00.000+0000","dish_id":300000}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/dishvote/rest/admin/dishesofday --user admin@gmail.com:admin
Test UserRestController (application deployed in application context dishvote).
get All Dishes of Day

curl -s http://localhost:8080/dishvote/rest/dishesofday --user user@yandex.ru:password
get Restaurant and Dishes

curl -s http://localhost:8080/dishvote/rest/rad --user user@yandex.ru:password
get today result of vote

curl -s http://localhost:8080/dishvote/rest/vote/today --user user@yandex.ru:password
get Current User Today Vote

curl -s http://localhost:8080/dishvote/rest/vote/currentuser --user user@yandex.ru:password
vote for Restaurant with id=200001

curl -s -X POST http://localhost:8080/dishvote/rest/vote/200001 --user user@yandex.ru:password
revote the Restaurant with id=200002 by user@yandex.ru

curl -s -X POST http://localhost:8080/dishvote/rest/vote/200002 --user user@yandex.ru:password
delete Vote

curl -s -X DELETE http://localhost:8080/dishvote/rest/vote/0 --user user@yandex.ru:password