const express = require("express");

const app = express();

app.use(express.json());


const users = [

    {
        username:"admin",
        password:"admin123"
    }

];



app.post("/login",(req,res)=>{


    const username =
        req.body.username;


    const password =
        req.body.password;



    const user =
        users.find(
            u =>
            u.username === username &&
            u.password === password
        );



    if(user){

        res.json({

            message:"Login success",
            token:"12345"

        });

    }
    else{

        res.status(401)
        .json({
            message:"Invalid"
        });

    }


});


app.listen(3000);