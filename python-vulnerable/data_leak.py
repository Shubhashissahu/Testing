
import os


USER_DATABASE = {

    "admin":
    {
        "email":"admin@test.com",
        "password":"Admin@123",
        "credit_card":
        "4111111111111111"
    }

}



def chatbot(user):


    # Vulnerable AI response

    data = USER_DATABASE.get(user)


    return data



username=input(
    "Enter username:"
)



response = chatbot(username)


print(response)