# user_signup_signin

i have never done a spring security task in my entire freelancing career but howeveer i have mannage the user authentication at the controller
the time limit is less and if i got more time i'll definately done the token basedd authorization and add the security in the project with the help of the search power and techique.

it was a very nice experience for me if i'm not the good fit at the experience level you can please consider me as a fresher i'm ready to work as both fresher as well as experienced.

new come to the assignment part...

i have created the one user entity and also created the controller and reposiory for the same.

i have tasted all the apis it works fine for me.

attaching some screenshot here.


User sign up:

url endpoint : http://localhost:8080/api/signup

request body: 
{
    "name":"kaif momin",
    "userName":"kaif007",
    "email":"kaifu@gmail.com",
    "password":"kaif1234",
    "mobileNumber":"9864354643",
    "gender":"male",
    "age":"21",
    "createdDate":"2021-01-24"
}

response body:

{
    "id":1,
    "name":"kaif momin",
    "userName":"kaif007",
    "email":"kaifu@gmail.com",
    "password":"kaif1234",
    "mobileNumber":"9864354643",
    "gender":"male",
    "age":"21",
    "createdDate":"2021-01-24"
}

User Login with username and password:

url endpoint: http://localhost:8080/api/signin/userName/kaif007/password/kaif1234

this is the get api.
response body:

{
    "id": 1,
    "name": "kaif momin",
    "userName": "kaif007",
    "email": "kaifu@gmail.com",
    "password": "kaif1234",
    "mobileNumber": "9864354643",
    "gender": "male",
    "age": 21,
    "createdDate": "2021-01-24"
}

Ceate new user with the existing username:

if i'm going to create the new user with the same username then i'll throw me the exception of username is already exists.

url endpoint: http://localhost:8080/api/signup

request body: 
{
    "name":"kaif momin",
    "userName":"kaif007",
    "email":"kaifu@gmail.com",
    "password":"kaif1234",
    "mobileNumber":"9864354643",
    "gender":"male",
    "age":"21",
    "createdDate":"2021-01-24"
}

response body:

Username is already exist.






